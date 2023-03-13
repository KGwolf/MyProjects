package com.xht.spring5;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 第一种方式，实现BeanFactoryPostProcessor接口
 * 第二种方式，创建DefaultListableFactory时，有一个customizeBeanFactory()，可以实现定制化的BeanFactory，可以在里面加入PostProcessor------继承ClassPathXmlApplicationContext
 *
 * 这里，不加@Component不能执行，那么加了之后这个BFPP是如何被执行的呢？
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("71734534534534534");
    }
}
