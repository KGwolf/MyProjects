package com.xht.passpharmreview.cache;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName: Cache
 * @Description: Map类型缓存操作接口   CacheBase里面有这些方法的定义了，还有必要存在这个接口吗？
 * @Author: xiahaitao
 * @Date: 2025/5/31 10:06
 * @Version: V1.0
 */
public interface MapCacheBaseT<K,V> extends CacheBase<K,V>{
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
     * @Description 从缓存中获取全部数据---这个全部数据量太大了哦？？？
     *              获取的是某一种hash类型 的所有值
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
     * @Description 清空某种Map类型缓存的所有数据
     * @Author xiahaitao
     * @Date 2025/5/29 10:10
     */
    void removeAll();
}
