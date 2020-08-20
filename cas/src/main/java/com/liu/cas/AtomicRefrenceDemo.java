package com.liu.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author liuzhuangyuan
 * @description
 * @date 2020/8/9 下午5:25
 */
public class AtomicRefrenceDemo {

    public static void main(String[] args) {
        User user1 = new User("01", 1);
        User user2 = new User("02", 2);

        AtomicReference<User> atomicReference = new AtomicReference<User>();
        atomicReference.set(user1);
        System.out.println("修改前：" + atomicReference.get().userName);
        atomicReference.compareAndSet(user1, user2);
        System.out.println("修改后：" + atomicReference.get().userName);
    }



}


class User {
    String userName;
    int age;

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}
