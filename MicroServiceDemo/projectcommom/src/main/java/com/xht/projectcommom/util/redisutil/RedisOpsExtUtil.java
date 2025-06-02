package com.xht.projectcommom.util.redisutil;

/**
 * @ClassName: RedisOpsExtUtil
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/26 9:47
 * @Version: V1.0
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RedisOpsExtUtil {

    @Autowired
    @Qualifier("redisCluster")
    private RedisTemplate redisTemplate;

    // ------------ Hash 操作 ------------
    /**
     * 设置 Hash 字段值
     * @param key   Redis键
     * @param field 字段名
     * @param value 字段值
     */
    public <HK, HV> void putHash(String key, HK field, HV value) {
        if (field == null || value == null) {
            //log.warn("Hash字段或值不能为空 [key={}, field={}]", key, field);
            return;
        }
        redisTemplate.opsForHash().put(key, field, value);
    }

    /**
     * 批量设置 Hash 字段值
     * @param key    Redis键
     * @param fields 字段Map
     */
    public <HK, HV> void putAllHash(String key, Map<HK, HV> fields) {
        if (MapUtils.isEmpty(fields)) {
            //log.warn("Hash字段集为空 [key={}]", key);
            return;
        }
        redisTemplate.opsForHash().putAll(key, fields);
    }

    /**
     * 获取 Hash 字段值
     * @param key   Redis键
     * @param field 字段名
     * @return 字段值
     */
    public <HK, HV> HV getHashField(String key, HK field) {
        return (HV) redisTemplate.opsForHash().get(key, field);
    }

    /**
     * 获取 Hash 所有字段和值
     * @param key Redis键
     * @return Map<字段, 值>
     */
    public <HK, HV> Map<HK, HV> getHashEntries(String key) {
        return (Map<HK, HV>) redisTemplate.opsForHash().entries(key);
    }

    /**
     * 删除 Hash 字段
     * @param key    Redis键
     * @param fields 要删除的字段名
     * @return 删除的字段数量
     */
    public <HK> Long deleteHashFields(String key, HK... fields) {
        if (fields == null || fields.length == 0) {
            //log.warn("待删除Hash字段为空 [key={}]", key);
            return 0L;
        }
        return redisTemplate.opsForHash().delete(key, (Object[]) fields);
    }

    /**
     * 判断 Hash 中是否存在字段
     * @param key   Redis键
     * @param field 字段名
     * @return 是否存在
     */
    public <HK> boolean hasHashKey(String key, HK field) {
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    /**
     * 获取 Hash 所有字段名
     * @param key Redis键
     * @return 字段名集合
     */
    public <HK> Set<HK> getHashKeys(String key) {
        return (Set<HK>) redisTemplate.opsForHash().keys(key);
    }

    /**
     * 获取 Hash 所有字段值
     * @param key Redis键
     * @return 值集合
     */
    public <HV> List<HV> getHashValues(String key) {
        return (List<HV>) redisTemplate.opsForHash().values(key);
    }

    /**
     * 递增 Hash 数值字段
     * @param key   Redis键
     * @param field 字段名
     * @param delta 增量（正数为增，负数为减）
     * @return 更新后的值
     */
    public <HK> Long incrementHash(String key, HK field, long delta) {
        return redisTemplate.opsForHash().increment(key, field, delta);
    }



    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void set(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    public <V> void putListAllRight(String key, Collection<V> values) {
        if (CollectionUtils.isEmpty(values)) {
            //log.warn("{}没有数据可放入Redis", key);
        } else {
            redisTemplate.opsForList().rightPushAll(key, values);
        }
    }

    public <T> T getListAll(String key, Class<?> T) {
        return (T) redisTemplate.opsForList().range(key, 0, -1);
    }

    public <T> T get(String key, Class<?> T) {
        return (T) redisTemplate
                .opsForValue().get(key);
    }

    public String get(String key) {
        return (String) redisTemplate
                .opsForValue().get(key);
    }

    public Long decr(String key) {
        return redisTemplate
                .opsForValue().decrement(key);
    }

    public Long decr(String key, long delta) {
        return redisTemplate
                .opsForValue().decrement(key, delta);
    }

    public Long incr(String key) {
        return redisTemplate
                .opsForValue().increment(key);
    }

    public Long incr(String key, long delta) {
        return redisTemplate
                .opsForValue().increment(key, delta);
    }

    public boolean expire(String key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    public boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 发布channel信息
     *
     * @param channel
     * @param message
     */
    public void publish(String channel, Object message) {
        redisTemplate.convertAndSend(channel, message);
    }


    public boolean isHashEmpty(String key) {
        // 获取 Hash 的所有字段列表
        Set<Object> fields = redisTemplate.opsForHash().keys(key);
        return fields == null || fields.isEmpty();
    }

}
