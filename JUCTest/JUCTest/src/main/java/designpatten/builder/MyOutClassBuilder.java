package designpatten.builder;

/**
 * @ClassName: MyOutClassBuilder
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/24 14:03
 * @Version: V1.0
 */
public  class MyOutClassBuilder {
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public MyOutClassBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public MyOutClassBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public MyOutClass build(){
      return  new MyOutClass(this);
    }
}
