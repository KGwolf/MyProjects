package com.xht.ShardingSphereTest.jdbc.entity;

import com.baomidou.mybatisplus.annotation.TableId;

/**
 * @ClassName: Account
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/2/27 13:47
 * @Version: V1.0
 */
public class Account {

/***
    * @param
    * @return java.lang.Long
    * @Description 注意这里，字段名称不是id的话，需要手动加上 @TableId （是id的话，mybatis plus会主动当成主键），然后类型必须是Long 包装类型
    * @Author  xiahaitao
    * @Date   2025/3/5 11:44
    */
    public Long getAid() {
        return aid;
    }

    public void setAid(Long aid) {
        this.aid = aid;
    }

    @TableId
    private Long aid;
    private String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    private int balance;

    @Override
    public String toString() {
        return "Account{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
