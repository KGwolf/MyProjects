package com.xht.passpharmreview.cache.remotecache.redis;

import com.xht.passpharmreview.cache.remotecache.RemoteCacheBase;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RedisCache
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 10:49
 * @Version: V1.0
 */
@Component
public class RedisStringCache<K,V> implements RemoteCacheBase<K,V> {

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public void remove(K key) {

    }
}
