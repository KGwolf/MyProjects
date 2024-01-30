package designpatten.responsiblechain.doallhandler;

/**
 * @ClassName: IMyChain
 * @Description: 这是所有处理器的抽象父类。
 * 这里不适合接口的原因：需要有属性：
 * 1.如果是只执行1个handler，需要1个属性来表示下一个handler。
 *
 * 2.如果所有的handler都需要进行执行。则可以改成接口，在组合类里面进行循环调用List集合中的handler
 *
 * @Author: xiahaitao
 * @Date: 2024/1/30 9:38
 * @Version: V1.0
 */
public abstract class MyChainAllAbstract {
    /**
     * 下一个handler对象
     */
    protected MyChainAllAbstract nextChain;
    /**
     * 这是模板方法模式
     */
    protected final void handle(String jsonStr) {
        //这里调用自己这个handler的dohandle模版方法。
        doHandle(jsonStr);
        if (nextChain!=null){
            //如果属性next handle存在，则调用handle方法。
            nextChain.handle(jsonStr);
        }
    }

    public abstract void doHandle(String jsonStr);
}
