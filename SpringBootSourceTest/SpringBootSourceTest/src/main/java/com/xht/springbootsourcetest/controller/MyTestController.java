package com.xht.springbootsourcetest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: MyTestController
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/12/17 19:01
 * @Version: V1.0
 */
@Controller
@RequestMapping("/mytest")
public class MyTestController {

    @RequestMapping("test1")
    @ResponseBody
    public String test1(String name){
        return "xht："+name;
    }
}
