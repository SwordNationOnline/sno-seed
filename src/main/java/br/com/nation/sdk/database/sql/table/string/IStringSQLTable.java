package br.com.nation.sdk.database.sql.table.string;

import br.com.nation.sdk.database.sql.execution.SQLExecution;
import br.com.nation.sdk.database.sql.result.SQLResult;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
public interface IStringSQLTable<T extends Enum<T>> {

    SQLExecution<Integer> insert(String value, Map<T, Object> columns);
    default Integer syncInsert(String value, Map<T, Object> columns) {
        return insert(value, columns).sync();
    }
    default CompletableFuture<Integer> asyncInsert(String value, Map<T, Object> columns) {
        return insert(value, columns).async();
    }

    SQLExecution<Integer> replace(String value, Map<T, Object> columns);
    default Integer syncReplace(String value, Map<T, Object> columns) {
        return replace(value, columns).sync();
    }
    default CompletableFuture<Integer> asyncReplace(String value, Map<T, Object> columns) {
        return replace(value, columns).async();
    }

    SQLExecution<SQLResult<T>> select(String value, T... columns);
    default SQLResult<T> syncSelect(String value, T[] columns) {
        return select(value, columns).sync();
    }
    default CompletableFuture<SQLResult<T>> asyncSelect(String value, T[] columns) {
        return select(value, columns).async();
    }

    SQLExecution<Integer> update(String value, T column, Object input);
    default Integer syncUpdate(String value, T column, Object input) {
        return update(value, column, input).sync();
    }
    default CompletableFuture<Integer> asyncUpdate(String value, T column, Object input) {
        return update(value, column, input).async();
    }

    SQLExecution<Integer> delete(String value);
    default Integer syncDelete(String value) {
        return delete(value).sync();
    }
    default CompletableFuture<Integer> asyncDelete(String value) {
        return delete(value).async();
    }

    void createDefaultTable();

}
