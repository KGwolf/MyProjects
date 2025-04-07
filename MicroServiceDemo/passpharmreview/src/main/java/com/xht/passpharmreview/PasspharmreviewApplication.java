package com.xht.passpharmreview;

import com.xht.projectcommom.config.redisconfig.RedisExtConifg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * @description: 集成sentinal(规则持久化) + skywalking + seata（at模式+TCC）
 * @author: xiahaitao 
 * @date: 2025/4/4 20:32
 * @param: 
 * @return: 
 **/
@SpringBootApplication
@EnableFeignClients(basePackages = "com.xht.projectcommom")
@Import(RedisExtConifg.class)
public class PasspharmreviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasspharmreviewApplication.class, args);
    }

}
