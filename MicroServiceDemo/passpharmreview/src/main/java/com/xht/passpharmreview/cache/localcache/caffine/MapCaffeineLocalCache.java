package com.xht.passpharmreview.cache.localcache.caffine;

import com.github.benmanes.caffeine.cache.Cache;
import com.xht.passpharmreview.cache.localcache.LocalCacheBase;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * @ClassName: CaffeineLocalCache
 * @Description: 本地缓存 咖啡因
 * 这里应该再封装一层，应该操作cachename才对，然后方法里面传过来的key，就是hashmap里面对应的key
 * 所以这里也要向redis那样写才行？
 *
 * caffeine有一个问题，存储map结构的时候，比如：hashkey: pr_pharmacist,  Map<userid,pharmacymodel>，通过hashkey找到药师缓存的所有内容，
 * 这样的缓存还有很多，比如，医生，任务，药品等等。
 * 有一个缺点，就是更新单个字段需要全量替换真个Map，还有就是map的数量太大的时候，加载一次很费内存。比如药品几十万条。
 * 然而根据业务的性质，我们更新的时候，确实是全量加载来替换的。
 *
 * Caffeine的缓存有3种方式：嵌套Map、复合键、自定义Wrapper
 * @Author: xiahaitao
 * @Date: 2025/3/28 14:35
 * @Version: V1.0
 */
public class MapCaffeineLocalCache<K, V> implements LocalCacheBase<K, V> {
    private final Cache<K, V> cache;

    public MapCaffeineLocalCache(Cache<K, V> cache) {
        this.cache = cache;
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
    public Map<K, V> getAll() {
        return cache.asMap();
    }

    @Override
    public Map<K, V> getMany(Collection<K> keys) {
        return cache.getAllPresent(keys);
    }

    @Override
    public void removeMany(Collection<K> keys) {
        cache.invalidateAll(keys);
    }

    @Override
    public void removeAll() {
        cache.invalidateAll();
    }

    @Override
    public boolean hasData() {
        return false;
    }
}
