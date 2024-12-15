package com.xht.springbootsourcetest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/mytest")
public class MyTestController {

    @RequestMapping("/myview")
    @ResponseBody
    public String myView1(){
        return "xht";
    }
}
