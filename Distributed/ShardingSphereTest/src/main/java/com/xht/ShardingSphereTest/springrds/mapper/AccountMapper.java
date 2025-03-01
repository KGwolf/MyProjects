package com.xht.ShardingSphereTest.springrds.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xht.ShardingSphereTest.jdbc.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName: AccountMapper
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/2/27 13:57
 * @Version: V1.0
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
