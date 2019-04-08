package com.ice.automation.commons.cache;

import javax.annotation.PostConstruct;
import java.util.Map;


public abstract class MemCache<K, V> implements Cache<K, V> {

    private Map<K, V> cachedObjects;

    @PostConstruct
    protected final void initialize() {
        cachedObjects = loadFromPersistentStorage();
    }

    protected abstract Map<K, V> loadFromPersistentStorage();

    public void initializeCache() {
        reloadCache();
    }

    public void reloadCache() {
        cachedObjects = loadFromPersistentStorage();
    }

    public V get(K key) {
        return cachedObjects.get(key);
    }

    public void set(K key, V value) {
        cachedObjects.put(key, value);
    }

    public int size() {
        return cachedObjects.size();
    }
}
