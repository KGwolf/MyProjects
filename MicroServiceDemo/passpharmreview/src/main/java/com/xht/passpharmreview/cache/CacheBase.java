package com.xht.passpharmreview.cache;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName: Cache
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 10:06
 * @Version: V1.0
 */
public interface CacheBase<K, V> {
    void put(K key, V value);

    V get(K key);

    void remove(K key);

    /***
     * @param map
     * @return void
     * @Description 放入多个到缓存
     * @Author xiahaitao
     * @Date 2025/5/29 10:06
     */
    void putMany(Map<K, V> map);

    /***
     * @param
     * @return java.util.Collection<V>
     * @Description 从缓存中获取全部数据
     * @Author xiahaitao
     * @Date 2025/5/29 10:08
     */
    Collection<V> getAll();

    /***
     * @param keys
     * @return java.util.Collection<V>
     * @Description 从缓存中获取多个数据
     * @Author xiahaitao
     * @Date 2025/5/29 10:08
     */
    Collection<V> getMany(Collection<K> keys);

    /***
     * @param keys
     * @return void
     * @Description 从缓存中删除多个数据
     * @Author xiahaitao
     * @Date 2025/5/29 10:10
     */
    void removeMany(Collection<K> keys);

    /***
     * @param
     * @return void
     * @Description 清空缓存的所有数据
     * @Author xiahaitao
     * @Date 2025/5/29 10:10
     */
    void removeAll();
}
