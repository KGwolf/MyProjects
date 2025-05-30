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
 * @ClassName: MultiLevelCacheDelayDoubleDelete
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 15:38
 * @Version: V1.0
 */
public class MultiLevelCacheDelayDoubleDelete <K,V> implements CacheBase<K,V> {

    private final CacheBase<K,V> localCache;

    private final CacheBase<K,V> remoteCache;

    // 定义一个私有的 Function 变量，类似于 C# 的 Func<K, V>
    private final BiFunction<K, V, V> putFunc;

    private final ScheduledExecutorService scheduler;
    // 延迟时间，单位为秒
    private static final long DELAY_TIME = 1;

    public MultiLevelCacheDelayDoubleDelete(CacheBase<K,V> localCache,CacheBase<K,V> remoteCache, BiFunction<K, V, V> putFunc) {
        this.localCache = localCache;
        this.remoteCache = remoteCache;
        this.putFunc = putFunc;
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public V get(K key) {
       throw new UnsupportedOperationException("不支持该操作");
    }
    @Override
    public void put(K key, V value) {
        //1.先删除缓存
        localCache.remove(key);
        remoteCache.remove(key);
        //2。修改数据库
        putFunc.apply(key, value);



        // 调度第二次删除缓存的任务
        scheduler.schedule(() -> {
            localCache.remove(key);
            remoteCache.remove(key);
        }, DELAY_TIME, TimeUnit.SECONDS);

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
