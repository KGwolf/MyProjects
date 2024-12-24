package com.xht.springbootsourcetest.controller;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: MyTestController2
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/12/17 19:23
 * @Version: V1.0
 */
@Component("/mytest2")
public class MyTestController2 implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("实现了Controller接口的方法执行。。。");
        return null;
    }
}
