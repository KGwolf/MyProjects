package designpatten.proxy.staticproxy;

/**
 * @ClassName: MyStaticClassProxy
 * @Description: 代理类
 * 主要是为了实现单一职责，记日志这些逻辑不适合跟主业务逻辑混合到一起
 * 这里不抽象出一个接口不行吗？
 * 在使用的时候，需要用接口来调用方法。
 * @Author: xiahaitao
 * @Date: 2024/1/24 15:33
 * @Version: V1.0
 */
public class MyStaticClassProxy  implements IMyStaticClass{
    private final MyStaticClass myStaticClass;
    public MyStaticClassProxy(MyStaticClass c1){
        myStaticClass = c1;
    }
    @Override
    public void doMyStage() {
        //做代理的逻辑，比如记录执行时间，记录入参和返回结果。
        System.out.println("记录请求参数");
        myStaticClass.doMyStage();
        System.out.println("记录返回结果");
        //做代理的逻辑，比如记录执行时间，记录入参和返回结果。
    }
}
