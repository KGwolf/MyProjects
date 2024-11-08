package com.xht.spring5.mybatis.spring;

import com.xht.spring5.mybatis.mapper.OrderMapper;
import com.xht.spring5.mybatis.mapper.ProductMapper;
import com.xht.spring5.mybatis.mapper.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MapperBeanDefinitionRegisterPostProcessor
 * @Description: 这个类第一步：相当于就是把refresh前面添加beanDefinition的代码搬运过来。
 *
 * 2.也不能新加一个mapper接口，就手动改一下吧？可以通过扫描类来弄。
 *
 * @Author: xiahaitao
 * @Date: 2024/11/8 10:18
 * @Version: V1.0
 */
@Deprecated
//@Component
public class MapperBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
                AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(MultiMapperInterfaceFactoryBean.class).addConstructorArgValue(UserMapper.class).getBeanDefinition();
        registry.registerBeanDefinition("multiMapperInterfaceFactoryBean",beanDefinition);

        AbstractBeanDefinition beanDefinition2 = BeanDefinitionBuilder.genericBeanDefinition(MultiMapperInterfaceFactoryBean.class).addConstructorArgValue(ProductMapper.class).getBeanDefinition();
        registry.registerBeanDefinition("multiMapperInterfaceFactoryBean2",beanDefinition2);

        AbstractBeanDefinition beanDefinition3 = BeanDefinitionBuilder.genericBeanDefinition(MultiMapperInterfaceFactoryBean.class).addConstructorArgValue(OrderMapper.class).getBeanDefinition();
        registry.registerBeanDefinition("multiMapperInterfaceFactoryBean3",beanDefinition3);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
