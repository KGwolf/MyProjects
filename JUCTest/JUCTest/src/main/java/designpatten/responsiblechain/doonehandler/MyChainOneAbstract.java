package designpatten.responsiblechain.doonehandler;

/**
 * @ClassName: IMyChain
 * @Description: 这是所有处理器的抽象父类。
 * 这里不适合接口的原因：需要有属性：
 * 1.如果是只执行1个handler,这里的能不能执行，
 * 需要具体执行到了某一个handler之后，根据返回值来确定。
 *      所以需要1个属性来表示下一个handler。
 *
 * 2.如果所有的handler都需要进行执行。则可以改成接口，在组合类里面进行循环调用List集合中的handler
 *
 *  如果它能处理该请求，就不继续往下传递；如果不能处理，则交由后面的处理器来处理。
 * @Author: xiahaitao
 * @Date: 2024/1/30 9:38
 * @Version: V1.0
 */
public abstract class MyChainOneAbstract {
    /**
     * 下一个handler对象
     */
    protected MyChainOneAbstract nextChain;
    /**
     * 这是模板方法模式
     * 这里为什么要用模版方法呢？
     * 子类重写之后，容易忘记调用nextChain.handle()。
     */
    protected final void handle(String jsonStr) {
        //这里调用自己这个handler的dohandle模版方法。
       boolean canHandle = doHandle(jsonStr);
        if (nextChain!=null && !canHandle){
            //如果属性next handle存在，则调用handle方法。
            nextChain.handle(jsonStr);
        }
    }

    public abstract boolean doHandle(String jsonStr);
}
