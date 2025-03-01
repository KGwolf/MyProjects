package com.xht.ShardingSphereTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xht.ShardingSphereTest.jdbc.entity.Account;
import com.xht.ShardingSphereTest.jdbc.mapper.AccountMapper;
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
}
