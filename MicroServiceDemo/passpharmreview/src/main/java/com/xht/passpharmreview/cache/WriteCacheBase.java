package com.xht.passpharmreview.cache;

import org.checkerframework.checker.units.qual.K;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-06-02  12:32
 * @Description: 写操作缓存接口
 * @Version: 1.0
 **/
public interface WriteCacheBase<K,V> {
    void put(K key, V value);

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
     * @Description 清空缓存的所有数据，一般也不会用
     * @Author xiahaitao
     * @Date 2025/5/29 10:10
     */
    void removeAll();
}
