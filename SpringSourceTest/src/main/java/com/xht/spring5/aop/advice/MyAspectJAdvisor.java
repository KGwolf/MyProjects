package com.xht.spring5.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @Author: xiahaitao
 * @CreateTime: 2024-11-10  21:19
 * @Description: TODO
 * @Version: 1.0
 **/
@Component
@Aspect
public class MyAspectJAdvisor {
    @Around("execution(* com.xht.spring5.aop.UserService.*(..))")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Before executing method: " + methodName);
        Object result = joinPoint.proceed();
        System.out.println("After executing method: " + methodName);
        return result;
    }
}
