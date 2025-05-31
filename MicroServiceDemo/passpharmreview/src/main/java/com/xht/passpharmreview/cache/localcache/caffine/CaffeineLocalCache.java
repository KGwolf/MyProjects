package com.xht.passpharmreview.cache.localcache.caffine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.xht.passpharmreview.cache.localcache.LocalCacheBase;
import com.xht.passpharmreview.cache.localcache.MapLocalCacheBase;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: CaffeineLocalCache
 * @Description: 本地缓存 咖啡因
 * 这里应该再封装一层，应该操作cachename才对，然后方法里面传过来的key，就是hashmap里面对应的key
 * 所以这里也要向redis那样写才行？
 * @Author: xiahaitao
 * @Date: 2025/3/28 14:35
 * @Version: V1.0
 */
@Component
public class CaffeineLocalCache <K, V> implements MapLocalCacheBase<K, V> {
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
        cache.putAll(map);
    }

    //这个操作不适用，操作数据量太多
    @Override
    public Collection<V> getAll() {
        return Collections.emptyList();
    }

    @Override
    public Collection<V> getMany(Collection<K> keys) {
        return cache.getAllPresent(keys).values();
    }

    @Override
    public void removeMany(Collection<K> keys) {
        cache.invalidateAll(keys);
    }

    @Override
    public void removeAll() {
        cache.invalidateAll();
    }
}
