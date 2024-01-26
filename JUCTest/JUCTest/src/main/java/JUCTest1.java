


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openjdk.jol.info.ClassLayout;


/**
 * @ClassName: JUCTest1
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/9/6 10:29
 * @Version: V1.0
 */

public class JUCTest1 {


    public static void main(String[] args) throws InterruptedException {

//        ReentrantLock

        StringBuffer sb = new StringBuffer();
        sb.append("1").append("2").append("3");

        Logger log = LogManager.getLogger(JUCTest1.class);
        //HotSpot 虚拟机在启动后有个 4s 的延迟才会对每个新建的对象开启偏向锁模式
        Thread.sleep(4000);
        Object obj = new Object();
//        log.debug(Thread.currentThread().getName()+"new对象完成。。。\n"
//                +ClassLayout.parseInstance(obj).toPrintable());
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj){
                    log.debug("线程1开始执行------");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.debug("线程1释放锁------");
            }
        },"thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (obj){
                    log.debug("线程2开始执行------");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.debug("线程2释放锁------");

            }
        },"thread2").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (obj){
                    log.debug("线程3开始执行------");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.debug("线程3释放锁------");
            }
        },"thread3").start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (obj){
                    log.debug("线程4开始执行------");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.debug("线成4释放锁------");
            }
        },"thread4").start();

Thread.sleep(5000);
        log.debug(ClassLayout.parseInstance(obj).toPrintable());

    }


}


