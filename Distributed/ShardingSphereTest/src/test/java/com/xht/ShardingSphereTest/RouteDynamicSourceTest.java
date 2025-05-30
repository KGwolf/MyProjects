package com.xht.ShardingSphereTest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xht.ShardingSphereTest.jdbc.entity.Account;
import com.xht.ShardingSphereTest.jdbc.mapper.AccountMapper;
import com.xht.ShardingSphereTest.springrds.config.DynamicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: RouteDynamicSourceTest
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/3/3 14:19
 * @Version: V1.0
 */
@SpringBootTest
public class RouteDynamicSourceTest {
    @Test
    void contextLoads() {
    }

    @Resource
    private AccountMapper accountMapper;

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
        DynamicDataSource.name.set("W");
        QueryWrapper<Account> wrapper = new QueryWrapper<Account>();
        wrapper.eq("id",1L);
        List<Account> courses = accountMapper.selectList(wrapper);
        courses.forEach(course -> System.out.println(course));
    }
    //endregion
}
