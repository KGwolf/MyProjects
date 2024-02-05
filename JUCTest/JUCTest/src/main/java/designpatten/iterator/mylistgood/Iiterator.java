package designpatten.iterator.mylistgood;

/**
 * @ClassName: Iiterator
 * @Description: 迭代器抽象接口
 * 实现类可以有 数组迭代器、集合迭代器、链表迭代器、二叉树迭代器、图迭代器
 * 迭代器的好处：
 * 在Spark里面，不可能将所有的数据都拿到内存里面来进行计算，使用迭代器，可以减少内存的压力。
 * @Author: xiahaitao
 * @Date: 2024/1/31 14:36
 * @Version: V1.0
 */
public interface Iiterator<T> {
    /**
     * 判断是否还有下一个值
     */
    boolean hasNext();
    /**
     * 返回当前元素
     */
    T currentElement();
    /**
     * 移动游标到下一个元素
     */
    void next();
}
