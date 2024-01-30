package designpatten.responsiblechain.doallhandler;

/**
 * @ClassName: MyJsonJieMiChain
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/30 9:39
 * @Version: V1.0
 */
public class MyJsonJieMiChain  extends MyChainAllAbstract {
    @Override
    public void doHandle(String jsonStr) {
        System.out.println("做json的解密");
    }

}
