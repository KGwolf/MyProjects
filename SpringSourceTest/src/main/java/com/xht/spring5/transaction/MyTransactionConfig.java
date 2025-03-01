package com.xht.spring5.transaction;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @ClassName: MyTransactionConfig
 * @Description:
 *
 * 事务管理器的DataSource和MyBatis的DataSource必须要是1个。
 *
 * @Author: xiahaitao
 * @Date: 2024/11/11 14:16
 * @Version: V1.0
 */
@Component
@ComponentScan({"com.xht.spring5.transaction", "com.xht.spring5.mybatis"})
@EnableTransactionManagement
public class MyTransactionConfig {

//    @Bean
//    public DataSource dataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
//        dataSource.setUsername("root");
//        dataSource.setPassword("123456");
//        try {
//            dataSource.setFilters("stat");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return dataSource;
//    }
//这是其它的DataSource
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/test?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        return dataSource;
    }

    // 事务管理器配置
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource);

        //部分失败的时候全局回滚。 可以设置成false。但是同一个事务里面，要么都成功，要么都失败。
        //所以这里虽然失败了，如果设置成false，相当于就是不回滚了。
        //这个回滚是先在ThreadLocal里面设置一个标记。等提交的时候再去判断回滚不回滚。
        dataSourceTransactionManager.setGlobalRollbackOnParticipationFailure(true);

        return dataSourceTransactionManager;

    }

//    @Bean
//    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }

}
