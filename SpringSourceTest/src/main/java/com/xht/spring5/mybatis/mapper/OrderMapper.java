package com.xht.spring5.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: OrderMapper
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/11/7 11:58
 * @Version: V1.0
 */
public interface OrderMapper {
    @Select("select '1234'")
    String getOrderName();
}
