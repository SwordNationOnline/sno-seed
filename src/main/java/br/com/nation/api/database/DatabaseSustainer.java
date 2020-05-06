package br.com.nation.api.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public abstract class DatabaseSustainer {

    private final ExecutorService executorService = Executors.newFixedThreadPool(2);
    protected Connection connection;

    public abstract Supplier<Connection> openConnection();

    public abstract Supplier<Connection> closeConnection();

    public Connection getConnection() {
        return connection;
    }

    public <T> Optional<T> query(Class<T> clazz, String query, DatabaseResult<T> result, Object... objects) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            applyGeneric(preparedStatement, objects);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) return Optional.of(result.accept(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        } return Optional.empty();
    }

    public void execute(String execute, Object... objects) {
        CompletableFuture.runAsync(() -> {
            try(PreparedStatement preparedStatement = connection.prepareStatement(execute)) {
                applyGeneric(preparedStatement, objects);

                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, executorService);
    }

    public void update(String update, Object... objects) {
        CompletableFuture.runAsync(() -> {
            try(PreparedStatement preparedStatement = connection.prepareStatement(update)) {
                applyGeneric(preparedStatement, objects);

                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, executorService);
    }

    public void querys(String query, DatabaseResult<Void> result, Object... objects) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            applyGeneric(preparedStatement, objects);

            ResultSet resultSet = preparedStatement.executeQuery();

            result.accept(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void applyGeneric(PreparedStatement stm, Object... obj) throws SQLException {
        for(int i = 0; i!=obj.length; i++) if(obj[i] != null) DatabaseAdapter.getInstance().setGeneric(stm, i+1, obj[i]);
    }

    public interface DatabaseResult<T> {
        T accept(ResultSet resultSet) throws SQLException;
    }

    protected static final class DatabaseAdapter {

        public static DatabaseAdapter adapter;

        public static DatabaseAdapter getInstance() {
            if(adapter == null) adapter = new DatabaseAdapter();

            return adapter;
        }

        public void setGeneric(PreparedStatement stm, int index, Object obj) throws SQLException {
            switch(obj.getClass().getSimpleName()) {
                case "String":
                    stm.setString(index, (String) obj); break;
                case "Integer":
                    stm.setInt(index, (Integer) obj); break;
                case "Byte":
                    stm.setInt(index, ((Byte) obj).intValue()); break;
                case "Short":
                    stm.setShort(index, (Short) obj); break;
                case "Long":
                    stm.setLong(index, (Long) obj); break;
                case "Float":
                    stm.setFloat(index, (Float) obj); break;
                case "Double":
                    stm.setDouble(index, (Double) obj); break;
                case "Boolean":
                    stm.setBoolean(index, (Boolean) obj); break;
            }
        }
    }

}
