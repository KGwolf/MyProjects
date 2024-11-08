package com.xht.spring5.mybatis.service;

import com.xht.spring5.mybatis.mapper.OrderMapper;
import com.xht.spring5.mybatis.mapper.ProductMapper;
import com.xht.spring5.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public void testUserService(){
        System.out.println("进入testUserService方法");
        String userName = userMapper.getUserName();
        String orderName = orderMapper.getOrderName();
        String productName = productMapper.getProductName();
        System.out.println("执行完getUserName："+userName);
    }
}
