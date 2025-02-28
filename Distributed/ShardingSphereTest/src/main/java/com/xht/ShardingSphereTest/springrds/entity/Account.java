package com.xht.ShardingSphereTest.springrds.entity;

/**
 * @ClassName: Account
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2025/2/27 13:47
 * @Version: V1.0
 */
public class Account {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
