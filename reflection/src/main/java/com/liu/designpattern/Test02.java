package com.liu.designpattern;

/**
 * @author liuzhuangyuan
 * @description
 * @date 2020/6/27 上午11:13
 */
public class Test02 {

    public static void main(String[] args) throws Exception {
        //通过反射获取类的class对象
        Class classUser01 = Class.forName("com.liu.designpattern.User");
        Class classUser02 = Class.forName("com.liu.designpattern.User");
        Class classUser03 = Class.forName("com.liu.designpattern.User");

        System.out.println(classUser01.hashCode());
        System.out.println(classUser02.hashCode());
        System.out.println(classUser03.hashCode());

    }



}


