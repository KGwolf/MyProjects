package com.xht.passpharmreview.distributedlock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: RedissonLockServiceImpl
 * @Description: redisson分布式锁实现类
 * @Author: xiahaitao
 * @Date: 2025/5/24 21:17
 * @Version: V1.0
 */
@Service
@ConditionalOnProperty(name = "distributed.lock.type", havingValue = "redis")
public class RedissonLockServiceImpl implements DistributedLock {
    @Autowired
    private RedissonClient redissonClient;

    @Override
    public boolean tryLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public void unlock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        if (lock.isLocked() && lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }

    // 公平锁实现
    @Override
    public boolean tryFairLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) {
        RLock fairLock = redissonClient.getFairLock(lockKey);
        try {
            return fairLock.tryLock(waitTime, leaseTime, unit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }

    // 闭锁和信号量实现（参考 Redisson 的 RCountDownLatch 和 RSemaphore）
    @Override
    public void countDownLatch(String latchKey, int count) {

    }

    @Override
    public void await(String latchKey) throws InterruptedException {

    }

    @Override
    public boolean trySemaphore(String semaphoreKey, int permits, long waitTime, TimeUnit unit) {
        return false;
    }

    @Override
    public void releaseSemaphore(String semaphoreKey, int permits) {

    }

}
