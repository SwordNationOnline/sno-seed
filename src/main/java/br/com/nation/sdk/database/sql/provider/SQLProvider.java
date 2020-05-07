package br.com.nation.sdk.database.sql.provider;

import br.com.nation.SAOSeed;
import br.com.nation.sdk.database.sql.execution.SQLExecution;
import br.com.nation.sdk.database.sql.query.SQLQuery;
import br.com.nation.sdk.database.sql.result.SQLResult;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
public final class SQLProvider<T extends Enum<T>> implements ISQLProvider<T> {

    private static Connection connection;

    static {
        SQLProvider.connection = SAOSeed.getInstance().getSeedAPI().getDatabaseProvider().getSqlDatabase().getConnection();
    }

    @Override
    public Optional<PreparedStatement> prepareQuery(SQLQuery query) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query.getQuery());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(preparedStatement);
    }

    @Override
    public SQLExecution<SQLResult<T>> executeQuery(SQLQuery query, Object... objects) {
        return new SQLExecution<>(() -> {
            SQLResult<T> sqlResult = new SQLResult<>();
            prepareQuery(query).ifPresent(statement -> {
                try {
                    if (objects != null) {
                        for (int i = 0; i < objects.length; i++) {
                            statement.setObject(i + 1, objects[i]);
                        }
                    }

                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        for (String column : query.getColumns()) {
                            sqlResult.set(column, resultSet.getObject(column));
                        }
                        sqlResult.addSize();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            return sqlResult;
        });
    }

    @Override
    public SQLExecution<Integer> executeUpdate(SQLQuery query, Object... objects) {
        return new SQLExecution<>(() -> {
            AtomicInteger reference = new AtomicInteger(-1);
            prepareQuery(query).ifPresent(statement -> {
                try {
                    if (objects != null) {
                        for (int i = 0; i < objects.length; i++) {
                            statement.setObject(i + 1, objects[i]);
                        }
                    }
                    reference.set(statement.executeUpdate());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            return reference.get();
        });
    }

}