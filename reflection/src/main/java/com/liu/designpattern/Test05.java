package com.liu.designpattern;

/**
 * @author liuzhuangyuan
 * @description
 * @date 2020/6/27 下午8:32
 */
public class Test05 {

    //1、加载到内存，会产生一个类对应Class对象
    //2、链接结束后 m=0
    //3、初始化，静态代码块
//    static {
//        System.out.println("A类静态代码块初始化");
//        m = 300;
//    }

    static int m = 100;

    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);
    }
}


class A {
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }
    static int m = 100;


    public A () {
        System.out.println("A类的无参构造初始化");
    }
}
