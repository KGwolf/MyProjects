package com.xht.distributeuqid.simpleuqid;
import cn.hutool.core.date.SystemClock;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.StrUtil;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.concurrent.ThreadLocalRandom;

import com.sun.xml.internal.ws.util.UtilException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @ClassName: Sequence
 * @Description: 简单版本的基于雪花算法的分布式ID生成器
 * @Author: xiahaitao
 * @Date: 2025/3/19 11:03
 * @Version: V1.0
 */

public class Sequence {
    private static final Logger log = LoggerFactory.getLogger(Sequence.class);
    private final long twepoch = 1288834974657L;
    private final long workerIdBits = 5L;
    private final long datacenterIdBits = 5L;
    private final long maxWorkerId = 31L;
    private final long maxDatacenterId = 31L;
    private final long sequenceBits = 12L;
    private final long workerIdShift = 12L;
    private final long datacenterIdShift = 17L;
    private final long timestampLeftShift = 22L;
    private final long sequenceMask = 4095L;
    private final long workerId;
    private final long datacenterId;
    private long sequenceNum = 0L;
    private long lastTimestamp = -1L;
    private long timestampOffset = 5L;

    public Sequence() {
        this.datacenterId = getDatacenterId(31L);
        this.workerId = getMaxWorkerId(this.datacenterId, 31L);
    }

    public Sequence(long workerId, long datacenterId) {
        Assert.isFalse(workerId > 31L || workerId < 0L, String.format("worker Id can't be greater than %d or less than 0", 31L), new Object[0]);
        Assert.isFalse(datacenterId > 31L || datacenterId < 0L, String.format("datacenter Id can't be greater than %d or less than 0", 31L), new Object[0]);
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    protected static long getMaxWorkerId(long datacenterId, long maxWorkerId) {
        StringBuilder mpid = new StringBuilder();
        mpid.append(datacenterId);
        String name = ManagementFactory.getRuntimeMXBean().getName();
        if (StrUtil.isNotEmpty(name)) {
            mpid.append(name.split("@")[0]);
        }

        return (long)(mpid.toString().hashCode() & '\uffff') % (maxWorkerId + 1L);
    }

    protected static long getDatacenterId(long maxDatacenterId) {
        long id = 0L;

        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            if (network == null) {
                id = 1L;
            } else {
                byte[] mac = network.getHardwareAddress();
                if (null != mac) {
                    id = (255L & (long)mac[mac.length - 1] | 65280L & (long)mac[mac.length - 2] << 8) >> 6;
                    id %= maxDatacenterId + 1L;
                }
            }
        } catch (Exception e) {
            log.warn(" getDatacenterId: " + e.getMessage());
        }

        return id;
    }

    public synchronized long nextId() {
        long timestamp = this.timeGen();
        if (timestamp < this.lastTimestamp) {
            long offset = this.lastTimestamp - timestamp;
            if (offset > this.timestampOffset) {
                throw new UtilException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
            }

            try {
                ThreadUtil.safeSleep(offset << 1);
                timestamp = this.timeGen();
                if (timestamp < this.lastTimestamp) {
                    throw new UtilException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
                }
            } catch (Exception e) {
                throw new UtilException(e);
            }
        }

        if (this.lastTimestamp == timestamp) {
            this.sequenceNum = this.sequenceNum + 1L & 4095L;
            if (this.sequenceNum == 0L) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequenceNum = ThreadLocalRandom.current().nextLong(1L, 101L);
        }

        this.lastTimestamp = timestamp;
        return timestamp - 1288834974657L << 22 | this.datacenterId << 17 | this.workerId << 12 | this.sequenceNum;
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = this.timeGen(); timestamp <= lastTimestamp; timestamp = this.timeGen()) {
        }

        return timestamp;
    }

    protected long timeGen() {
        return SystemClock.now();
    }
}

