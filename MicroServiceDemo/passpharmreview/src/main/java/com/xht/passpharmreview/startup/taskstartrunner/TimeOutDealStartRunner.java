package com.xht.passpharmreview.startup.taskstartrunner;

import com.xht.passpharmreview.startup.StartRunner;

/**
 * @ClassName: TimeOutDealStartRunner
 * @Description: 后端超时处理执行器，里面可以开一个线程单独来运行
 * @Author: xiahaitao
 * @Date: 2025/5/24 16:36
 * @Version: V1.0
 */
public class TimeOutDealStartRunner implements StartRunner {
    @Override
    public void run() {

    }

    @Override
    public int getOrder() {
        return StartRunner.super.getOrder();
    }
}
