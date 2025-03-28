package com.xht.passpharmreview.cache;

/**
 * @ClassName: Cache
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 10:06
 * @Version: V1.0
 */
public interface CacheBase<K,V> {
    void put(K key,V value);
    V get(K key);
    void remove(K key);
}
