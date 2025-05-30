package com.xht.passpharmreview.distributedlock;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: DistributedLock
 * @Description: 分布式锁的抽象接口，可以用redisson、zookeeper等实现
 * @Author: xiahaitao
 * @Date: 2025/5/24 21:15
 * @Version: V1.0
 */
public interface DistributedLock {
    // 获取可重入锁（默认非公平锁）
    boolean tryLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit);
    void unlock(String lockKey);

    // 公平锁（适用于高并发场景下的顺序性保障）
    boolean tryFairLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit);

    // 闭锁（适用于多线程协同场景）
    void countDownLatch(String latchKey, int count);
    void await(String latchKey) throws InterruptedException;

    // 信号量（流量控制）
    boolean trySemaphore(String semaphoreKey, int permits, long waitTime, TimeUnit unit);
    void releaseSemaphore(String semaphoreKey, int permits);
}
