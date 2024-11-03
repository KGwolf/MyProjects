package com.xht.spring5.aop;

import org.springframework.stereotype.Component;

/**
 * @Author: xiahaitao
 * @CreateTime: 2024-11-03  20:30
 * @Description: TODO
 * @Version: 1.0
 **/
@Component
public class MyTestAop {
    public void testAop(){
        System.out.println("testAop");
    }
    public void testAop2(){
        System.out.println("testAop2");
    }
}
