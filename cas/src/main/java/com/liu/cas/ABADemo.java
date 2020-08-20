package com.liu.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author liuzhuangyuan
 * @description
 * @date 2020/8/9 下午5:34
 */
public class ABADemo {

//    static AtomicReference<Integer> atomicReference = new AtomicReference<Integer>(100);
//
//    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
//
//    public static void main(String[] args) {
//
//        new Thread(() -> {
//            atomicReference.compareAndSet(100, 101);
//            atomicReference.compareAndSet(101, 100);
//        }, "t1").start();
//
//        new Thread(() -> {
//            try {
//                //暂停1秒，保证t1的ABA操作完成
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(atomicReference.compareAndSet(100, 2019));
//
//        }, "t2").start();
//
//        System.out.println("以下是ABA问题结局方案");
//
//
//        new Thread(() -> {
//            int stamp = atomicStampedReference.getStamp();
//            System.out.println(Thread.currentThread().getName() + "\t第一次版本号：" + stamp);
//            try {
//                //暂停1秒
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
//            System.out.println(Thread.currentThread().getName() + "\t第二次版本号：" + atomicStampedReference.getStamp());
//            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
//            System.out.println(Thread.currentThread().getName() + "\t第三次版本号：" + atomicStampedReference.getStamp());
//        }, "t3").start();
//
//
//        new Thread(() -> {
//            int stamp = atomicStampedReference.getStamp();
//            System.out.println(Thread.currentThread().getName() + "\t第一次版本号：" + stamp);
//            try {
//                //暂停3秒,保证t3完成ABA操作
//                TimeUnit.SECONDS.sleep(4);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println(atomicStampedReference.compareAndSet(100, 2019, stamp, stamp + 1));
//        }, "t4").start();



        private static AtomicReference<Integer> atomicReference=new AtomicReference<>(100);
        private static AtomicStampedReference<Integer> stampedReference=new AtomicStampedReference<>(100,1);
        public static void main(String[] args) {
            System.out.println("===以下是ABA问题的产生===");
            new Thread(()->{
                atomicReference.compareAndSet(100,101);
                atomicReference.compareAndSet(101,100);
            },"t1").start();

            new Thread(()->{
                //先暂停1秒 保证完成ABA
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+atomicReference.get());
            },"t2").start();
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println("===以下是ABA问题的解决===");

            new Thread(()->{
                int stamp = stampedReference.getStamp();
                System.out.println(Thread.currentThread().getName()+"\t 第1次版本号"+stamp+"\t值是"+stampedReference.getReference());
                //暂停1秒钟t3线程
                try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

                stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+"\t 第2次版本号"+stampedReference.getStamp()+"\t值是"+stampedReference.getReference());
                stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+"\t 第3次版本号"+stampedReference.getStamp()+"\t值是"+stampedReference.getReference());
            },"t3").start();

            new Thread(()->{
                int stamp = stampedReference.getStamp();
                System.out.println(Thread.currentThread().getName()+"\t 第1次版本号"+stamp+"\t值是"+stampedReference.getReference());
                //保证线程3完成1次ABA
                try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                boolean result = stampedReference.compareAndSet(100, 2019, stamp, stamp + 1);
                System.out.println(Thread.currentThread().getName()+"\t 修改成功否"+result+"\t最新版本号"+stampedReference.getStamp());
                System.out.println("最新的值\t"+stampedReference.getReference());
            },"t4").start();

    }
}
