package br.com.nation.api.repository;

import java.util.Map;

public interface Repository<K, V> {

    Map<K, V> getMap();

    void put(K key, V value);

    void remove(K key, V value);

    V find(K key);

}
