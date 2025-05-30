package com.xht.passpharmreview.cache.cachedesign;

import com.xht.passpharmreview.cache.CacheBase;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;

/**
 * @ClassName: CacheReadThrough
 * @Description: 读穿透缓存模式，根据传进来的缓存类型（本地缓存、redis等）、从数据库获取数据的方法，来进行获取数据操作
 * 有个问题：如果这样写，就不能把操作数据库的东西，放队列里面了。 那是不是说，这种缓存模式，只适用于实时的操作？
 * @Author: xiahaitao
 * @Date: 2025/3/28 14:42
 * @Version: V1.0
 */
public class CacheReadThrough<K,V> implements CacheBase<K,V> {

    private final CacheBase<K,V> cache;

    // 定义一个私有的 Function 变量，类似于 C# 的 Func<K, V>
    private final Function<K, V> getFunc;
    public CacheReadThrough(CacheBase<K,V> cache, Function<K, V> getFunc) {
        this.cache = cache;
        this.getFunc = getFunc;
    }

    @Override
    public V get(K key) {
        //先读缓存
        V cacheRes = cache.get(key);

        if (cacheRes == null)
        {
            V dbRes = getFunc.apply(key);
            if (dbRes != null)
            {
                cache.put(key,dbRes);
            }
        }
        return cacheRes;
    }
    @Override
    public void put(K key, V value) {
        cache.put(key,value);
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
