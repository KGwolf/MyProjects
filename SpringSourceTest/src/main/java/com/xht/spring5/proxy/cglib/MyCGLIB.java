package com.xht.spring5.proxy.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName: MyCGLIB
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/4/6 14:50
 * @Version: V1.0
 */
public class MyCGLIB implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object o1 = methodProxy.invokeSuper(o, objects);
        return o1;
    }
}
