package com.xht.spring5.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyFactoryBean
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/3/14 14:58
 * @Version: V1.0
 */
@Component
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new TestClass();
    }

    @Override
    public Class<?> getObjectType() {
        return TestClass.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
