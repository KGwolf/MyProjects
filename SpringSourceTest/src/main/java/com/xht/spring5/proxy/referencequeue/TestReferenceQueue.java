package com.xht.spring5.proxy.referencequeue;

import com.xht.spring5.proxy.jdk.DictChooseServiceImp;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @ClassName: TestReferenceQueue
 * @Description: TODO
 * @Author: xiahaitao
 * @Date: 2023/4/4 16:30
 * @Version: V1.0
 */
public class TestReferenceQueue {

    public static void main(String[] args) {
        DictChooseServiceImp i1 = new DictChooseServiceImp();
        ReferenceQueue<DictChooseServiceImp> reQueue = new ReferenceQueue<>();
        WeakReference<DictChooseServiceImp> wR = new WeakReference<>(i1,reQueue);
        i1 = null;
        System.gc();
        Reference<? extends DictChooseServiceImp> ref = reQueue.poll();
        int a = 1/1;
    }
}
