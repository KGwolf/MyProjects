package com.xht.springbootsourcetest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: MyTestController4
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/12/17 19:34
 * @Version: V1.0
 */
@Controller
@RequestMapping("/mytest3")
public class MyTestController4 {

    @RequestMapping("test1")
    @ResponseBody
    public String test1(){
        return "xht";
    }
}
