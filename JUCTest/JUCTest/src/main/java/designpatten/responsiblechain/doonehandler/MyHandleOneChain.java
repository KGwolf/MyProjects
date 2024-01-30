package designpatten.responsiblechain.doonehandler;

/**
 * @ClassName: MyHandleOneChain
 * @Description: 处理链类
 * 为什么需要这个类呢？相当于是上帝类，通过组合头尾节点，给外部提供访问的作用。
 * 那为什么这里面的逻辑不写到抽象类里面去呢？单一职责原则？
 * 抽象类是对所有个体的handler的抽象，这里是对所有的handler进行组织。
 *
 * 把链式的复杂逻辑封装起来，不给外部调用者看到。
 * @Author: xiahaitao
 * @Date: 2024/1/30 10:56
 * @Version: V1.0
 */
public class MyHandleOneChain {
    //通过组合一个链表

    /**
     * 头结点
     */
    private MyChainOneAbstract head;
    /**
     * 尾结点
     */
    private MyChainOneAbstract tail;

    public void addHandler(MyChainOneAbstract handler){
        handler.nextChain = null;

        if (head == null){
            head = handler;
            tail = handler;
            return;
        }
        //下面2行代码的先后顺序不能反了！！！！！保证链式效果
        tail.nextChain = handler;
        tail = handler;
    }

    public void handle(String jsonStr){
        if (head != null){
            head.handle(jsonStr);
        }
    }
}
