package com.xht.spring5.aop;

/**
 * @ClassName: DealTaskProcess
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/4/23 10:35
 * @Version: V1.0
 */
public interface DealTaskProcess {
    String reviewTaskFromPass(String reviewJsonStr);

    void dealTaskByPrRules();

    void saveDataToDb();
}
