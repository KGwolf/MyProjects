package com.xht.passpharmreview.config.distributedlock;

import com.xht.passpharmreview.distributedlock.DistributedLock;
import com.xht.passpharmreview.distributedlock.RedissonLockServiceImpl;
import com.xht.passpharmreview.distributedlock.ZookeeperLockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @ClassName: DistributedLockConfig
 * @Description: 根据配置动态切换分布式锁的类型
 * @Author: xiahaitao
 * @Date: 2025/5/24 21:35
 * @Version: V1.0
 */
@Configuration
public class DistributedLockConfig {
    @Bean
    @Primary
    @RefreshScope  // 支持配置热更新[7,9](@ref)
    public DistributedLock distributedLock(
            @Value("${distributed.lock.type}") String lockType,
            @Autowired(required = false) ZookeeperLockServiceImpl zkLockService,
            @Autowired(required = false) RedissonLockServiceImpl redisLockService) {
        if ("zookeeper".equals(lockType)) {
            return zkLockService;
        } else if ("redis".equals(lockType)) {
            return redisLockService;
        }
        throw new IllegalArgumentException("Unsupported lock type");
    }
}
