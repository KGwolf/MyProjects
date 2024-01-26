import designpatten.builder.MyBuilderInnerClass;
import designpatten.builder.MyOutClass;
import designpatten.builder.MyOutClassBuilder;
import designpatten.proxy.staticproxy.IMyStaticClass;
import designpatten.proxy.staticproxy.MyStaticClass;
import designpatten.proxy.staticproxy.MyStaticClassProxy;

import java.io.Serializable;

/**
 * @ClassName: MyTestClass
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/10/13 17:03
 * @Version: V1.0
 */
public class MyTestClass implements Serializable {
private void writeObject(){
}
    private final Object lock = new Object();

    public void method1() {
        synchronized (lock) {
            System.out.println("Entering method1");
            method2(); // 调用另一个同步方法
            System.out.println("Exiting method1");
        }
    }

    public void method2() {
        synchronized (lock) {
            System.out.println("Entering method2");
            // 在这里进行一些操作
            System.out.println("Exiting method2");
        }
    }

    public static void main(String[] args) {
//        MyBuilderInnerClass build = new MyBuilderInnerClass.Builder().setName("222").setAge(0).build();
//
//        MyOutClassBuilder build1 = new MyOutClassBuilder();
//        MyOutClass obj2 = build1.setAge(1).setName("1122").build();

        IMyStaticClass myc1 = new MyStaticClassProxy(new MyStaticClass());
        myc1.doMyStage();
        int a = 0;
    }
}
