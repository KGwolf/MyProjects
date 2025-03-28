package com.xht.passpharmreview.cachemanager.task;

import com.xht.passpharmreview.cache.CacheBase;
import com.xht.passpharmreview.cache.CacheFactory;
import com.xht.passpharmreview.cache.localcache.caffine.CaffeineLocalCache;
import com.xht.passpharmreview.cache.remotecache.redis.RedisHashCache;
import com.xht.passpharmreview.model.screen.cachemodel.TaskCacheModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @ClassName: TaskManager
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/28 9:50
 * @Version: V1.0
 */
@Component
public class TaskManager {

    private final BiFunction<String, TaskCacheModel, TaskCacheModel> putFunc = (key, value) -> {updateDb(key, value); return null; };
    private final Function<String, TaskCacheModel> getFunc = key -> {return getFromDb(key);};
    @Autowired
    RedisHashCache<String, TaskCacheModel> taskRemoteCache;
    @Autowired
    CaffeineLocalCache<String, TaskCacheModel> localRemoteCache;
    @Autowired
    CacheFactory<String,TaskCacheModel> cacheFactory;

    public void setTaskModel(String key, TaskCacheModel json) {
        CacheBase<String, TaskCacheModel> putCache = cacheFactory.createMultiLevelWriteCacheWithDelayDoubleDelete(localRemoteCache, taskRemoteCache, putFunc);
        putCache.put(key, json);

    }

    public TaskCacheModel getTaskModel(String key) {
        CacheBase<String, TaskCacheModel> readCache = cacheFactory.createMultiLevelCacheReadThrough(localRemoteCache, taskRemoteCache, getFunc);
        return readCache.get(key);
    }

    //region 数据库的操作
    private void updateDb(String key, TaskCacheModel value) {
        //这里来做更新数据库的操作  这里很可能是插入逻辑。 又或者是修改的逻辑？ 搞一个事务来操作，比如history表+taskinfo表的操作？
    }

    private TaskCacheModel getFromDb(String key) {
        //这里来做查询数据库的操作
        return null;
    }
    //endregion

}
