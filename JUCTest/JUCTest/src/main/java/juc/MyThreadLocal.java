package juc;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: MyThreadLocal
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/3/25 11:27
 * @Version: V1.0
 */
public class MyThreadLocal {
    static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(()->"0");
    static ThreadLocal<String> threadLocal2;

    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5,5,1, TimeUnit.MINUTES,new LinkedBlockingDeque<>());
    public static void main(String[] args) throws InterruptedException {
//        new Thread(()->{
//            System.out.println("线程1：开始前："+threadLocal.get());
//            threadLocal.set("100");
//            System.out.println("线程1：开始前："+threadLocal.get());
//        }).start();
//
//        Thread.sleep(100);
//
//        new Thread(()->{
//            System.out.println("线程2：开始前："+threadLocal.get());
//            threadLocal.set("200");
//            System.out.println("线程2：开始前："+threadLocal.get());
//        }).start();

        for (int i = 0; i < 1024*1024*5; i++) {
            poolExecutor.execute(()->{
                threadLocal2 = ThreadLocal.withInitial(()->"0");
                threadLocal2.set("1");

                threadLocal2.remove();
            });
        }
    }
}
