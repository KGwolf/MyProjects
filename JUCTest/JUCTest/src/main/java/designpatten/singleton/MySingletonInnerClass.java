package designpatten.singleton;

import lombok.Data;

import java.util.concurrent.Executors;

/**
 * @ClassName: MySingletonInnerClass
 * @Description: 内部静态类单例模式
 * 无参构造设置成private，防止外部new。
 * 既做到了延迟加载，又做到了无锁实现线程安全，简洁性和可读性也比双检锁好
 * @Author: xiahaitao
 * @Date: 2024/1/23 10:44
 * @Version: V1.0
 */
@Data
public class MySingletonInnerClass {
    private String name;
    private int age;
    /**
     * 无参构造设置成private，防止外部new
     */
    private MySingletonInnerClass() {
    }
    private static final class InstanceHolder {
        static final MySingletonInnerClass INSTANCE = new MySingletonInnerClass();
    }

    public static MySingletonInnerClass getInstance() {
        return InstanceHolder.INSTANCE;
    }
}
