package com.xht.spring5.aop;

/**
 * @ClassName: DealTaskProcessImpl
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/4/23 10:42
 * @Version: V1.0
 */
public class DealTaskProcessImpl /*implements DealTaskProcess*/{

//    @Override
    public String reviewTaskFromPass(String reviewJsonStr) {
        System.out.println("---执行reviewTaskFromPass-----");
        return "";
    }

//    @Override
    public void dealTaskByPrRules() {
        System.out.println("---执行dealTaskByPrRules-----");
    }

//    @Override
    public void saveDataToDb() {
        System.out.println("---执行saveDataToDb-----");
    }
}
