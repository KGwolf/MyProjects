package com.xht.passpharmreview.cachemanager.task;

import com.xht.passpharmreview.cache.CacheBase;
import com.xht.passpharmreview.cache.CacheFactory;
import com.xht.passpharmreview.cache.localcache.caffine.CaffeineLocalCache;
import com.xht.passpharmreview.cache.remotecache.redis.RedisHashCache;
import com.xht.passpharmreview.mapper.task.TaskListMapper;
import com.xht.passpharmreview.model.screen.cachemodel.TaskListCacheModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @ClassName: TaskManager
 * @Description: 任务管理器：审查过程中任务的操作
 * @Author: xiahaitao
 * @Date: 2025/3/28 9:50
 * @Version: V1.0
 */
@Component
public class TaskManager {

    private final BiConsumer<String, TaskListCacheModel> putFunc = this::updateDb;
    private final Consumer<Map<String,TaskListCacheModel>> putManyFunc = this::updateManyToDb;

    private final Function<String, TaskListCacheModel> getFunc = this::getFromDb;
    @Autowired
    RedisHashCache<String, TaskListCacheModel> taskRemoteCache;
    @Autowired
    CaffeineLocalCache<String, TaskListCacheModel> taskLocalCache;
    @Autowired
    CacheFactory<String, TaskListCacheModel> cacheFactory;

    @Autowired
    private TaskListMapper taskListMapper;

    /***
     * @param key
     * @param json
     * @return void
     * @Description 这个一般是修改记录用的，
     *      延迟双删有个问题：每次修改的时候redis就会删除缓存，然后下次请求还需要从数据库中去取
     * @Author xiahaitao
     * @Date 2025/4/3 10:41
     */
    public void setTaskModel(String key, TaskListCacheModel json) {
        CacheBase<String, TaskListCacheModel> putCache = cacheFactory.createMultiLevelWriteCacheWithDelayDoubleDelete(taskLocalCache, taskRemoteCache, putFunc);
        putCache.put(key, json);

    }

    /***
     * @return void
     * @Description 这个一般是修改记录用的，---多条记录
     *      延迟双删有个问题：每次修改的时候redis就会删除缓存，然后下次请求还需要从数据库中去取
     * @Author xiahaitao
     * @Date 2025/5/30 10:41
     */
    public void setManyTaskModel(Map<String,TaskListCacheModel> mapList) {
        CacheBase<String, TaskListCacheModel> putCache = cacheFactory.createMultiLevelWriteCacheWithDelayDoubleDelete(taskLocalCache, taskRemoteCache, putManyFunc);
        putCache.putMany(mapList);

    }

    /***
     * @param key
     * @param json
     * @return void
     * @Description 更新倒计时信息到本地缓存。这里不要更新到redis或者数据库，因为没有意义。就算机器宕机了，从redis取出来重新算一下时间就行了。
     * @Author xiahaitao
     * @Date 2025/4/3 13:12
     */
    public void updateRemainTimeToCache(String key, TaskListCacheModel json) {
        taskLocalCache.put(key, json);
    }

    /***
     * @param key
     * @param json
     * @return void
     * @Description 这是直接放缓存操作，一般用于新增到数据库之后的操作
     * @Author xiahaitao
     * @Date 2025/4/3 10:40
     */
    public void setTaskModelToCache(String key, TaskListCacheModel json) {
        taskLocalCache.put(key, json);
        taskRemoteCache.put(key, json);
    }

    /***
     * @param key
     * @param json
     * @return void
     * @Description 这是新增一条记录到数据库。
     * @Author xiahaitao
     * @Date 2025/4/3 10:40
     */
    public void addTaskListModel(String key, TaskListCacheModel json) {
        //这里是添加一条数据到数据库中。不需要操作缓存，
        addDb(key, json);
    }

    /***
     * @param key
     * @return com.xht.passpharmreview.model.screen.cachemodel.TaskListCacheModel
     * @Description 根据key获取值，多级缓存模式的读穿透
     * @Author xiahaitao
     * @Date 2025/4/3 10:41
     */
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

    private void updateManyToDb(Map<String,TaskListCacheModel> value) {
        //这里只是用来修改，根据key找到对应的值，然后进行修改，修改哪些值呢？可以弄多个方法。一个方法更新不同的值。
        //其实这里只需要修改userid 和 status就行了。因为一个任务的变化就这2个地方。
//        taskListMapper.updateTaskList(value);
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
