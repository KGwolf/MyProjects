package com.xht.spring5.annotation;

import com.xht.spring5.Food;
import com.xht.spring5.MyBeanClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationAnnotation {
    @Bean
    public MyBeanClass m1(){
        return new MyBeanClass();
    }
}
