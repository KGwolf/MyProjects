package com.xht.spring5.mybatis.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: ProductMapper
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/11/7 11:59
 * @Version: V1.0
 */
public interface ProductMapper {
    @Select("select 'iphone'")
    String getProductName();
}
