package designpatten.iterator.mylistgood;



/**
 * @ClassName: MyList
 * @Description: 这是一个链表类，类似于ArrayList 实现  Collection接口
 * 这里固定写死了MyNode，是否可以优化成泛型？抽象一个类出来？
 * @Author: xiahaitao
 * @Date: 2024/1/31 15:19
 * @Version: V1.0
 */
public class MyList implements IMyCollection {
    private int elementSize = 0;
    private MyNode head;

    private MyNode tail;

    public int size() {
        return elementSize;
    }



    public MyNode get(int index) {
        if (index > elementSize -1){
            return null;
        }
        MyNode resNode = head;
        for (int i = 0; i < index; i++) {
            resNode  = resNode.getNext();
        }
        return resNode;
    }

    public void add(MyNode node) {
        if (head == null && tail == null) {
            head = tail = node;
        }else{
            tail.setNext(node);
            node.setPrev(tail);
            tail = node;
        }

        elementSize++;
    }


    @Override
    public Iiterator getIerator() {
        return new MyListIterator(this);
    }
}
