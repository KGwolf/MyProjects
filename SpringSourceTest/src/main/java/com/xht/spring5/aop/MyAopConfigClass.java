package com.xht.spring5.aop;

import com.xht.spring5.mybatis.spring.MyMapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Author: xiahaitao
 * @CreateTime: 2024-11-10  21:25
 * @Description: TODO
 * @Version: 1.0
 **/
@Component
@ComponentScan("com.xht.spring5.aop")
@EnableAspectJAutoProxy
public class MyAopConfigClass {
}
