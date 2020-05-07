package br.com.nation.sdk.database.sql.provider;

import br.com.nation.sdk.database.sql.execution.SQLExecution;
import br.com.nation.sdk.database.sql.query.SQLQuery;
import br.com.nation.sdk.database.sql.query.builder.QueryBuilder;
import br.com.nation.sdk.database.sql.result.SQLResult;

import java.sql.PreparedStatement;
import java.util.Optional;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
public interface ISQLProvider<T extends Enum<T>> {

    Optional<PreparedStatement> prepareQuery(SQLQuery query);

    SQLExecution<SQLResult<T>> executeQuery(SQLQuery query, Object... objects);
    default SQLExecution<SQLResult<T>> executeQuery(QueryBuilder queryBuilder, Object... objects) {
        return executeQuery(queryBuilder.build(), objects);
    }

    SQLExecution<Integer> executeUpdate(SQLQuery query, Object... objects);
    default SQLExecution<Integer> executeUpdate(QueryBuilder queryBuilder, Object... objects) {
        return executeUpdate(queryBuilder.build(), objects);
    }

}
