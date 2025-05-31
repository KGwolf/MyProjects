package com.xht.passpharmreview.cache.remotecache.redis;

import com.xht.passpharmreview.cache.remotecache.RemoteCacheBase;
import com.xht.passpharmreview.constvar.RedisConst;
import com.xht.projectcommom.util.redisutil.RedisOpsExtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

/**
 * @ClassName: RedisHashCache
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 11:07
 * @Version: V1.0
 */
public class RedisHashCache<K, V> implements RemoteCacheBase<K, V> {

    private final RedisOpsExtUtil redisOpsExtUtil;

    private final String hashKey;

    public RedisHashCache(RedisOpsExtUtil redisOpsExtUtil, String hashKey) {
        this.redisOpsExtUtil = redisOpsExtUtil;
        this.hashKey = hashKey;
    }

    /***
     * @param
     * @return boolean
     * @Description 这个是用来判断是否存在某个hash缓存类型是否存在
     * @Author xiahaitao
     * @Date 2025/5/28 20:54
     */
    public boolean hasKey() {
        return redisOpsExtUtil.hasKey(hashKey);
    }

    /***
     * @param
     * @return java.lang.String
     * @Description 获取hash类型的key
     * @Author xiahaitao
     * @Date 2025/5/28 20:57
     */
    public String getKey() {
        return hashKey;
    }

    @Override
    public void put(K key, V value) {
        redisOpsExtUtil.putHash(hashKey, key, value);
    }

    @Override
    public V get(K key) {
        return redisOpsExtUtil.getHashField(hashKey, key);
    }

    @Override
    public void remove(K key) {
        redisOpsExtUtil.deleteHashFields(hashKey, key);
    }

    @Override
    public void putMany(Map<K, V> map) {
        // 使用HMSET命令批量写入（原子操作）
        redisOpsExtUtil.putAllHash(hashKey, map);
    }

    @Override
    public Collection<V> getAll() {
        return redisOpsExtUtil.getHashEntries(hashKey);
    }

    @Override
    public Collection<V> getMany(Collection<K> keys) {
        return null;
    }

    @Override
    public void removeMany(Collection<K> keys) {

    }

    @Override
    public void removeAll() {

    }
}
