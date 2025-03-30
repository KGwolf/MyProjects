package com.xht.passpharmreview.cachemanager.task;

import com.xht.passpharmreview.cache.CacheBase;
import com.xht.passpharmreview.cache.CacheFactory;
import com.xht.passpharmreview.cache.localcache.caffine.CaffeineLocalCache;
import com.xht.passpharmreview.cache.remotecache.redis.RedisHashCache;
import com.xht.passpharmreview.mapper.task.TaskListMapper;
import com.xht.passpharmreview.model.screen.cachemodel.TaskListCacheModel;
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

    private final BiFunction<String, TaskListCacheModel, TaskListCacheModel> putFunc = (key, value) -> {
        updateDb(key, value);
        return null;
    };
    private final Function<String, TaskListCacheModel> getFunc = key -> {
        return getFromDb(key);
    };
    @Autowired
    RedisHashCache<String, TaskListCacheModel> taskRemoteCache;
    @Autowired
    CaffeineLocalCache<String, TaskListCacheModel> taskLocalCache;
    @Autowired
    CacheFactory<String, TaskListCacheModel> cacheFactory;

    @Autowired
    private TaskListMapper taskListMapper;

    public void setTaskModel(String key, TaskListCacheModel json) {
        CacheBase<String, TaskListCacheModel> putCache = cacheFactory.createMultiLevelWriteCacheWithDelayDoubleDelete(taskLocalCache, taskRemoteCache, putFunc);
        putCache.put(key, json);

    }

    public void addTaskListModel(String key, TaskListCacheModel json) {
        //这里是添加一条数据到数据库中。不需要操作缓存，
        addDb(key, json);
    }

    public TaskListCacheModel getTaskModel(String key) {
        CacheBase<String, TaskListCacheModel> readCache = cacheFactory.createMultiLevelCacheReadThrough(taskLocalCache, taskRemoteCache, getFunc);
        return readCache.get(key);
    }

    //region 数据库的操作
    private void updateDb(String key, TaskListCacheModel value) {
        //这里只是用来修改，根据key找到对应的值，然后进行修改，修改哪些值呢？可以弄多个方法。一个方法更新不同的值。
        //其实这里只需要修改userid 和 status就行了。因为一个任务的变化就这2个地方。
        taskListMapper.updateTaskList(value);
    }

    /**
     * @description: 添加一条数据到taskinfo表
     * @author: xiahaitao
     * @date: 2025/3/29 17:55
     * @param: [key, value]
     * @return: void
     **/
    private void addDb(String key, TaskListCacheModel value) {
        //这里只是用来修改，根据key找到对应的值，然后进行修改，修改哪些值呢？可以弄多个方法。一个方法更新不同的值
        taskListMapper.addTaskList(value);
    }

    private TaskListCacheModel getFromDb(String key) {
        //这里来做查询数据库的操作
        return taskListMapper.getTaskList(Long.parseLong(key));
    }
    //endregion

}
