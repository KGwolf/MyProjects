package designpatten.singleton;

import lombok.Data;

/**
 * @ClassName: MySingletonEHan
 * @Description: 饿汉式单例模式
 * 无参构造设置成private，防止外部new。
 * INSTANCE属性在类加载进内存的时候就被初始化了，类加载不存在线程安全问题。
 * INSTANCE属性设置成final，表示只能在类加载或者构造函数里面进行赋值，不允许其它地方修改。
 * INSTANCE属性设置成static，表示属性是类级别的，不是对象实例级别的。
 * @Author: xiahaitao
 * @Date: 2024/1/23 10:44
 * @Version: V1.0
 */
@Data
public class MySingletonEHan {
    private String name;
    private int age;
    /**
     * 无参构造设置成private，防止外部new
     */
    private MySingletonEHan() {
    }
    private final static MySingletonEHan INSTANCE = new MySingletonEHan();

    public static MySingletonEHan getInstance() {
        return INSTANCE;
    }
}
