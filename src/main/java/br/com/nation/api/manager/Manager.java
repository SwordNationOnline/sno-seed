package br.com.nation.api.manager;

import java.util.List;

public interface Manager<T, U> {

    List<T> getList();

    void put(T t);

    void remove(T t);

    T find(U uniqueID);

}
