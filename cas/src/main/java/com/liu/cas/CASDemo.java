package com.liu.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liuzhuangyuan
 * @description
 * @date 2020/8/9 下午1:43
 */
public class CASDemo {

    public static void main(String[] args) {
        //主内存的值是5
        AtomicInteger atomicInteger = new AtomicInteger(5);
        //现在期望值是5说明没人动过，更新为10
        System.out.println("更新前："+ atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 10));
        System.out.println("更新后："+ atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 20));
        System.out.println("又更新后："+ atomicInteger.get());
        atomicInteger.getAndIncrement();

    }


}
