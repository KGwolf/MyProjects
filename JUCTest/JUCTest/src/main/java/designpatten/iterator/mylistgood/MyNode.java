package designpatten.iterator.mylistgood;

import lombok.Data;

/**
 * @ClassName: MyNode
 * @Description: 链表上面的节点类
 * @Author: xiahaitao
 * @Date: 2024/1/31 15:59
 * @Version: V1.0
 */
@Data
public class MyNode{
    private MyNode prev;

    private MyNode next;

    private String name;

    private int age;

    @Override
    public String toString() {
        return "MyNode{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
