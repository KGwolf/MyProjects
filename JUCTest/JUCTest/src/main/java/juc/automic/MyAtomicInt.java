package juc.automic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName: MyAutomicInt
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/3/8 9:39
 * @Version: V1.0
 */
public class MyAtomicInt {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();

        AtomicReference ar = new AtomicReference();

        LongAdder la = new LongAdder();
    }
}
