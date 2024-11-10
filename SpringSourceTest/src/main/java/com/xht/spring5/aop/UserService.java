package com.xht.spring5.aop;

import org.springframework.stereotype.Component;

/**
 * @Author: xiahaitao
 * @CreateTime: 2024-11-10  07:12
 * @Description: TODO
 * @Version: 1.0
 **/
@Component
public class UserService {
    private String name;

    public void getUserName(){
        System.out.println("名字：1111");
    }
}
