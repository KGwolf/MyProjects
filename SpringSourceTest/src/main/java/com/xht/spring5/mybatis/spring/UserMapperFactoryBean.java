package com.xht.spring5.mybatis.spring;

import com.xht.spring5.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: UserMapperFactoryBean
 * @Description: 这里用FactoryBean是因为直接在启动的时候新增beanDefinition，不能指定类型为一个接口，否则没用。
 *
 * 这里如果有 多个接口需要被代理怎么办呢？
 * 这里能弄一个具体的代理类，那么需要抽象出来泛型，java里面可以是Class<?>。
 *
 * @Author: xiahaitao
 * @Date: 2024/11/7 11:29
 * @Version: V1.0
 */
@Deprecated
//@Component
public class UserMapperFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Object o = Proxy.newProxyInstance(UserMapperFactoryBean.class.getClassLoader(), new Class[]{UserMapper.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return UserMapper.class;
    }
}
