package com.xht.spring5.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author: xiahaitao
 * @CreateTime: 2024-11-03  11:44
 * @Description: TODO
 * @Version: 1.0
 **/
@Aspect
@Component
public class MyLogUtil {
    @Before("execution(* com.xht.spring5.Food.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Before executing method: " + joinPoint.getSignature().getName());
    }
}
