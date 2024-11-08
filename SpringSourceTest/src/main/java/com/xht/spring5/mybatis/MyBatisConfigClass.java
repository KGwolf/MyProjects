package com.xht.spring5.mybatis;

import com.xht.spring5.mybatis.spring.MyMapperScan;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @ClassName: MyBatisConfigClass
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/11/7 11:13
 * @Version: V1.0
 */
@Component
@ComponentScan
@MyMapperScan("com.xht.spring5.mybatis.mapper")
public class MyBatisConfigClass {
//    @Bean
//    public SqlSessionFactory sqlSessionFactory() throws Exception{
//        String resource = "mybatis.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        return sqlSessionFactory;
//    }
}
