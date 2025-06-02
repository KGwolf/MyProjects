package com.xht.passpharmreview.cache;

import com.xht.passpharmreview.cache.cachedesign.CacheDelayDoubleDelete;
import com.xht.passpharmreview.cache.cachedesign.CacheReadThrough;
import com.xht.passpharmreview.cache.cachedesign.CacheWriteThrough;
import com.xht.passpharmreview.cache.multicache.MultiLevelCacheDelayDoubleDelete;
import com.xht.passpharmreview.cache.multicache.MultiLevelCacheOnlyUpdateCache;
import com.xht.passpharmreview.cache.multicache.MultiLevelCacheReadThrough;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @ClassName: CacheFactory
 * @Description: 这些东西还是只能用CacheBase接口，因为获取到了之后，还要放到缓存中。
 * @Author: xiahaitao
 * @Date: 2025/3/28 15:40
 * @Version: V1.0
 */
@Component
public class CacheFactory<K, V> {

    //region 单缓存  redis or localcache
    public CacheBase<K, V> createReadCache(CacheBase<K, V> cacheManager, Function<K, V> getFunc) {
        return new CacheReadThrough<K, V>(cacheManager, getFunc);
    }

    public CacheBase<K, V> createWriteCache(CacheBase<K, V> cacheManager, BiFunction<K, V, V> putFunc) {
        return new CacheWriteThrough<K, V>(cacheManager, putFunc);
    }

    public CacheBase<K, V> createWriteCacheWithDelayDoubleDelete(CacheBase<K, V> cacheManager, BiConsumer<K, V> putFunc) {
        return new CacheDelayDoubleDelete<K, V>(cacheManager, putFunc);
    }
    //endregion

    //region 多级缓存
    public CacheBase<K, V> createMultiLevelWriteCacheWithDelayDoubleDelete(CacheBase<K, V> localCache, CacheBase<K, V> remoteCache, BiConsumer<K, V> putFunc) {
        return new MultiLevelCacheDelayDoubleDelete<K, V>(localCache, remoteCache, putFunc);
    }

    /**
     * 多级缓存---延迟双删---多条记录
     * @param localCache
     * @param remoteCache
     * @param putManyFunc
     * @return
     */
    public MapCacheBase<K, V> createMultiLevelWriteCacheWithDelayDoubleDelete(CacheBase<K, V> localCache, CacheBase<K, V> remoteCache, Consumer<Map<K,V>> putManyFunc) {
        return new MultiLevelCacheDelayDoubleDelete<K, V>(localCache, remoteCache, putManyFunc);
    }

    public  CacheBase<K, V> createMultiLevelCacheReadThrough(CacheBase<K, V> localCache, CacheBase<K, V> remoteCache,  Function<K, V> getFunc)
    {
        return new MultiLevelCacheReadThrough<K, V>(localCache, remoteCache, getFunc);
    }

    public CacheBase<K, V> createMultiLevelOnlyWriteCache(CacheBase<K, V> localCache, CacheBase<K, V> remoteCache) {
        return new MultiLevelCacheOnlyUpdateCache<K, V>(localCache, remoteCache);
    }
    //endregion
}
