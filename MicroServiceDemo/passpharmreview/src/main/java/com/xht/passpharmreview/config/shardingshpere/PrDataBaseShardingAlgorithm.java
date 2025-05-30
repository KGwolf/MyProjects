package com.xht.passpharmreview.config.shardingshpere;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @ClassName: PrDataBaseShardingAlgorithm
 * @Description: PR的数据库分片算法
 * @Author: xiahaitao
 * @Date: 2025/4/3 14:41
 * @Version: V1.0
 */
public class PrDataBaseShardingAlgorithm implements StandardShardingAlgorithm<Long> {
    private Properties props;
    private Collection<Long> shardingColumns;

    /***
     * @param properties
     * @return void
     * @Description 这里会注入配置文件中的配置的属性。
     * account_tbl_alg.props.后面的这些属性值
     * @Author xiahaitao
     * @Date 2025/3/10 14:37
     */
    @Override
    public void init(Properties properties) {
        this.props = properties;
    }

    /***
     * @param collection
     * @param preciseShardingValue
     * @return java.lang.String
     * @Description 处理精确分片  如 in、=
     * @Author xiahaitao
     * @Date 2025/3/10 14:31
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {
        //collection 就是所有的库的集合。master1、master2
        //这里可以筛选出来master开头的那些，也就是要参与分库的那些库。其它的就是不参与分库的库（比如VIPPPP医院的单独的库。）
        List<String> masterList = collection.stream().filter(x -> x.startsWith("master")).collect(Collectors.toList());
        long value = preciseShardingValue.getValue();

        //拿value对masterList的个数进行取余，然后返回索引对应的masterList的值
        int index = (int) (value % masterList.size());

        //TODO:如果是vip医院，根据mhiscode来找到对应的库。应该有个映射关系表? 或者直接找对应的vip+mhiscode的逻辑库名称
        //怎么知道是不是vip医院呢？

        return masterList.get(index);

    }

    /***
     * @param collection
     * @param rangeShardingValue
     * @return java.util.Collection<java.lang.String>
     * @Description 处理范围分片 如 between、>、<、>=、<=
     * @Author xiahaitao
     * @Date 2025/3/10 14:32
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Long> rangeShardingValue) {
        return Collections.emptyList();
    }

    @Override
    public Properties getProps() {
        return null;
    }

    /***
     * @param
     * @return java.lang.String
     * @Description 不用CLASS_BASED算法的时候，需要重写这个方法。
     * @Author xiahaitao
     * @Date 2025/3/10 17:20
     */
    @Override
    public String getType() {
//        return StandardShardingAlgorithm.super.getType();
        return "CUSTOME-DB";

    }
}
