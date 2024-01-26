package designpatten.singleton;

import lombok.Data;

/**
 * @ClassName: MySingletonLanHan
 * @Description: 懒汉式单例模式
 * 无参构造设置成private，防止外部new。
 * INSTANCE属性不进行初始化，在进行getInstance方法调用的时候才进行初始化，实现懒加载。
 * INSTANCE属性只设置成static，表示属性是类级别的，不是对象实例级别的。
 * 为什么要在方法上面加synchronized呢？因为多线程并发的时候，会出现多次new的情况。
 * 但是方法上面加synchronized 会不会有效率问题？ 锁不够细化？
 * @Author: xiahaitao
 * @Date: 2024/1/23 10:44
 * @Version: V1.0
 */
@Data
public class MySingletonLanHan {
    private String name;
    private int age;
    /**
     * 无参构造设置成private，防止外部new
     */
    private MySingletonLanHan() {
    }
    private static MySingletonLanHan INSTANCE;

    public synchronized static MySingletonLanHan getInstance() {
        if (INSTANCE == null){
            INSTANCE = new MySingletonLanHan();
        }
        return INSTANCE;
    }
}
