package designpatten.iterator.mylistgood;

/**
 * @ClassName: MyListIterator
 * @Description: 迭代器接口实现类
 * 这里也写死了。
 * @Author: xiahaitao
 * @Date: 2024/1/31 15:35
 * @Version: V1.0
 */
public class MyListIterator implements Iiterator {
    /**
     * 游标
     */
    private int cursor;

    private MyList myArrayList;

    public MyListIterator(MyList arrayList){
        this.myArrayList = arrayList;
    }

    @Override
    public boolean hasNext() {
        if (myArrayList.size() > cursor){
            return true;
        }
        return false;
    }

    @Override
    public MyNode currentElement() {
        return myArrayList.get(cursor);
    }

    @Override
    public void next() {
        if (myArrayList.size() > cursor){
            cursor++;
        }
    }
}
