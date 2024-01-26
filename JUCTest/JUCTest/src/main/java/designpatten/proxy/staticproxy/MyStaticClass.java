package designpatten.proxy.staticproxy;

/**
 * @ClassName: MyStaticClass
 * @Description: 原始类
 * @Author: xiahaitao
 * @Date: 2024/1/24 15:06
 * @Version: V1.0
 */
public class MyStaticClass implements IMyStaticClass {

    private String name;

    private int age;

    /**
     *  如果需要获取打印这个方法的执行时间、请求参数、返回内容等信息，怎么做？
     *
     */
    @Override
    public void doMyStage() {
        //从数据库获取数据、处理、赋值
        System.out.println("从数据库获取数据、处理、赋值");
    }
}
