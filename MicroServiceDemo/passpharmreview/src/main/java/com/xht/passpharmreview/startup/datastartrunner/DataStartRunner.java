package com.xht.passpharmreview.startup.datastartrunner;

import cn.hutool.core.collection.ConcurrentHashSet;
import com.xht.passpharmreview.startup.StartRunner;
import com.xht.passpharmreview.startup.Startup;
import com.xht.passpharmreview.startup.datastartrunner.dataloader.Loader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DataRunner
 * @Description: 启动时内存数据加载（任务、药师、医生等）
 * @Author: xiahaitao
 * @Date: 2025/5/24 15:35
 * @Version: V1.0
 */
@Slf4j
@Component
public class DataStartRunner implements StartRunner {
    /**
     * 加载器集合
     */
    private static final ConcurrentHashSet<Loader> LOADERS = new ConcurrentHashSet<>();

    public DataStartRunner(Startup startup){
        startup.register(this);
    }

    public void register(Loader loader) {
        if (loader == null) {
            throw new NullPointerException("参数loader指向null");
        }
        LOADERS.add(loader);
    }

    @Override
    public void run() {
        log.error("执行loaders");

        List<Loader> loaderList = new ArrayList<>(LOADERS);
        try {
            for (Loader loader : loaderList) {
                loader.load();
            }
        } catch (Exception e) {
            log.error("loader执行发生错误", e);
        }
    }
}
