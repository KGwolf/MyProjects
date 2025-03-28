package com.xht.passpharmreview.config.cacheconfig.redis;

import com.xht.passpharmreview.cache.remotecache.redis.RedisHashCache;
import com.xht.passpharmreview.model.screen.cachemodel.TaskCacheModel;
import com.xht.projectcommom.util.redisutil.RedisOpsExtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: RedisCacheConfig
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 16:28
 * @Version: V1.0
 */
@Configuration
public class RedisCacheConfig {
    @Bean
    public RedisHashCache<String, TaskCacheModel> taskCache(RedisOpsExtUtil util) {
        String hashKey = "task";
        return new RedisHashCache<>(util, hashKey);
    }
}
