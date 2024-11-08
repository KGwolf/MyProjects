package com.xht.spring5.mybatis;

import com.xht.spring5.MyBeanClass;
import com.xht.spring5.mybatis.mapper.OrderMapper;
import com.xht.spring5.mybatis.mapper.ProductMapper;
import com.xht.spring5.mybatis.mapper.UserMapper;
import com.xht.spring5.mybatis.service.UserService;
import com.xht.spring5.mybatis.spring.MultiMapperInterfaceFactoryBean;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.InputStream;

/**
 * @ClassName: MyBatisTest
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/11/7 10:59
 * @Version: V1.0
 */
public class MyBatisTest {
    public static void main(String[] args) throws Exception {


        AnnotationConfigApplicationContext acT = new AnnotationConfigApplicationContext();
        acT.register(MyBatisConfigClass.class);

        //这里这么多mapper接口，我们不可能在这里写N个吧， 那么就可以自定义扫描来实现。
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(MultiMapperInterfaceFactoryBean.class).addConstructorArgValue(UserMapper.class).getBeanDefinition();
//        acT.registerBeanDefinition("multiMapperInterfaceFactoryBean",beanDefinition);
//
//        AbstractBeanDefinition beanDefinition2 = BeanDefinitionBuilder.genericBeanDefinition(MultiMapperInterfaceFactoryBean.class).addConstructorArgValue(ProductMapper.class).getBeanDefinition();
//        acT.registerBeanDefinition("multiMapperInterfaceFactoryBean2",beanDefinition2);
//
//        AbstractBeanDefinition beanDefinition3 = BeanDefinitionBuilder.genericBeanDefinition(MultiMapperInterfaceFactoryBean.class).addConstructorArgValue(OrderMapper.class).getBeanDefinition();
//        acT.registerBeanDefinition("multiMapperInterfaceFactoryBean3",beanDefinition3);

        acT.refresh();


        UserService user = (UserService)acT.getBean("userService");
        user.testUserService();
    }
}
