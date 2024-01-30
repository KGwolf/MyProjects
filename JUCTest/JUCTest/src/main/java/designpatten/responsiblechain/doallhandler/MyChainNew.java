package designpatten.responsiblechain.doallhandler;

/**
 * @ClassName: MyChainNew
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/30 9:37
 * @Version: V1.0
 */
public class MyChainNew {

    public static void main(String[] args) {
        MyHandleAllChain myHandleChain = new MyHandleAllChain();
        myHandleChain.addHandler(new MyJsonJieMiChain());
        myHandleChain.addHandler(new MyJsonFilterChain());
        myHandleChain.addHandler(new MyJsonAddInfoChain());

        myHandleChain.handle("111112344");
    }
}
