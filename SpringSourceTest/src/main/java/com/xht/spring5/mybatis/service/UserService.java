package com.xht.spring5.mybatis.service;

import com.xht.spring5.mybatis.mapper.OrderMapper;
import com.xht.spring5.mybatis.mapper.ProductMapper;
import com.xht.spring5.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: xiahaitao
 * @Date: 2024/11/7 11:20
 * @Version: V1.0
 */
@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Transactional
    public void testUserService(){
        boolean transactionActive = TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println("事务是否开启: " + transactionActive);
        if (transactionActive) {
            String transactionName = TransactionSynchronizationManager.getCurrentTransactionName();
            System.out.println("当前事务名称：" + transactionName);
        }

        System.out.println("进入testUserService方法");
        String userName = userMapper.getUserName();
        String orderName = getOrderName();
        System.out.println("orderName的值为："+orderName);
        String productName = productMapper.getProductName();
        System.out.println("执行完getUserName："+userName);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String getOrderName(){
        boolean transactionActive = TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println("事务是否开启: " + transactionActive);
        if (transactionActive) {
            String transactionName = TransactionSynchronizationManager.getCurrentTransactionName();
            System.out.println("当前事务名称：" + transactionName);
        }

        String orderName = orderMapper.getOrderName();
        return orderName;
    }
}