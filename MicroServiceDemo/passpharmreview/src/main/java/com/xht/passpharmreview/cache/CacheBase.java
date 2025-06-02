package com.xht.passpharmreview.cache;

import java.util.Collection;
import java.util.Map;

/**
 * @ClassName: Cache
 * @Description:  单纯存储key value，也可以多个操作吧
 *
 * @Author: xiahaitao
 * @Date: 2025/3/28 10:06
 * @Version: V1.0
 */
public interface CacheBase<K, V> extends ReadCacheBase<K,V>,WriteCacheBase<K,V> {
    /**
     * 缓存是否存在数据
     * @return
     */
    boolean hasData();
}
