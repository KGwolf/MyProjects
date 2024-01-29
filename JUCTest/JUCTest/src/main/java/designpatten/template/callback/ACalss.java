package designpatten.template.callback;

/**
 * @ClassName: ACalss
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/29 11:13
 * @Version: V1.0
 */
public class ACalss {
    public static void main(String[] args) {
        BClass b = new BClass();
        b.callbackA(() -> System.out.println("A方法里面设置的回调被调用了！"));
    }
}
