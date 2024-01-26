package designpatten.builder;

import lombok.Data;

/**
 * @ClassName: MyBuilderOutClass
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/24 13:53
 * @Version: V1.0
 */
public class MyOutClass {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public MyOutClass(MyOutClassBuilder builder){
        this.name = builder.getName();
        this.age = builder.getAge();
    }
}
