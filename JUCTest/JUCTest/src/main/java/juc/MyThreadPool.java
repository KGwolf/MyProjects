package juc;

import java.util.concurrent.*;

/**
 * @ClassName: MyThreadPool
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/3/26 17:18
 * @Version: V1.0
 */
public class MyThreadPool {
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,5,1, TimeUnit.MINUTES,new LinkedBlockingDeque<>());

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
    }
}
