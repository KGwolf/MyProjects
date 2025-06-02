package com.xht.passpharmreview.cache;

import org.checkerframework.checker.units.qual.K;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: xiahaitao
 * @CreateTime: 2025-06-02  12:31
 * @Description: 读操作缓存接口
 * @Version: 1.0
 **/
public interface ReadCacheBase<K,V> {
    V get(K key);

    /***
     * @param
     * @return java.util.Collection<V>
     * @Description 从缓存中获取全部数据---这个全部数据量太大了哦？？？ 一般不会用
     * @Author xiahaitao
     * @Date 2025/5/29 10:08
     */
    Map<K, V> getAll();

    /***
     * @param keys
     * @return java.util.Collection<V>
     * @Description 从缓存中获取多个数据
     * @Author xiahaitao
     * @Date 2025/5/29 10:08
     */
    Map<K, V>  getMany(Collection<K> keys);
}
