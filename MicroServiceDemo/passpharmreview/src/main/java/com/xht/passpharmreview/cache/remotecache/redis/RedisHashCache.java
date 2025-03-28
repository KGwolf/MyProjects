package com.xht.passpharmreview.cache.remotecache.redis;

import com.xht.passpharmreview.cache.remotecache.RemoteCacheBase;
import com.xht.projectcommom.util.redisutil.RedisOpsExtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RedisHashCache
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 11:07
 * @Version: V1.0
 */
public class RedisHashCache<K,V> implements RemoteCacheBase<K,V> {

    private final RedisOpsExtUtil redisOpsExtUtil;

    private final String hashKey;

    public RedisHashCache(RedisOpsExtUtil redisOpsExtUtil,String hashKey) {
        this.redisOpsExtUtil = redisOpsExtUtil;
        this.hashKey = hashKey;
    }
    @Override
    public void put(K key, V value) {
        redisOpsExtUtil.putHash(hashKey,key,value);
    }

    @Override
    public V get(K key) {
        return redisOpsExtUtil.getHashField(hashKey,key);
    }

    @Override
    public void remove(K key) {
        redisOpsExtUtil.deleteHashFields(hashKey,key);
    }
}
