package com.xht.spring5.beanfactorypostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @ClassName: NoComponentBFPP
 * @Description: 不加入Ioc容器的BFPP，测试用于在CustomBeanFactory里面，手动加入BFPP。
 * @Author: xiahaitao
 * @Date: 2023/3/13 14:06
 * @Version: V1.0
 */
public class NoComponentBFPP implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("asddasd");
    }
}
