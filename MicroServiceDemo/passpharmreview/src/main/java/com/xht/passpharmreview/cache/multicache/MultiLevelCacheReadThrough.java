package com.xht.passpharmreview.cache.multicache;

import com.xht.passpharmreview.cache.CacheBase;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName: MultiLevelCacheReadThrough
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 17:02
 * @Version: V1.0
 */
public class MultiLevelCacheReadThrough  <K,V> implements CacheBase<K,V> {

    private final CacheBase<K,V> localCache;

    private final CacheBase<K,V> remoteCache;

    private final Function<K, V> getFunc;


    public MultiLevelCacheReadThrough(CacheBase<K,V> localCache,CacheBase<K,V> remoteCache, Function<K, V> getFunc) {
        this.localCache = localCache;
        this.remoteCache = remoteCache;
        this.getFunc = getFunc;
    }

    @Override
    public V get(K key) {
        //1.先从本地缓存取值
        V localRes = localCache.get(key);
        if (localRes != null)
        {
            return localRes;
        }
        //2.从redis取值
        V remoteRes = remoteCache.get(key);
        if (remoteRes != null)
        {
            return remoteRes;
        }
        V dbRes = getFunc.apply(key);
        if (dbRes != null)
        {
            //设置缓存
            localCache.put(key, dbRes);
            remoteCache.put(key,dbRes);

            return dbRes;
        }
        return null;
    }
    @Override
    public void put(K key, V value) {
       throw new UnsupportedOperationException("不支持该操作");

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
}
