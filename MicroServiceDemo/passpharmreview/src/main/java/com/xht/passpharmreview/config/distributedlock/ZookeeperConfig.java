package com.xht.passpharmreview.config.distributedlock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: ZookeeperConfig
 * @Description: zk配置类，注释掉的是单节点的
 * @Author: xiahaitao
 * @Date: 2025/5/24 21:28
 * @Version: V1.0
 */
@Configuration
public class ZookeeperConfig {
    //    @Value("${zookeeper.address}")
//    private String zookeeperAddress;
    @Value("${spring.cloud.zookeeper.connect-string}")
    private String zkNodes;

    //    @Bean
//    public CuratorFramework curatorFramework() {
//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        CuratorFramework client = CuratorFrameworkFactory.newClient(zookeeperAddress, retryPolicy);
//        client.start();
//        return client;
//    }
    @Bean(destroyMethod = "close")
    public CuratorFramework curatorFramework() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(zkNodes)
                .retryPolicy(retryPolicy)
                .sessionTimeoutMs(30000)
                .connectionTimeoutMs(15000)
                .build();

        //不写这行，报错：java.lang.IllegalStateException: Expected state [STARTED] was [LATENT]
        client.start(); // 核心：显式启动客户端
        return client;
    }
}
