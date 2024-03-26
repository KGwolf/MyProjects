package juc;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: MyQueue
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/3/11 16:28
 * @Version: V1.0
 */
public class MyQueue {
    SoftReference<String> sr = new SoftReference<>("1");
}
