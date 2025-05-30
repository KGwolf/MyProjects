package com.xht.passpharmreview.cache.localcache.caffine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.xht.passpharmreview.cache.localcache.LocalCacheBase;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CaffeineLocalCache
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 14:35
 * @Version: V1.0
 */
@Component
public class CaffeineLocalCache <K, V> implements LocalCacheBase<K, V> {
    private final Cache<K, V> cache;

    public CaffeineLocalCache() {
        this.cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();
    }

    @Override
    public V get(K key) {
        return cache.getIfPresent(key);
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public void remove(K key) {
        cache.invalidate(key);
    }

    @Override
    public void putMany(Map<K, V> map) {

    }

    @Override
    public Collection<V> getAll() {
        return Collections.emptyList();
    }
}
