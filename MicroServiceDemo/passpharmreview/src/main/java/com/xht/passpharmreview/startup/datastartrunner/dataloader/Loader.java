package com.xht.passpharmreview.startup.datastartrunner.dataloader;

/**
 * @ClassName: Loader
 * @Description: 程序启动数据加载接口（各种各样的数据：药师缓存数据、各种字典数据、任务缓存数据等等）
 * @Author: xiahaitao
 * @Date: 2025/5/24 15:40
 * @Version: V1.0
 */
public interface Loader {

    /***
     * @param
     * @return void
     * @Description 执行具体的Loader  逻辑
     * @Author xiahaitao
     * @Date 2025/5/24 15:41
     */
    void load();

    /**
     * @param
     * @return int
     * @Description 执行Loader 的顺序
     * @Author xiahaitao
     * @Date 2025/5/24 15:41
     */
    default int getOrder() {
        return 0;
    }
}
