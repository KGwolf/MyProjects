package com.xht.ShardingSphereTest.springrds.config;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: DynamicDataSource
 * @Description: 利用 JDBC 提供的 带路由功能的DataSource 实现 数据源切换功能。
 * 和@DS比较 @DS是 Dynamic Data Source Spring Boot Starter 的注解，mybatis plus提供的，用来标识当前类是一个数据源，在多数据源的情况下，需要指定哪个数据源是默认数据源，默认数据源是必须的，它们的功能是一样的。
 * 必须加上@Primary注解。
 *
 * 这种对代码侵入比较大。必须在controller的方法里面进行手动设置name。
 *
 * 使用DS注解则比较简单，只需要配置文件配置多数据源，然后再类上面或者方法上使用@DS就行了。
 *
 * @Author: xiahaitao
 * @Date: 2025/3/3 13:39
 * @Version: V1.0
 */
//@Component
//@Primary
public class DynamicDataSource extends AbstractRoutingDataSource {

    //用ThreadLocal 存储当前线程的数据源名称，在每个Controller 方法里面 设置需要使用读库还是写库
    public static ThreadLocal<String> name = new ThreadLocal<>();

    @Resource(name = "dataSource1")
    private DataSource dataSource1;
    @Resource(name = "dataSource2")
    private DataSource dataSource2;

    @Override
    protected Object determineCurrentLookupKey() {
        return name.get();
    }

    @Override
    public void afterPropertiesSet() {
        //这里在类初始化完成属性设置之后执行。Spring中的东西
        Map<Object, Object> targetDataSource = new HashMap<>();
        targetDataSource.put("R", dataSource1);
        targetDataSource.put("W", dataSource2);

        super.setTargetDataSources(targetDataSource);
        super.setDefaultTargetDataSource(dataSource1);

        super.afterPropertiesSet();
    }
}
