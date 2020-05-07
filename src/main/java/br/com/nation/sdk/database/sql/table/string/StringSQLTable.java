package br.com.nation.sdk.database.sql.table.string;

import br.com.nation.sdk.database.sql.execution.SQLExecution;
import br.com.nation.sdk.database.sql.result.SQLResult;
import br.com.nation.sdk.database.sql.table.SQLTable;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@SuppressWarnings({"all"})
public abstract class StringSQLTable<T extends Enum<T>> extends SQLTable<T> implements IStringSQLTable<T> {

    public StringSQLTable(String table) {
        super(table);
    }

    public SQLExecution<Integer> insert(String value, Map<T, Object> columns) {
        return super.insert(ImmutableMap.<T, Object>builder()
                .putAll(columns)
                .put(getDefaultColumn(), value)
                .build()
        );
    }

    public SQLExecution<Integer> replace(String value, Map<T, Object> columns) {
        return super.replace(ImmutableMap.<T, Object>builder()
                .putAll(columns)
                .put(getDefaultColumn(), value)
                .build()
        );
    }

    public SQLExecution<SQLResult<T>> select(String value, T... columns) {
        return super.select(columns, ImmutableMap.of(getDefaultColumn(), value));
    }

    public SQLExecution<Integer> update(String value, T column, Object input) {
        return super.update(column, input, ImmutableMap.of(getDefaultColumn(), value));
    }

    public SQLExecution<Integer> delete(String value) {
        return super.delete(ImmutableMap.of(getDefaultColumn(), value));
    }

    abstract public T getDefaultColumn();

}
