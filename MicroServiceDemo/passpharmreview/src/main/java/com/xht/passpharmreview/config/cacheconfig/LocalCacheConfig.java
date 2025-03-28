package com.xht.passpharmreview.config.cacheconfig;

import com.xht.passpharmreview.cache.localcache.LocalCacheBase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: LocalCacheConfig
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 13:53
 * @Version: V1.0
 */
//@Configuration
public class LocalCacheConfig {

//    @Value("${local.cache.type:caffeine}")
//    private String localCacheType;
//    @Bean
//    public <K, V> LocalCacheBase<K, V> localCache(CaffeineLocalCache<K, V> caffeineLocalCache,
//                                                  EhcacheLocalCache<K, V> ehcacheLocalCache) {
//        if ("caffeine".equalsIgnoreCase(localCacheType)) {
//            return caffeineLocalCache;
//        } else if ("ehcache".equalsIgnoreCase(localCacheType)) {
//            return ehcacheLocalCache;
//        }
//        throw new IllegalArgumentException("Invalid local cache type: " + localCacheType);
//    }
}
