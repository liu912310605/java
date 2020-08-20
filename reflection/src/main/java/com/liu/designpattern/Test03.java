package com.liu.designpattern;

/**
 * @author liuzhuangyuan
 * @description Class类的创建方式有哪些
 * @date 2020/6/27 上午11:54
 */
public class Test03 {

    public static void main(String[] args) throws Exception {
        Person person = new Student();
        System.out.println("这个人是：" + person.name);

        //方式一：通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二：forname获得
        Class c2 = Class.forName("com.liu.designpattern.Student");
        System.out.println(c2.hashCode());

        //方式三：通过类名 .class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        //获得父类类型
        c1.getSuperclass();
    }


}
