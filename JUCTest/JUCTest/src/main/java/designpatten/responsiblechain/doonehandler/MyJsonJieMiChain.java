package designpatten.responsiblechain.doonehandler;

/**
 * @ClassName: MyJsonJieMiChain
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/30 9:39
 * @Version: V1.0
 */
public class MyJsonJieMiChain  extends MyChainOneAbstract {
    @Override
    public boolean doHandle(String jsonStr) {
        System.out.println("做json的解密");
        return false;
    }

}
