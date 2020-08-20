package com.liu.designpattern;

/**
 * @author liuzhuangyuan
 * @description
 * @date 2020/6/27 下午9:04
 */
public class Test06 {
    static {
        System.out.println("Main类被加载");
    }
    public static void main(String[] args) throws Exception {
        //1、主动调用
        //Son son = new Son();
        //2、反射
        //Class.forName("com.liu.reflection.Son");
        //不会产生类的加载
        //System.out.println(Son.b);
        //只是开辟一块空间
        //Son[] array = new Son[5];
        System.out.println(Son.M);
    }
}
class Father {
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}
class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static  int m = 100;
    static final int M = 100;
}
