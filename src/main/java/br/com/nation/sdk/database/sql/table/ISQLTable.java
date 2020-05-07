package br.com.nation.sdk.database.sql.table;

import br.com.nation.sdk.database.sql.execution.SQLExecution;
import br.com.nation.sdk.database.sql.result.SQLResult;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
public interface ISQLTable<T extends Enum<T>> {

    void createTable(Map<T, String> columns);

    SQLExecution<Integer> insert(Map<T, Object> columns);
    default Integer syncInsert(Map<T, Object> columns) {
        return insert(columns).sync();
    }
    default CompletableFuture<Integer> asyncInsert(Map<T, Object> columns) {
        return insert(columns).async();
    }

    SQLExecution<Integer> replace(Map<T, Object> columns);
    default Integer syncReplace(Map<T, Object> columns) {
        return replace(columns).sync();
    }
    default CompletableFuture<Integer> asyncReplace(Map<T, Object> columns) {
        return replace(columns).async();
    }

    SQLExecution<SQLResult<T>> select(T[] columns, Map<T, Object> whereColumns);
    default SQLResult<T> syncSelect(T[] columns, Map<T, Object> whereColumns) {
        return select(columns, whereColumns).sync();
    }
    default CompletableFuture<SQLResult<T>> asyncSelect(T[] columns, Map<T, Object> whereColumns) {
        return select(columns, whereColumns).async();
    }

    SQLExecution<Integer> update(T column, Object input, Map<T, Object> whereColumns);
    default Integer syncUpdate(T column, Object input, Map<T, Object> whereColumns) {
        return update(column, input, whereColumns).sync();
    }
    default CompletableFuture<Integer> asyncUpdate(T column, Object input, Map<T, Object> whereColumns) {
        return update(column, input, whereColumns).async();
    }

    SQLExecution<Integer> delete(Map<T, Object> whereColumns);
    default Integer syncDelete(Map<T, Object> whereColumns) {
        return delete(whereColumns).sync();
    }
    default CompletableFuture<Integer> asyncDelete(Map<T, Object> whereColumns) {
        return delete(whereColumns).async();
    }

    void createDefaultTable();

}
