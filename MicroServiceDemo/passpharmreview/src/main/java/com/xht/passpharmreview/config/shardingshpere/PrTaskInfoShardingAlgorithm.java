package com.xht.passpharmreview.config.shardingshpere;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

/**
 * @ClassName: PrTaskListShardingAlgorithm
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/4/3 15:16
 * @Version: V1.0
 */
public class PrTaskInfoShardingAlgorithm implements StandardShardingAlgorithm<Long> {
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
        long value = preciseShardingValue.getValue();
        String logicTableName = preciseShardingValue.getLogicTableName();//操作的逻辑表 course
        //2主2从，所以这里余2。这里应该读sql应该会走对应的从库？
        String targetTable = logicTableName + (value % 2 + 1);
        if (collection.contains(targetTable)) {
            return targetTable;
        }
        throw new IllegalArgumentException("无法路由到分表，分片值：" + value);
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
        return "CUSTOME-TASKINFO-TABLE";

    }
}
