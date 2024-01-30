package designpatten.responsiblechain.doallhandler;

/**
 * @ClassName: MyJsonAddInfoChain
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/30 9:41
 * @Version: V1.0
 */
public class MyJsonAddInfoChain extends MyChainAllAbstract {

    @Override
    public void doHandle(String jsonStr) {
        System.out.println("做json的修改，补充信息串添加内容。。。");
    }
}
