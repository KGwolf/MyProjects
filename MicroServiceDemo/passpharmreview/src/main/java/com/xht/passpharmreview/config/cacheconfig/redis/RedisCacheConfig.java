package com.xht.passpharmreview.config.cacheconfig.redis;

import com.xht.passpharmreview.cache.remotecache.redis.RedisHashCache;
import com.xht.passpharmreview.cache.remotecache.redis.RedisStringCache;
import com.xht.passpharmreview.constvar.InitLoaderConst;
import com.xht.passpharmreview.constvar.RedisConst;
import com.xht.passpharmreview.model.initload.PharmacistModel;
import com.xht.passpharmreview.model.screen.cachemodel.TaskListCacheModel;
import com.xht.projectcommom.util.redisutil.RedisOpsExtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RedisCacheConfig
 * @Description: 难道每写一个缓存都要来加一个吗？
 * @Author: xiahaitao
 * @Date: 2025/3/28 16:28
 * @Version: V1.0
 */
@Configuration
public class RedisCacheConfig {
    /***
     * @param util
     * @return com.xht.passpharmreview.cache.remotecache.redis.RedisHashCache<java.lang.String, com.xht.passpharmreview.model.screen.cachemodel.TaskListCacheModel>
     * @Description 任务的redis缓存配置类
     * @Author xiahaitao
     * @Date 2025/5/28 20:39
     */
    @Bean
    public RedisHashCache<String, TaskListCacheModel> taskCache(RedisOpsExtUtil util) {
        String hashKey = RedisConst.PR_PREFIX_REDIS + "task";
        return new RedisHashCache<>(util, hashKey);
    }

    /***
     * @param util
     * @return com.xht.passpharmreview.cache.remotecache.redis.RedisHashCache<java.lang.String, com.xht.passpharmreview.model.initload.PharmacistModel>
     * @Description 初始化药师的缓存配置类
     * @Author xiahaitao
     * @Date 2025/5/28 20:38
     */
    @Bean
    public RedisHashCache<String, PharmacistModel> pharmacistCache(RedisOpsExtUtil util) {
        String hashKey = RedisConst.PR_PREFIX_REDIS + InitLoaderConst.INIT_LOADER_PREFIX + "pharmacist";
        return new RedisHashCache<>(util, hashKey);
    }

}
