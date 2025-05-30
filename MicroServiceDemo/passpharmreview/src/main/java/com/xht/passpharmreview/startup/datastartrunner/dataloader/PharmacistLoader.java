package com.xht.passpharmreview.startup.datastartrunner.dataloader;

import com.xht.passpharmreview.startup.datastartrunner.DataStartRunner;
import com.xht.projectcommom.util.redisutil.RedisOpsExtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PharmacistLoader
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/5/24 15:57
 * @Version: V1.0
 */
@Component
public class PharmacistLoader implements Loader {

    @Autowired
    RedisOpsExtUtil redisOpsExtUtil;

    public PharmacistLoader(DataStartRunner dataStartRunner) {
        dataStartRunner.register(this);
    }
    @Override
    public void load() {
        System.out.println("真正的从数据库加载药师到缓存");
        //这里模拟假数据，存到redis和本地缓存
        //如果redis缓存已经有了，就拉取下来？没有就从数据库中去取
        if (redisOpsExtUtil.hasKey("PR:INITLOAD:pharmacist")){
            //获取redis缓存存入本地缓存
        }else{
            //从数据库加载缓存数据
        }
    }
}
