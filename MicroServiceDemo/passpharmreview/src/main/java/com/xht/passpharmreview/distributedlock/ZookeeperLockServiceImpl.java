package com.xht.passpharmreview.distributedlock;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ZookeeperLockServiceImpl
 * @Description: zk分布式锁实现类
 * @Author: xiahaitao
 * @Date: 2025/5/24 21:29
 * @Version: V1.0
 */
@Slf4j
@Service
@ConditionalOnProperty(name = "distributed.lock.type", havingValue = "zookeeper")
public class ZookeeperLockServiceImpl implements DistributedLock{
    @Autowired
    private CuratorFramework curatorFramework;

    @Override
    public boolean tryLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) {
        InterProcessMutex mutex = new InterProcessMutex(curatorFramework, "/locks" + lockKey);
        try {
            return mutex.acquire(waitTime, unit);
        } catch (Exception e) {
            log.error("zk获取分布式锁失败", e);
            return false;
        }
    }

    @Override
    public void unlock(String lockKey) {
        InterProcessMutex mutex = new InterProcessMutex(curatorFramework, "/locks" + lockKey);
        try {
            mutex.release();
        } catch (Exception e) {
            // 处理异常
        }
    }

    @Override
    public boolean tryFairLock(String lockKey, long waitTime, long leaseTime, TimeUnit unit) {
        return false;
    }

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

    // 其他锁类型实现（如闭锁用 InterProcessSemaphoreV2）
}
