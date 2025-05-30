package com.xht.passpharmreview.cachemanager.dict;

import com.xht.passpharmreview.cache.CacheBase;
import com.xht.passpharmreview.cache.CacheFactory;
import com.xht.passpharmreview.cache.localcache.caffine.CaffeineLocalCache;
import com.xht.passpharmreview.cache.remotecache.redis.RedisHashCache;
import com.xht.passpharmreview.model.initload.PharmacistModel;
import com.xht.passpharmreview.model.screen.cachemodel.TaskListCacheModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName: PharmacyManager
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/5/27 20:48
 * @Version: V1.0
 */
@Component
public class PharmacyManager {
    private final BiFunction<String, PharmacistModel, PharmacistModel> putFunc = (key, value) -> {
        updateDb(key, value);
        return null;
    };
    private final Function<String, PharmacistModel> getFunc = key -> {
        return getFromDb(key);
    };
    @Autowired
    RedisHashCache<String, PharmacistModel> taskRemoteCache;
    @Autowired
    CaffeineLocalCache<String, PharmacistModel> taskLocalCache;
    @Autowired
    CacheFactory<String, PharmacistModel> cacheFactory;

    /***
     * @param
     * @return void
     * @Description 初始化的时候加载药师缓存
     * @Author xiahaitao
     * @Date 2025/5/28 20:42
     */
    public void initPharmacyCache() {
        if (!taskRemoteCache.hasKey()) {
            //不存在的时候，创建一个远程缓存，然后加载到远程缓存中、本地缓存中
            CacheBase<String, PharmacistModel> getCache = cacheFactory.createMultiLevelCacheReadThrough(taskLocalCache, taskRemoteCache, getFunc);
            getCache.getAll();
        }else{
            //存在的时候，从远程缓存中加载到本地缓存中
        }

    }

    //region 数据库的操作
    private void updateDb(String key, PharmacistModel value) {
        //这里只是用来修改，根据key找到对应的值，然后进行修改，修改哪些值呢？可以弄多个方法。一个方法更新不同的值。
        //其实这里只需要修改userid 和 status就行了。因为一个任务的变化就这2个地方。
        //taskListMapper.updateTaskList(value);
    }


    private PharmacistModel getFromDb(String key) {
        //这里来做查询数据库的操作
        return null;
        //return taskListMapper.getTaskList(Long.parseLong(key));
    }
    //endregion
}
