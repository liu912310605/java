package com.liu.designpattern.templatemethodpattern;

/**
 * @author liuzhuangyuan
 * @description
 * @date 2020/8/20 下午7:04
 */
public class TemplateMethodPattern {


    public static void main(String[] args) {

        AbstractClass tm = new ConcreteClass();
        tm.TemplateMethod();


    }

}

abstract class AbstractClass {

    //模版方法
    public void TemplateMethod() {
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }

    //具体方法
    public void SpecificMethod() {
        System.out.println("抽象类中的具体方法被调用...");
    }

    //抽象方法1
    public abstract void abstractMethod1();

    //抽象方法2
    public abstract void abstractMethod2();


}

//具体子类
class ConcreteClass extends AbstractClass {

    @Override
    public void abstractMethod1() {
        System.out.println("抽象方法1的实现被调用...");
    }

    @Override
    public void abstractMethod2() {
        System.out.println("抽象方法2的实现被调用...");
    }
}
