package designpatten.publishsubscribe.simple;

/**
 * @ClassName: Subscribe1
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/2/8 14:27
 * @Version: V1.0
 */
public class Subscribe1 implements ISubscribe{
    @Override
    public void exec() {
        System.out.println("订阅者1执行逻辑");
    }
}
