package designpatten.iterator;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: MyTest
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/31 15:12
 * @Version: V1.0
 */
public class MyTest {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        arrayList.add("6");

        String[] fruits = {"Apple", "Banana", "Orange"};
        //这里可以做优化，封装迭代器创建的细节。
        Iiterator<String> it = new ArrayIterator<>(arrayList);
        while (it.hasNext()){
            System.out.println(it.currentElement().toString());
            it.next();
        }





    }
}
