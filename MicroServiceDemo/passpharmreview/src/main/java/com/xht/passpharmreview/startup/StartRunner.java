package com.xht.passpharmreview.startup;

import org.springframework.core.Ordered;

/**
 * @ClassName: StartRunner
 * @Description: 程序启动时需要执行的业务接口
 * @Author: xiahaitao
 * @Date: 2025/5/24 14:45
 * @Version: V1.0
 */
public interface StartRunner {
    /***
     * @param
     * @return void
     * @Description 执行逻辑方法
     * @Author xiahaitao
     * @Date 2025/5/24 14:46
     */
    void run();

    /***
     * @param
     * @return int
     * @Description 实现此接口的业务类的执行顺序
     * @Author xiahaitao
     * @Date 2025/5/24 14:47
     */
    default int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
