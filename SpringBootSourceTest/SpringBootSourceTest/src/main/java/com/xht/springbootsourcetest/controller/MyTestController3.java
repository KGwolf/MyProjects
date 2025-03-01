package com.xht.springbootsourcetest.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: MyTestController3
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/12/17 19:26
 * @Version: V1.0
 */
@Component("/mytest3")
public class MyTestController3 implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("实现了HttpRequestHandler接口的方法执行。。。。");
    }
}
