package juc;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: semaphore
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/2/18 11:25
 * @Version: V1.0
 */
public class semaphore {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 50,
            60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(200));
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);

        for (;;){
            Thread.sleep(100);
            executor.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.println("执行exec");
                    Thread.sleep(2000);
                } catch (Exception  e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            });
        }
    }
}
