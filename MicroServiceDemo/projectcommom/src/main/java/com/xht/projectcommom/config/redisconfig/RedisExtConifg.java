package com.xht.projectcommom.config.redisconfig;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xht.projectcommom.util.redisutil.RedisOpsExtUtil;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ClassName: RedisExtConifg
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/26 9:45
 * @Version: V1.0
 */
@Configuration
public class RedisExtConifg {

//    @Value("${spring.redis.cluster.nodes}")
//    String redisNodes;

    @Value("${spring.redis.host}")
    String redisHost;

    @Value("${spring.redis.port}")
    int redisPort;

//    @Value("${spring.redis.password}")
//    String redisPass;

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Bean("redisCluster")
    @Primary
    public RedisTemplate<String,Object> redisTemplate(){
        RedisTemplate<String,Object> template = new RedisTemplate();
        template.setConnectionFactory(connectionFactory);
        // 序列化工具
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer
                = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);

        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);

        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public RedisOpsExtUtil redisOpsUtil(){
        return new RedisOpsExtUtil();
    }

    @Bean
    public RedissonClient redissonClient(){
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://" + redisHost + ":" + redisPort);

//        ClusterServersConfig clusterServersConfig = config.useClusterServers();
//        for (String node: redisNodes.split(",")){
//            clusterServersConfig.addNodeAddress("redis://"+node);
//        }
//        clusterServersConfig.setPassword("");
        return Redisson.create(config);
    }

}
