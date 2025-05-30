package com.xht.passpharmreview.startup;

import com.xht.passpharmreview.distributedlock.DistributedLock;
import com.xht.projectcommom.util.redisutil.RedisOpsExtUtil;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: StartUp
 * @Description: 启动类（完成程序启动时需要执行的操作：redis缓存加载、数据加载、后台任务等）
 *         TODO：微服务多个节点同时启动，本地缓存倒是无所谓，都加载，但是redis缓存怎么办呢？
 *              1.分布式锁？那如果中途再多启动一台机器呢？还需要redis存一个标记，代表是否已经加载过缓存了？
 * @Author: xiahaitao
 * @Date: 2025/5/24 14:29
 * @Version: V1.0
 */
@Slf4j
@Component
public class Startup implements ApplicationRunner {
    /**
     * StartRunner集合
     */
    private final Collection<StartRunner> runners = new ArrayList<>();
    /**
     * redisson 操作类
     * 跟下面的 distributedLock 二选一
     */
    @Autowired
    RedissonClient redission;
    /**
     * 分布式锁的接口，根据配置来使用不同的中间件实现分布式锁
     */
    @Autowired
    DistributedLock distributedLock;
    /**
     * 普通redis操作的工具类
     */
    @Autowired
    RedisOpsExtUtil redisOpsExtUtil;

    private String lockPath = "/init_load_db";
    private String lockHasInited = "/inited_load_db";

    public void register(StartRunner runner) {
        if (runner == null) {
            throw new NullPointerException("runner参数指向null");
        }
        runners.add(runner);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.error("开始执行Runner");
        //TODO:获取分布式锁，加载完成后，在释放锁之前，给redis中的标记进行赋值，后续节点判断这个标记从而不加载redis缓存。中途启动的服务节点也是一样的效果。
        //TODO：还有就是，加载redis可以用分布式，但是本地缓存是每个节点都需要的（比如药师等字典表），等第一个节点查找完成之后从redis上拿数据到本地

        boolean successLock = distributedLock.tryLock(lockPath, 60 * 60 * 2, 60 * 60 * 2, TimeUnit.SECONDS);
        if (successLock) {
            try {
                List<StartRunner> runnersList = new ArrayList<>(runners);
                runnersList.sort(Comparator.comparingInt(StartRunner::getOrder));
                for (StartRunner runner : runnersList) {
                    try {
                        runner.run();
                    } catch (Exception e) {
                        log.error("Runner执行发生错误，class={}", runner.getClass().getName(), e);
                    }
                }
                //下面这行代码貌似没用，因为都需要执行初始化加载数据，不同的是，第一个节点需要从数据库中去获取数据，放到它的本地和redis中。剩下的所有节点只需要从redis里面去获取数据即可。 所以在具体加载数据的时候，需要判断redis中是否有对应的数据，有就拉取下来即可。
                //redisOpsExtUtil.set(lockHasInited, "1");//不用设置过期时间，如果是需要重启加载缓存的话，那说明redis里面的数据都被清空了的。
            } finally {
                distributedLock.unlock(lockPath);
            }
        }


//        RLock lock = redission.getLock(lockPath);
//        try {
//            //lock.tryLock(10,3600000, TimeUnit.SECONDS) 第一个参数是锁的等待时间，第二个参数是锁的过期时间
//            //lock.locktryLock(10, TimeUnit.SECONDS) ; 不设置过期时间就是使用看门狗机制，默认30s的过期时间。
//            //redisson的看门狗机制也不能无限的续期，最多30秒。那么这里是不是要考虑就用普通的分布式锁就行了？业务的特殊性，这是启动的时候，所以可以特殊一点？
//            //这里初始化不释放锁，别的节点一直等待，因为这是初始化，所以可以这样做，如果其它场景，可以等待时间短一点，然后通过redis的发布订阅+countdownlatch来优化。
//            if (lock.tryLock(3600000, 3600000, TimeUnit.SECONDS)) {
//
//                List<StartRunner> runnersList = new ArrayList<>(runners);
//                runnersList.sort(Comparator.comparingInt(StartRunner::getOrder));
//                for (StartRunner runner : runnersList) {
//                    try {
//                        runner.run();
//                    } catch (Exception e) {
//                        log.error("Runner执行发生错误，class={}", runner.getClass().getName(), e);
//                    }
//                }
//                //还要设置redis已经完成加载的标记。
////                checkFlash(id, productInfo);
////                redisOpsUtil.set(RedisKeyPrefixConst.PRODUCT_DETAIL_CACHE + id, productInfo, 360, TimeUnit.SECONDS);
//            } else {
//                //这里是获取锁超时之后的逻辑，判断加载完没有。
//                //productInfo = redisOpsUtil.get(RedisKeyPrefixConst.PRODUCT_DETAIL_CACHE + id, PmsProductParam.class);
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (lock.isLocked()) {
//                if (lock.isHeldByCurrentThread()) {
//                    lock.unlock();
//                }
//            }
//
//        }

    }
}
