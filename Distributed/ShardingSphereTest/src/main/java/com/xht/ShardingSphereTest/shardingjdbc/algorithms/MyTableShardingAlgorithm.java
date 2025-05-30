package com.xht.ShardingSphereTest.shardingjdbc.algorithms;

import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.Properties;

/**
 * @ClassName: MyTableShardingAlgorithm
 * @Description: 基于standard策略 + 自定义算法（可以是type为CLASS_BASED，也可以是自定义的type）
 * @Author: xiahaitao
 * @Date: 2025/3/10 14:05
 * @Version: V1.0
 */
public class MyTableShardingAlgorithm implements StandardShardingAlgorithm<Long> {
    private Properties props;
    private Collection<String> shardingColumns;

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
        String targetTable = logicTableName + "_" + (value % 2 + 1);
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
        return "MyCustom";

    }
}
