package com.xht.spring5.proxy.jdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: DictChooseServiceImp
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/4/3 9:16
 * @Version: V1.0
 */
public class DictChooseServiceImp implements DictChooseService{
    @Override
    public List<String> findDepts(String funCode) {
        System.out.println("调用被代理类的findDepts");
        return Arrays.asList("EK","KS001");
    }

    @Override
    public List<String> findHosps(String funCode) {
        System.out.println("调用被代理类的findHosps");
        return Arrays.asList("xbyy","zyyy");
    }

    @Override
    public List<String> findDoctors(String funCode) {
        System.out.println("调用被代理类的findDoctors");
        return Arrays.asList("xht","zxd");
    }

    @Override
    public List<String> findPharmas(String funCode) {
        System.out.println("调用被代理类的findPharmas");
        return Arrays.asList("xht","wl");
    }
}
