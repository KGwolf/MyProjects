package juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: reentrylock
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2024/2/18 11:26
 * @Version: V1.0
 */
public class reentrylock {
    public static void ordinary(){
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
            try {
                lock.lock();
                System.out.println("线程1执行。。");
                Thread.sleep(200);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
                System.out.println("线程1解锁。。");
            }
        }).start();

        new Thread(()->{
            try {
                lock.lock();
                System.out.println("线程2执行。。");
                Thread.sleep(200);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
                System.out.println("线程2解锁。。");
            }
        }).start();
    }

    public static void condition(){
        ReentrantLock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();
                System.out.println("线程1执行。。");
                condition1.await();
                Thread.sleep(200);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
                System.out.println("线程1解锁。。");
            }
        }).start();

        new Thread(()->{
            try {
                lock.lock();
                condition1.signal();
                System.out.println("线程2执行。。");
                Thread.sleep(200);
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
                System.out.println("线程2解锁。。");
            }
        }).start();
    }

    public static void main(String[] args) {
//        ordinary();
        condition();


    }
}
