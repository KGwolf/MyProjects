package designpatten.iterator.mylistgood;

/**
 * @ClassName: MyTest
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/31 15:12
 * @Version: V1.0
 */
public class MyTest {
    public static void main(String[] args) {

        MyList myArrayList = new MyList();
        MyNode node1 = new MyNode();
        node1.setName("夏1");
        MyNode node2 = new MyNode();
        node2.setName("夏2");
        MyNode node3 = new MyNode();
        node3.setName("夏3");
        myArrayList.add(node1);
        myArrayList.add(node2);
        myArrayList.add(node3);

        Iiterator ierator2 = myArrayList.getIerator();
        while (ierator2.hasNext()){
            MyNode myNode = (MyNode) ierator2.currentElement();
            System.out.println(myNode.getName());
            ierator2.next();
        }

    }
}
