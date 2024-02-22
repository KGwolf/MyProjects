package juc;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: countdownlatch
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/2/18 16:12
 * @Version: V1.0
 */
public class countdownlatch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 15; i++) {
            new Thread(()->{
                try {
                    System.out.println("线程："+Thread.currentThread().getName()+"开始进入");

                    countDownLatch.await();

                    System.out.println("线程："+Thread.currentThread().getName()+"开始执行");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
            Thread.sleep(2000);
            countDownLatch.countDown();
        }

//        for (int i = 0; i < 5; i++) {
//            new Thread(() -> {
//                    countDownLatch.countDown();
//                    System.out.println("线程：" + Thread.currentThread().getName() + "开始执行");
//            }).start();
//        }
//        System.out.println("主线程--等待--");
//        countDownLatch.await();
//        System.out.println("任务完成");
    }
}
