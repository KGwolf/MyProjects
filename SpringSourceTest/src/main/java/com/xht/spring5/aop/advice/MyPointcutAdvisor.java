package com.xht.spring5.aop.advice;

import com.xht.spring5.aop.UserService;
import org.aopalliance.aop.Advice;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @Author: xiahaitao
 * @CreateTime: 2024-11-10  08:43
 * @Description: TODO
 * @Version: 1.0
 **/
public class MyPointcutAdvisor implements PointcutAdvisor {
    @Override
    public Pointcut getPointcut() {
//        return new StaticMethodMatcherPointcut() {
//            @Override
//            public boolean matches(Method method, Class<?> targetClass) {
//                return method.getName().equals("getUserName");
//            }
//        };
        return new Pointcut() {
            @Override
            public ClassFilter getClassFilter() {
                return new ClassFilter() {
                    @Override
                    public boolean matches(Class<?> aClass) {
                        return aClass.equals(UserService.class);
                    }
                };
            }

            @Override
            public MethodMatcher getMethodMatcher() {
                return new MethodMatcher() {
                    @Override
                    public boolean matches(Method method, Class<?> aClass) {
                        return method.getName().equals("getUserName");
                    }

                    @Override
                    public boolean isRuntime() {
                        //这里默认是false，只需要执行被代理方法的时候，匹配上面一个matches方法即可。
                        //如果是true，那么在执行这个advisor的时候，会看传入参数跟下面的这个matches是否匹配。
                        return false;
                    }

                    @Override
                    public boolean matches(Method method, Class<?> aClass, Object... objects) {
                        return false;
                    }
                };
            }
        };
    }

    @Override
    public Advice getAdvice() {
        return new MyBeforeAdvice();
    }

    @Override
    public boolean isPerInstance() {
        return false;
    }
}
