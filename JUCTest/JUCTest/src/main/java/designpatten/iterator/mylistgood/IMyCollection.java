package designpatten.iterator.mylistgood;

/**
 * @ClassName: MyCollection
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/31 14:39
 * @Version: V1.0
 */
public interface IMyCollection<T> {
//    int size();
//    void add(T t);
//    T get(int index);
    Iiterator<T> getIerator();
}
