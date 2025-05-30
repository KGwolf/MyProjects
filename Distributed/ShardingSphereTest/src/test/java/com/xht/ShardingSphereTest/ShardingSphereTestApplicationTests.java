package com.xht.ShardingSphereTest;

//import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xht.ShardingSphereTest.jdbc.entity.Account;
import com.xht.ShardingSphereTest.jdbc.mapper.AccountMapper;
import com.xht.ShardingSphereTest.springrds.config.DynamicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class ShardingSphereTestApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private AccountMapper accountMapper;


    //region jdbc 操作
    @Test
    public void addAccount() {
        for (int i = 0; i < 10; i++) {
            Account c = new Account();
            c.setName("夏海涛");
            c.setBalance(10000);
            accountMapper.insert(c);
            //insert into course values ....
            System.out.println(c);
        }
    }

    @Test
    public void queryAccount() {
        QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
        wrapper.eq("id",1L);
        List<Account> courses = accountMapper.selectList(wrapper);
        courses.forEach(course -> System.out.println(course));
    }
    //endregion

    //region 基于jdbc提供的带路由功能的数据源 操作
    @Test
    public void addAccount2() {
        DynamicDataSource.name.set("W");
        for (int i = 0; i < 10; i++) {
            Account c = new Account();
            c.setName("夏海涛");
            c.setBalance(10000);
            accountMapper.insert(c);
            //insert into course values ....
            System.out.println(c);
        }
    }

    @Test
    public void queryAccount2() {
        DynamicDataSource.name.set("R");
        QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
        wrapper.eq("id",4L);
        List<Account> courses = accountMapper.selectList(wrapper);
        courses.forEach(course -> System.out.println(course));
    }
    //endregion


    //region DS注解 操作
//    @Test
//    @DS("write")
//    public void addAccount3() {
//        DynamicDataSource.name.set("W");
//        for (int i = 0; i < 10; i++) {
//            Account c = new Account();
//            c.setName("夏海涛");
//            c.setBalance(10000);
//            accountMapper.insert(c);
//            //insert into course values ....
//            System.out.println(c);
//        }
//    }
//
//    @Test
//    @DS("read")
//    public void queryAccount3() {
//        DynamicDataSource.name.set("R");
//        QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
//        wrapper.eq("id",1L);
//        List<Account> courses = accountMapper.selectList(wrapper);
//        courses.forEach(course -> System.out.println(course));
//    }
    //endregion

    //region shardingjdbc 操作
    @Test
    public void addAccount4() {
        for (int i = 0; i < 10; i++) {
            Account c = new Account();
            c.setName("夏海涛");
            c.setBalance(10000);
            accountMapper.insert(c);
            //insert into course values ....
            System.out.println(c);
        }
    }

    @Test
    public void queryAccount4() {
        QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
//        wrapper.eq("aid",1897192875311443970L);

        //wrapper.between("aid",1897192875311443969L,1897192875311443971L);
        wrapper.in("aid",1897192875311443970L,1897192869523304449L);
        List<Account> courses = accountMapper.selectList(wrapper);
        courses.forEach(course -> System.out.println(course));
    }
    //endregion

}
