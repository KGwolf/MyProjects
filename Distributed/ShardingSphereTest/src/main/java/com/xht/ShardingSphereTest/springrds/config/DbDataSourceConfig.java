//package com.xht.ShardingSphereTest.springrds.config;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * @ClassName: DbDataSourceConfig
// * @Description: TODO
// * @Author: xiahaitao
// * @Date: 2025/2/27 20:46
// * @Version: V1.0
// */
////@Configuration
//public class DbDataSourceConfig {
//
//    @Bean(name = "dataSource1")
//    @ConfigurationProperties(prefix = "spring.datasource.datasource1")
//    public DataSource dataSource1() {
//        // 底层会自动拿到spring.datasource中的配置， 创建一个DruidDataSource
//        return DruidDataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "dataSource2")
//    @ConfigurationProperties(prefix = "spring.datasource.datasource2")
//    public DataSource dataSource2() {
//        // 底层会自动拿到spring.datasource中的配置， 创建一个DruidDataSource
//        return DruidDataSourceBuilder.create().build();
//    }
//}
