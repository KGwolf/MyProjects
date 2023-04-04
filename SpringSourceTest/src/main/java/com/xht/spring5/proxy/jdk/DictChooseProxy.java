package com.xht.spring5.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: DictChooseProxy
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/4/3 9:24
 * @Version: V1.0
 */
public class DictChooseProxy {
    public static DictChooseService getProxyClass(final DictChooseServiceImp dictChoose){

        //1.获取传入类的类加载器
        ClassLoader classLoader = dictChoose.getClass().getClassLoader();

        //2.获取传入类实现了哪些接口
        Class<?>[] interfaces = dictChoose.getClass().getInterfaces();

        //3.生成一个InvocationHandler  这里是创建了一个匿名内部类
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("Before method " + method.getName());
                Object result = method.invoke(dictChoose, args);
                System.out.println("After method " + method.getName());
                return result;
            }
        };
        //4.调用Proxy.newProxyInstance()方法
        Object o = Proxy.newProxyInstance(classLoader,interfaces,invocationHandler);

        return (DictChooseService)o;
    }


}
