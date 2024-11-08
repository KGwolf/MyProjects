package com.xht.spring5.mybatis.spring;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 这里为什么要使用@Import呢？
 *
 * 因为直接用 MapperBeanDefinitionRegistryPostProcessor 这个来实现 bean的注册，获取不到扫描mapper的路径。
 * 所以自定义一个 ImportBeanDefinitionRegistry 的类来实现， 这个只能用@Import来导入，从而可以获取到扫描的路径。
 *
 * @Author xiahaitao
 * @Date 2024/11/8 11:56
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(MyMapperImportBeanDefinitionRegistrar.class)
public @interface MyMapperScan {
    String value();
}
