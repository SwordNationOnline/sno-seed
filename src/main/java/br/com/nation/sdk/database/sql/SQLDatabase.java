package br.com.nation.sdk.database.sql;

import br.com.nation.sdk.database.DatabaseService;
import com.zaxxer.hikari.HikariDataSource;
import lombok.Getter;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
public class SQLDatabase implements DatabaseService {

    private final HikariDataSource dataSource;
    @Getter private Connection connection;

    public SQLDatabase(String username, String password, String jdbcUrl) {
        this.dataSource = new HikariDataSource();
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    }

    @Override
    public boolean connect() {
        try {
            if (connection == null)
                this.connection = dataSource.getConnection();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean disconnect() {
        try {
            dataSource.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return !isConnected();
    }

    @Override
    public boolean isConnected() {
        try {
            return dataSource.isRunning() && !connection.isClosed();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
