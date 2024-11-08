package com.xht.spring5.mybatis.spring;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 * @ClassName: MapperClassPathBeanDefinitionScanner
 * @Description: 自定义一个扫描器。
 * 要解决的问题：
 *      1.接口不能被扫描到。
 *      2.spring的基础扫描，需要@Component注解才能被扫描到。而我们用MyBatis的时候，并不需要加这个。
 *      3.扫描到我们需要的beanDefinition之后，还要做处理，因为我们需要的是FactoryBean的类型。
 * @Author: xiahaitao
 * @Date: 2024/11/8 13:23
 * @Version: V1.0
 */
public class MapperClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

    public MapperClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
        //这里得到的beanDefinitionHolders 跟BeanFatory没有关系，还需要进一步的修改。
        for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
            BeanDefinition beanDefinition = beanDefinitionHolder.getBeanDefinition();

            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClassName(MultiMapperInterfaceFactoryBean.class.getName());

        }
        return beanDefinitionHolders;
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }
}
