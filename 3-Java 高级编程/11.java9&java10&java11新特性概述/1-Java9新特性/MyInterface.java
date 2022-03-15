package com.wndexx.java;

/**
 * @author wndexx
 * @create 2022-03-14 20:36
 */
public interface MyInterface {

    // 如下的三个方法的权限修饰符都是 public

    void methodAbstract();

    static void methodStatic() {
        System.out.println("我是接口中的静态方法");
    }

    default void methodDefault() {
        System.out.println("我是接口中的默认方法");
        methodPrivate();
    }

    // jdk 9 中允许接口中定义私有的方法
    private void methodPrivate(){
        System.out.println("我是接口中的私有方法");
    }
}
