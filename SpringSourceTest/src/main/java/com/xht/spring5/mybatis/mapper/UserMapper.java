package com.xht.spring5.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @ClassName: UserMapper
 * @Description: 为啥这里不加@Mapper注解？ 可能是spring boot里面默认扫描的路径是配置类的路径，它扫描的逻辑是有@Mapper注解的接口，而我们这里模拟的是，扫描的固定的路径，且接口全部扫描出来。
 * 这里@Mapper写了没啥用，扫描的时候不处理
 * @Author: xiahaitao
 * @Date: 2024/11/6 20:01
 * @Version: V1.0
 */
@Mapper
public interface UserMapper {
    @Select("select 'xht'")
    String getUserName();
}
