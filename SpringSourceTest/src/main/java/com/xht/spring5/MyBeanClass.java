package com.xht.spring5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.reflect.Method;

/**
 * @ClassName: MyBeanClass
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/3/13 11:25
 * @Version: V1.0
 */
@Configuration
@ComponentScan
//@EnableAspectJAutoProxy
public class MyBeanClass {
    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setBeanNames("aa");
        beanNameAutoProxyCreator.setInterceptorNames("zhouyuAroundAdvice");
        beanNameAutoProxyCreator.setProxyTargetClass(true);

        return beanNameAutoProxyCreator;
    }

    @Bean
    public MethodInterceptor zhouyuAroundAdvice(){
        return new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {

                System.out.println("before...");
                Object result = invocation.proceed();
                System.out.println("after...");
                return result;
            }
        };
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor(){
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("testAop");

        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(pointcut);
        defaultPointcutAdvisor.setAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
                if (o!= null) {
                    System.out.println("方法 " + method.getName() + " 返回值为：" + o);
                } else {
                    System.out.println("方法 " + method.getName() + " 没有返回值。");
                }
            }
        });

        return defaultPointcutAdvisor;
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisor2(){
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.addMethodName("testAop2");

        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor();
        defaultPointcutAdvisor.setPointcut(pointcut);
        defaultPointcutAdvisor.setAdvice(new AfterReturningAdvice() {
            @Override
            public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
                if (o!= null) {
                    System.out.println("方法 " + method.getName() + " 返回值为：" + o);
                } else {
                    System.out.println("方法 " + method.getName() + " 没有返回值。");
                }
            }
        });

        return defaultPointcutAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {

        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();

        return defaultAdvisorAutoProxyCreator;
    }

    //                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
//                for (StackTraceElement element : stackTrace) {
//                    System.out.println("Class: " + element.getClassName() + ", Method: " + element.getMethodName() + ", Line: " + element.getLineNumber());
//                }
}
