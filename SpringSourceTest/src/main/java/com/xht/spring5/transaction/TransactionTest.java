package com.xht.spring5.transaction;

import com.xht.spring5.mybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: TransactionTest
 * @Description: 这里运行，必须要先运行下MyBatisTest。。。。。为啥？
 *
 * 事务：提交、回滚、挂起、恢复
 *
 * @Author: xiahaitao
 * @Date: 2024/11/11 14:15
 * @Version: V1.0
 */
public class TransactionTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext acT = new AnnotationConfigApplicationContext();
        acT.register(MyTransactionConfig.class);
        acT.refresh();

        UserService user = (UserService)acT.getBean("userService");
        user.testUserService();
    }
}
