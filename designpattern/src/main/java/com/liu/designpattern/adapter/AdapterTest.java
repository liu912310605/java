package com.liu.designpattern.adapter;

import com.sun.istack.internal.Nullable;

import java.io.Serializable;

/**
 * @author liuzhuangyuan
 * @description
 * @date 2020/8/19 下午2:51
 */
public class AdapterTest {

    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target adapterTarget = new Adapter();
        adapterTarget.request();
    }

}

/**
 * 被适配的类
 */
class Adaptee {

    public void adapteeRequest() {
        System.out.println("被适配的方法");
    }

}

/**
 * 目标接口
 */
interface Target {
    void request();

}

class ConcreteTarget implements Target {

    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}

/**
 * 适配者
 */
class Adapter extends Adaptee implements Target {

    @Override
    public void request() {
        //一些自定义操作
        super.adapteeRequest();
        //一些自定义操作
    }
}





