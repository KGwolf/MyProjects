package com.xht.passpharmreview.config.cacheconfig.caffine;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import com.xht.passpharmreview.cache.localcache.caffine.MapCaffeineLocalCache;
import com.xht.passpharmreview.model.screen.cachemodel.TaskListCacheModel;
import org.checkerframework.checker.units.qual.K;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;


/**
 * @ClassName: CaffeineCacheConfig
 * @Description: 本地缓存 咖啡因
 * 这里是不是要每个类型的缓存都创建一个Cache类呢？
 * maximumSize：限制缓存的最大条目数，限制的是最外层key的数量，当使用一个统一Cache类来存储所有的缓存的时候，
 * 限制的是类似redis的hashkey。 当某个类型是一个单独的Cache类时，这个时候限制的是里面的Map数量。
 *
 * 这2种可以结合来使用最好，很多其实还是可以使用通用的一个Cache类。
 *
 * expireAfterWrite：这个是缓存的超时时间。
 * @Author: xiahaitao
 * @Date: 2025/3/28 14:35
 * @Version: V1.0
 */
@Configuration
public class CaffeineCacheConfig {
    @Bean
    public MapCaffeineLocalCache<String, Object> genericCaffeineCache() {
        Cache<String, Object> build = Caffeine.newBuilder()
                .maximumSize(1000) //这个要设置多一点，这限制的是最外层的hashKey的数量
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();

        return new MapCaffeineLocalCache<String, Object>(build);
    }


    @Bean
    public MapCaffeineLocalCache<String, TaskListCacheModel> taskCaffeineCache() {
        Cache<String, TaskListCacheModel> build = Caffeine.newBuilder()
                .maximumSize(100)//这里是限制的Map的key的数量
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build();

        return new MapCaffeineLocalCache<String, TaskListCacheModel>(build);
    }
//    /**
//     * @description: 通用的Caffeine缓存类
//     * @author: xiahaitao
//     * @date: 2025/6/2 10:46
//     * @param: []
//     * @return: com.github.benmanes.caffeine.cache.Cache<java.lang.String,java.lang.Object>
//     **/
//    @Bean
//    public Cache<String, Object> genericCaffeineCache() {
//        return Caffeine.newBuilder()
//                .maximumSize(1000) //这个要设置多一点，这限制的是最外层的hashKey的数量
//                .expireAfterWrite(10, TimeUnit.MINUTES)
//                .build();
//    }
    
    /**
     * @description: 任务的Caffeine缓存类
     * @author: xiahaitao 
     * @date: 2025/6/2 10:46
     * @param: []
     * @return: com.github.benmanes.caffeine.cache.Cache<java.lang.String,com.xht.passpharmreview.model.screen.cachemodel.TaskListCacheModel>
     **/
//    @Bean
//    public Cache<String, TaskListCacheModel> taskCaffeineCache() {
//        return Caffeine.newBuilder()
//                .maximumSize(100)//这里是限制的Map的key的数量
//                .expireAfterWrite(10, TimeUnit.MINUTES)
//                .build();
//    }

}
