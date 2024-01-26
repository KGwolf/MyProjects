package designpatten.singleton;

import lombok.Data;

/**
 * @ClassName: MySingletonDoubleLock
 * @Description: 双重检测锁单例模式
 * 无参构造设置成private，防止外部new。
 * INSTANCE属性不进行初始化，在进行getInstance方法调用的时候才进行初始化，实现懒加载。
 * INSTANCE属性只设置成static，表示属性是类级别的，不是对象实例级别的。
 * 为什么要进行2次检测null呢？
 * 第一次判断，是为了不必要的同步代码块执行，解决了懒汉式的并发问题。第二次检测是为了避免多次new对象
 * 在idea中写双重检测锁，会给你提示，进行优化成静态内部类的方式。
 * @Author: xiahaitao
 * @Date: 2024/1/23 10:44
 * @Version: V1.0
 */
@Data
public class MySingletonDoubleLock {
    private String name;
    private int age;
    /**
     * 无参构造设置成private，防止外部new
     */
    private MySingletonDoubleLock() {
    }
    private static MySingletonDoubleLock INSTANCE;

    public static MySingletonDoubleLock getInstance() {
        if (INSTANCE == null){
            synchronized (MySingletonDoubleLock.class){
                if (INSTANCE == null){
                    INSTANCE = new MySingletonDoubleLock();
                }
            }
        }
        return INSTANCE;
    }
}
