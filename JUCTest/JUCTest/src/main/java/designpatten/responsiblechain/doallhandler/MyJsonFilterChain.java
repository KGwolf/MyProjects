package designpatten.responsiblechain.doallhandler;

/**
 * @ClassName: MyJsonFilterChain
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/30 9:40
 * @Version: V1.0
 */
public class MyJsonFilterChain extends MyChainAllAbstract {
    @Override
    public void doHandle(String jsonStr) {
        System.out.println("json过滤。。。。");
    }
}
