package database;

import br.com.nation.api.database.DatabaseSustainer;
import br.com.nation.api.prototype.humanoid.Humanoid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Supplier;

public class SimpleDatabase extends DatabaseSustainer {

    @Override
    public Supplier<Connection> openConnection() {
        return () -> {
            try {
                connection = DriverManager.getConnection("mysqlaquiporra");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                return connection;
            }
        };
    }

    @Override
    public Supplier<Connection> closeConnection() {
        return () -> {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                return connection;
            }
        };
    }

    {
        query(Humanoid.class, "SELECT * FROM humanoidData WHERE playerName = ?", result -> {
            System.out.println(result.getString("bundas")); return null;
        }, "humanoid");

        querys("SELECT * FROM humanoidData", resultSet -> {
            while(resultSet.next()) {
                System.out.println("outro cornokkkkkkkkk");
            } return null;
        });

        execute("INSERT INTO bundas VALUES (?,?)", "rogerinholinguiçaqueimada", "comedor de casada");

        update("UPDATE bundas SET playerName = ? WHERE playerName = ?", "gay", "rogerinholinguiçaqueimada");
    }

}
