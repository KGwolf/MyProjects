package com.xht.passpharmreview.cache.cachedesign;

import com.xht.passpharmreview.cache.CacheBase;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @ClassName: CacheDelayDoubleDelete
 * @Description: 缓存延迟双删的实现。
 * 然后这里直接实现cachebase接口，就会实现很多的不必要的接口。
 * @Author: xiahaitao
 * @Date: 2025/3/28 15:31
 * @Version: V1.0
 */
public class CacheDelayDoubleDelete<K, V> implements CacheBase<K, V> {

    private final CacheBase<K, V> cache;

    // 定义一个私有的 Function 变量，类似于 C# 的 Func<K, V>
    //这里用BiFunction感觉没必要，因为不需要返回值。或者返回Key值就行了。BiConsumer这个就是没有返回值的。
    //还有这个key 和 value 的作用是啥，感觉不需要key呢？还是需要的，因为要根据key去缓存里面找到记录，然后再删除。
    private BiConsumer<K, V> putFunc = (key, value) -> {
    };

    private Consumer<Map<K, V>> putManyFunc = map -> {
    };

    private final ScheduledExecutorService scheduler;
    // 延迟时间，单位为秒
    private static final long DELAY_TIME = 1;


    //这里如果多个构造方法，都是2个参数要报错 'CacheDelayDoubleDelete(CacheBase<K, V>, BiFunction<K, V, V>)' clashes with 'CacheDelayDoubleDelete(CacheBase<K, V>, BiFunction<K, Collection<V>, V>)'; both methods have same erasure
    //垃圾解决法：换下参数的位置。。。。 换一个参数类型
    public CacheDelayDoubleDelete(CacheBase<K, V> cache, BiConsumer<K, V> putFunc) {
        this.cache = cache;
        this.putFunc = putFunc;
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }

    public CacheDelayDoubleDelete(CacheBase<K, V> cache, Consumer<Map<K, V>> putManyFunc) {
        this.cache = cache;
        this.putManyFunc = putManyFunc;
        scheduler = Executors.newSingleThreadScheduledExecutor();
    }


    @Override
    public V get(K key) {
        //先读缓存
        return cache.get(key);
    }

    @Override
    public void put(K key, V value) {
        //1、先删除缓存
        cache.remove(key);
        putFunc.accept(key, value);
        // 调度第二次删除缓存的任务
        scheduler.schedule(() -> {
            cache.remove(key);
        }, DELAY_TIME, TimeUnit.SECONDS);

    }

    @Override
    public void remove(K key) {
        cache.remove(key);
    }

    /***
     * @param map
     * @return void
     * @Description 修改多条记录的延迟双删实现
     * @Author xiahaitao
     * @Date 2025/5/29 10:03
     */
    @Override
    public void putMany(Map<K, V> map) {
        Set<K> ks = map.keySet();
        Collection<V> values = map.values();
        //1、先删除缓存
        cache.removeMany(ks);
        putManyFunc.accept(map);
        // 调度第二次删除缓存的任务
        scheduler.schedule(() -> {
            cache.removeMany(ks);
        }, DELAY_TIME, TimeUnit.SECONDS);
    }

    @Override
    public Collection<V> getAll() {
        return cache.getAll();
    }

    @Override
    public Collection<V> getMany(Collection<K> keys) {
        return cache.getMany(keys);
    }

    @Override
    public void removeMany(Collection<K> keys) {
        cache.removeMany(keys);
    }

    @Override
    public void removeAll() {
        cache.removeAll();
    }
}
