package com.xht.passpharmreview.cache.cachedesign;

import com.xht.passpharmreview.cache.CacheBase;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName: CacheWriteThrough
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 14:56
 * @Version: V1.0
 */
public class CacheWriteThrough<K,V>  implements CacheBase<K,V> {

    private final CacheBase<K,V> cache;

    // 定义一个私有的 BiFunction 变量，类似于 C# 的 Func<K, V, V>
    private final  BiFunction<K, V, V> putFunc;

    public CacheWriteThrough(CacheBase<K,V> cache, BiFunction<K, V, V> putFunc) {
        this.cache = cache;
        this.putFunc = putFunc;
    }

    @Override
    public V get(K key) {
        return cache.get(key);
    }
    @Override
    public void put(K key, V value) {
        //先处理数据库
        putFunc.apply(key, value);
        //再处理缓存
        cache.put(key, value);
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    @Override
    public void putMany(Map<K, V> map) {

    }

    @Override
    public Collection<V> getAll() {
        return Collections.emptyList();
    }
}
