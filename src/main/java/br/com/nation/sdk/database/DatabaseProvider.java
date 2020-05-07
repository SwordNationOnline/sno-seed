package br.com.nation.sdk.database;

import br.com.nation.sdk.database.sql.SQLDatabase;
import lombok.Getter;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@Getter
public final class DatabaseProvider {

    private final SQLDatabase sqlDatabase;

    public DatabaseProvider() {
        this.sqlDatabase = new SQLDatabase("root", "", "jdbc:mysql://localhost:3306/test");
    }

    public boolean setup() {
        return sqlDatabase.connect();
    }

}
