package com.ice.automation.commons.cache;


public interface Cache<K, V> {

    void initializeCache();

    void reloadCache();

    V get(K key);

    void set(K key, V value);

    int size();
}
