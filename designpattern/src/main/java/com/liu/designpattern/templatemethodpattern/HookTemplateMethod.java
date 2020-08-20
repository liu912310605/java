package com.liu.designpattern.templatemethodpattern;

/**
 * @author liuzhuangyuan
 * @description
 * @date 2020/8/20 下午8:10
 */
public class HookTemplateMethod {

    public static void main(String[] args) {
        HookAbstractClass tm=new HookConcreteClass();
        tm.TemplateMethod();
    }


}

abstract class HookAbstractClass {

    //模版方法
    public void TemplateMethod() {
        abstractMethod1();
        HookMethod1();
        if (HookMethod2()) {
            SpecificMethod();
        }
        abstractMethod2();
    }


    public void SpecificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }

    //钩子方法1
    public void HookMethod1() {}

    //钩子方法2
    public boolean HookMethod2() {
        return true;
    }

    //抽象方法1
    public abstract void abstractMethod1();

    //抽象方法2
    public abstract void abstractMethod2();


}

//含钩子方法的具体类
class HookConcreteClass extends HookAbstractClass {

    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");

    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }

    public void HookMethod1() {
        System.out.println("钩子方法1被重写...");
    }

    public boolean HookMethod2() {
        return false;
    }

}
