package com.xht.spring5.beanfactorypostprocessor;


import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName: MyCoustomBeanFactory
 * @Description: 自定义BeanFactory，实际上得作用是可以修改传入得BeanFactory的很多属性值(可以手动添加BFPP)。达到扩展的效果。
 * @Author: xiahaitao
 * @Date: 2023/3/13 13:09
 * @Version: V1.0
 */
public class MyCoustomBeanFactory  extends ClassPathXmlApplicationContext {

    public MyCoustomBeanFactory() {
    }
    public MyCoustomBeanFactory(String... locations) {
        super(locations);
    }
    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        //添加一个BFPP,手动add，这个类没有交给Spring Ioc容器管理
        super.addBeanFactoryPostProcessor(new NoComponentBFPP());

        //自定义BeanFactory，可以设置一些属性值。allowBeanDefinitionOverriding 、allowCircularReferences设置
        super.setAllowBeanDefinitionOverriding(true);
        super.setAllowCircularReferences(true);

        super.customizeBeanFactory(beanFactory);
    }
}
