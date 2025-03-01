package com.xht.spring5.aop;



import com.xht.spring5.aop.advice.MyBeforeAdvice;
import com.xht.spring5.aop.advice.MyPointcutAdvisor;
import com.xht.spring5.mybatis.MyBatisConfigClass;
import org.aopalliance.aop.Advice;
import org.springframework.aop.*;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.annotation.AnnotationMethodMatcher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @Author: xiahaitao
 * @CreateTime: 2024-11-09  17:31
 * @Description: TODO
 * @Version: 1.0
 **/
public class AopTest {
    public static void main(String[] args) {
        //1.ProxyFactory的使用
        UserService targetUserService = new UserService();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(targetUserService);
        proxyFactory.addAdvice(new MyBeforeAdvice());//这个被代理类上的所有方法都会执行这个Advice。
        proxyFactory.addAdvisor(new MyPointcutAdvisor());//添加一个Advisor，可以筛选出被代理类上的某一些方法才执行对应的Advice。

        proxyFactory.setInterfaces();
        UserService userService = (UserService)proxyFactory.getProxy();
        userService.getUserName();

        //2.Spring注解的方式。
//        AnnotationConfigApplicationContext acT = new AnnotationConfigApplicationContext();
//        acT.register(MyAopConfigClass.class);
//        acT.refresh();
//
//        UserService user = (UserService)acT.getBean("userService");
//        user.getUserName();
    }
}
