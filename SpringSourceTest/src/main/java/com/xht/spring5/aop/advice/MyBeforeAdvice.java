package com.xht.spring5.aop.advice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.AspectInstanceFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author: xiahaitao
 * @CreateTime: 2024-11-10  07:22
 * @Description: TODO
 * @Version: 1.0
 **/
public class MyBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("方法之前执行逻辑");
    }
}
