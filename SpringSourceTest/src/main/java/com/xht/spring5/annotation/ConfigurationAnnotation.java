package com.xht.spring5.annotation;

import com.xht.spring5.Food;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationAnnotation {

    @Bean
    public Food m1(){
        return new Food();
    }
}
