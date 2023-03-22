package com.xht.spring5.oneclass;

import com.xht.spring5.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyPerson
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/3/22 17:13
 * @Version: V1.0
 */
@Component
public class MyPerson {

    private String name;
    private int age;
    private Food food;
    public MyPerson() {
        super();
    }

    public MyPerson(String name, int age, Food food) {
        super();
        this.name = name;
        this.age = age;
        this.food = food;
    }

    @Autowired
    public MyPerson(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }


    public Food getFood() {
        return food;
    }
    public void setFood(Food food) {
        this.food = food;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
