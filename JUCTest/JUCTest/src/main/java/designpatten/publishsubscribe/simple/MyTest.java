package designpatten.publishsubscribe.simple;

/**
 * @ClassName: MyTest
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/2/8 14:32
 * @Version: V1.0
 */
public class MyTest {
    public static void main(String[] args) {
        MyPublish publish = new MyPublish();
        ISubscribe subscribe1 = new Subscribe1();
        publish.addSubscribe(subscribe1);

        publish.notifySubscribes();
    }
}
