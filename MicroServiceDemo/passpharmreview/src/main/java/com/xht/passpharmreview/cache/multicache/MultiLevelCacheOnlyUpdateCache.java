package com.xht.passpharmreview.cache.multicache;

import com.xht.passpharmreview.cache.CacheBase;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-03-30  17:29
 * @Description: TODO
 * @Version: 1.0
 **/
public class MultiLevelCacheOnlyUpdateCache  <K,V> implements CacheBase<K,V> {

    private final CacheBase<K,V> localCache;

    private final CacheBase<K,V> remoteCache;

    public MultiLevelCacheOnlyUpdateCache(CacheBase<K,V> localCache,CacheBase<K,V> remoteCache) {
        this.localCache = localCache;
        this.remoteCache = remoteCache;
    }

    @Override
    public V get(K key) {
        throw new UnsupportedOperationException("不支持该操作");
    }
    @Override
    public void put(K key, V value) {
        //这里会不会有缓存一致性问题呢？ 用途只能是更新倒计时信息。所以不在乎一致性，取缓存的时候，会检查一遍remaintime是不是正确的。
        localCache.put(key,value);
        remoteCache.put(key,value);
    }

    @Override
    public void remove(K key) {
        throw new UnsupportedOperationException("不支持该操作");
    }

    @Override
    public void putMany(Map<K, V> map) {

    }

    @Override
    public Collection<V> getAll() {
        return Collections.emptyList();
    }

    @Override
    public Collection<V> getMany(Collection<K> keys) {
        return null;
    }

    @Override
    public void removeMany(Collection<K> keys) {

    }

    @Override
    public void removeAll() {

    }
}
