package com.xht.spring5.proxy.cglib;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: DeptChooseService
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/4/6 14:49
 * @Version: V1.0
 */
public class DeptChooseService {
    public List<String> findDepts(String funCode) {
        System.out.println("调用被代理类的findDepts");
        return Arrays.asList("EK","KS001");
    }
}
