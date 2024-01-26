package designpatten.builder;

/**
 * @ClassName: MyBuilder
 * @Description: java内部内实现构造者模式
 * 如果不用构造模式，原来类的构造方法和set方法不行么？
 * 如果参数多了，构造方法对调用者不友好。set方法，也是参数多了之后写一大片，而且有些set属性还不提供出来。
 * 优势：想组合哪些字段来构成类，可以自由选择。把创建类的逻辑隔离出去。
 * （比如pr里面的报表头对象，不同的报表列需要初始化的字段不同，可以选择构造模式）
 * @Author: xiahaitao
 * @Date: 2024/1/24 10:46
 * @Version: V1.0
 */
public class MyBuilderInnerClass {
    /**
     * 注意，这个类里面的属性不提供set方法。
     */
    private String name;
    private int age;

    public MyBuilderInnerClass(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    /**
     * 这里用了内部静态类实现构造者模式，如果其它语言不支持这种，怎么做呢？
     */
    public static class Builder {
        private String name;
        private int age;
        private final int DEFAULT_MAX_NAME_LENGTH = 10;
        /**
         * 构造者类里面的属性不提供get方法，且set方法返回构造者实例。
         */
        public Builder setName(String name) {
            //这里也可以判断格式对不对
            if (name.length() > DEFAULT_MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("name长度超标");
            }
            this.name = name;
            return this;
        }
        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public MyBuilderInnerClass build() {
            //这里可以写额外的逻辑去判断是否赋值了。
            if ("".equals(name)) {
                throw new IllegalArgumentException("name未赋值");
            }
            return new MyBuilderInnerClass(this);
        }
    }
}
