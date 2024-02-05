package designpatten.iterator;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @ClassName: ArrayIterator
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/1/31 14:48
 * @Version: V1.0
 */
public class ArrayIterator<T> implements Iiterator<T> {
    /**
     * 游标
     */
    private int cursor;

    private ArrayList<T> arrayList;

    public ArrayIterator(ArrayList<T> arrayList){
        this.arrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        if (arrayList.size() > cursor){
            return true;
        }
        return false;
    }

    @Override
    public T currentElement() {
        return arrayList.get(cursor);
    }

    @Override
    public void next() {
        if (arrayList.size() > cursor){
            cursor++;
        }
    }


}
