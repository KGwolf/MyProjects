package com.xht.spring5.mybatis.spring;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName: MyMapperImportBeanDefinitionRegistry
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/11/8 11:58
 * @Version: V1.0
 */

public class MyMapperImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        //从importingClassMetadata 里面获取注解的信息
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(MyMapperScan.class.getName());
        String pathStr = (String)annotationAttributes.get("value");

        //得到路径后，通过自定义的扫描器进行扫描得到所有mapper接口的beanDefinition。
        MapperClassPathBeanDefinitionScanner mapperScan = new MapperClassPathBeanDefinitionScanner(registry);

        //这里解决不能扫描 不带@Component 注解的接口
        mapperScan.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                //这里也可以选择匹配@Mapper注解。
                return true;
            }
        });

        mapperScan.scan(pathStr);

    }

}
