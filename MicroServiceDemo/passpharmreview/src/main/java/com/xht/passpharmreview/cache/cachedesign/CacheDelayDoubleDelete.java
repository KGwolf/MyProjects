package com.xht.passpharmreview.cache.cachedesign;

import com.xht.passpharmreview.cache.CacheBase;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName: CacheDelayDoubleDelete
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 15:31
 * @Version: V1.0
 */
public class CacheDelayDoubleDelete<K,V> implements CacheBase<K,V> {

    private final CacheBase<K,V> cache;

    // 定义一个私有的 Function 变量，类似于 C# 的 Func<K, V>
    private final BiFunction<K, V, V> putFunc;

    private final ScheduledExecutorService scheduler;
    // 延迟时间，单位为秒
    private static final long DELAY_TIME = 1;

    public CacheDelayDoubleDelete(CacheBase<K,V> cache, BiFunction<K, V, V> putFunc) {
        this.cache = cache;
        this.putFunc = putFunc;
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    @Override
    public V get(K key) {
        //先读缓存
        return cache.get(key);
    }
    @Override
    public void put(K key, V value) {
        //1、先删除缓存
        cache.remove(key);
        V res = putFunc.apply(key, value);
        // 调度第二次删除缓存的任务
        scheduler.schedule(() -> {
            cache.remove(key);
        }, DELAY_TIME, TimeUnit.SECONDS);

    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }
}
