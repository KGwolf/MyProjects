package com.xht.spring5.mybatis;

import com.xht.spring5.mybatis.spring.MyMapperScan;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.io.InputStream;

/**
 * @ClassName: MyBatisConfigClass
 * @Description: 这里要配合事务Test。据说DataSource要相同，所以写了2个方法。还引入了springboot的自动配置东西。
 * @Author: xiahaitao
 * @Date: 2024/11/7 11:13
 * @Version: V1.0
 */
@Component
@ComponentScan
@MyMapperScan("com.xht.spring5.mybatis.mapper")
public class MyBatisConfigClass {
    @Bean
    @ConditionalOnMissingBean(DataSource.class)
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    //使用DataSource生成的SqlSessionFactory
    @Bean
    @ConditionalOnBean(DataSource.class)
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 配置 MyBatis 环境
        Environment environment = new Environment("development", new JdbcTransactionFactory(), dataSource);
        Configuration configuration = new Configuration(environment);

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(configuration);

        // 这里可以根据需要对SqlSessionFactory进行进一步的配置，比如添加插件等

        return sqlSessionFactory;
    }
}
