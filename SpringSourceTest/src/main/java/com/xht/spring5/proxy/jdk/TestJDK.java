package com.xht.spring5.proxy.jdk;

import sun.misc.GC;

import java.util.List;

/**
 * @ClassName: TestJDK
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/4/3 9:22
 * @Version: V1.0
 */
public class TestJDK {
    public static void main(String[] args) {
        DictChooseService proxyClass = DictChooseProxy.getProxyClass(new DictChooseServiceImp());
        List<String> depts = proxyClass.findDepts("1");
        System.out.println(depts);

    }

}
