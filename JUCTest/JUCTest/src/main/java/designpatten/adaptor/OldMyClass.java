package designpatten.adaptor;

/**
 * @ClassName: OldMyClass
 * @Description: 适配器模式   这是别人提供不可修改的一个类
 * 适配的是哪2个角色？外部提供内，和我们自定义一个接口（供我们内部调用）
 * 有以下几个问题：
 * 1.静态方法，影响单元测试。
 * 2.需要多个系统的相似功能的类，统一接口名字。
 * 3.这个类作为外部接口需要被另外的外部接口替换（比如从美康替换成其它厂商），或者内部的老接口需要保留
 * 4.需要对返回值做统一的处理。（比如这里方法返回的是xml字符串格式的，我们需要的是json字符串格式）
 * @Author: xiahaitao
 * @Date: 2024/1/26 14:41
 * @Version: V1.0
 */
public class OldMyClass {
    public static String readFromOld(){
        System.out.println("OldMyClass的read方法。");
        return "<xml>1</xml>";
    }
    public static String writeFromOld(){
        System.out.println("OldMyClass的write方法。");
        return "<xml>2</xml>";
    }
}
