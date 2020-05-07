package br.com.nation.sdk.database.sql.result;

import lombok.Getter;

import java.util.*;

/**
 * @author Henry Fábio
 * Github: https://github.com/HenryFabio
 */
@SuppressWarnings("unchecked")
@Getter
public final class SQLResult<T extends Enum<T>> {

    private Map<String, Collection<Object>> values = new LinkedHashMap<>();
    private int size;

    public SQLResult<T> set(String column, Object object) {
        values.computeIfAbsent(column, k -> new LinkedList<>()).add(object);
        return this;
    }

    public <U> Optional<U> get(String column) {
        try {
            return Optional.ofNullable((U) values.get(column).stream().findFirst().orElse(null));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public <U> Optional<U> get(T column) {
        return get(column.toString());
    }

    public <U> Optional<List<U>> getList(String column) {
        try {
            return Optional.ofNullable((List<U>) values.get(column));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public <U> Optional<List<U>> getList(T column) {
        return getList(column.toString());
    }

    public void addSize() {
        size++;
    }

}
