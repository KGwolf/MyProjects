package com.xht.passpharmreview.cache.cachedesign;

import com.xht.passpharmreview.cache.CacheBase;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @ClassName: CacheReadThrough
 * @Description: 读穿透缓存模式，根据传进来的缓存类型（本地缓存、redis等）、从数据库获取数据的方法，来进行获取数据操作
 * 有个问题：如果这样写，就不能把操作数据库的东西，放队列里面了。 那是不是说，这种缓存模式，只适用于实时的操作？
 * @Author: xiahaitao
 * @Date: 2025/3/28 14:42
 * @Version: V1.0
 */
public class CacheReadThrough<K, V> implements CacheBase<K, V> {

    private final CacheBase<K, V> cache;

    // 定义一个私有的 Function 变量，类似于 C# 的 Func<K, V>
    private final Function<K, V> getFunc;

    private final Supplier<Map<K,V>> getAllFunc;
    private final Function<Collection<K>, Map<K,V>> getManyFunc;

    // 私有构造器，通过Builder创建实例
    private CacheReadThrough(Builder<K, V> builder) {
        this.cache = builder.cache;
        this.getFunc = builder.getFunc;
        this.getAllFunc = builder.getAllFunc;
        this.getManyFunc = builder.getManyFunc;
    }
    // 建造者类
    public static class Builder<K, V> {
        private final CacheBase<K, V> cache;
        private Function<K, V> getFunc;
        private Supplier<Map<K, V>> getAllFunc;
        private Function<Collection<K>, Map<K, V>> getManyFunc;

        public Builder(CacheBase<K, V> cache) {
            this.cache = cache;
        }

        public Builder<K, V> withGetFunc(Function<K, V> getFunc) {
            this.getFunc = getFunc;
            return this;
        }

        public Builder<K, V> withGetAllFunc(Supplier<Map<K, V>> getAllFunc) {
            this.getAllFunc = getAllFunc;
            return this;
        }

        public Builder<K, V> withGetManyFunc(Function<Collection<K>, Map<K, V>> getManyFunc) {
            this.getManyFunc = getManyFunc;
            return this;
        }

        public CacheReadThrough<K, V> build() {
            // 至少提供一种加载方式
            if (getFunc == null && getAllFunc == null && getManyFunc == null) {
                throw new IllegalArgumentException("至少需要提供一种加载函数");
            }
            return new CacheReadThrough<>(this);
        }
    }

    @Override
    public boolean hasData() {
        return true;
    }
    @Override
    public V get(K key) {
        //先读缓存
        V cacheRes = cache.get(key);

        if (cacheRes == null) {
            V dbRes = getFunc.apply(key);
            if (dbRes != null) {
                cache.put(key, dbRes);
            }
        }
        return cacheRes;
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    @Override
    public void putMany(Map<K, V> map) {
        cache.putMany(map);
    }

    /***
     * @param
     * @return java.lang.String
     * @Description 能否用于初始化的时候加载数据？
     * @Author xiahaitao
     * @Date 2025/5/28 20:57
     */
    @Override
    public Map<K, V> getAll() {
        //先读缓存
        if (cache.hasData()) {
            Map<K, V> cacheRes = cache.getAll();
            return cacheRes;
        }else{
            Map<K, V> dbRes = getAllFunc.get();
            if (dbRes != null) {
                cache.putMany(dbRes);
            }
            return dbRes;
        }
    }

    /***
     * @param
     * @return java.lang.String
     * @Description 如果其中一部分缓存里面没有怎么办？
     * 还是麻烦，要缓存的框架支持高性能的多个key值查找。还要返回没有值的那些key集合，好方便查找然后放入到缓存中。
     * @Author xiahaitao
     * @Date 2025/5/28 20:57
     */
    @Override
    public Map<K, V> getMany(Collection<K> keys) {
        return cache.getMany(keys);
    }

    @Override
    public void removeMany(Collection<K> keys) {
        cache.removeMany(keys);
    }

    @Override
    public void removeAll() {
        cache.removeAll();
    }
}
