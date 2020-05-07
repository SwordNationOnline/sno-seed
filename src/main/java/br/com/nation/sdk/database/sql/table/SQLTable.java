package br.com.nation.sdk.database.sql.table;

import br.com.nation.sdk.database.sql.execution.SQLExecution;
import br.com.nation.sdk.database.sql.provider.SQLProvider;
import br.com.nation.sdk.database.sql.query.SQLQuery;
import br.com.nation.sdk.database.sql.query.builder.QueryBuilder;
import br.com.nation.sdk.database.sql.result.SQLResult;
import br.com.nation.sdk.util.ArrayUtils;
import br.com.nation.sdk.util.BooleanUtils;
import lombok.Getter;

import java.util.Map;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@Getter
public abstract class SQLTable<T extends Enum<T>> implements ISQLTable<T> {

    protected final SQLProvider<T> provider;
    protected final String table;

    public SQLTable(String table) {
        this.table = table;
        this.provider = new SQLProvider<>();
    }

    public void createTable(Map<T, String> columns) {
        provider.executeUpdate(SQLQuery
                .createBuilder(table)
                .createTable(columns.keySet().toArray(new Enum[]{}), columns.values().toArray(new String[]{}))
        ).sync();
    }

    public SQLExecution<Integer> insert(Map<T, Object> columns) {
        return provider.executeUpdate(SQLQuery
                        .createBuilder(table)
                        .insert(columns.keySet().toArray(new Enum[]{})),
                columns.values().toArray()
        );
    }

    public SQLExecution<Integer> replace(Map<T, Object> columns) {
        return provider.executeUpdate(SQLQuery
                        .createBuilder(table)
                        .replace(columns.keySet().toArray(new Enum[]{})),
                columns.values().toArray()
        );
    }

    public SQLExecution<SQLResult<T>> select(T[] columns, Map<T, Object> whereColumns) {
        QueryBuilder builder = SQLQuery.createBuilder(table).select(columns);
        BooleanUtils.checkBoolean(whereColumns != null, whereColumns,
                $ -> builder.where($.keySet().toArray(new Enum[]{})), null
        );
        return provider.executeQuery(builder, whereColumns != null ? whereColumns.values().toArray() : null);
    }

    public SQLExecution<Integer> update(T column, Object input, Map<T, Object> whereColumns) {
        return provider.executeUpdate(SQLQuery.createBuilder(table)
                        .update(column)
                        .where(whereColumns.keySet().toArray(new Enum[]{})),
                ArrayUtils.linkedMerge(new Object[]{input}, whereColumns.values().toArray())
        );
    }

    public SQLExecution<Integer> delete(Map<T, Object> whereColumns) {
        return provider.executeUpdate(SQLQuery.createBuilder(table)
                        .delete()
                        .where(whereColumns.keySet().toArray(new Enum[]{})),
                whereColumns.values().toArray()
        );
    }

}
