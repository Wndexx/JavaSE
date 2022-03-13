package com.wndexx.java1;

import org.junit.Test;

import java.util.Comparator;

/**
 * @author wndexx
 * @create 2022-03-12 12:47
 */
/*
    Lambda 表达式的使用举例
*/
public class LambdaTest {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱吃小笼包");
            }
        };
        r1.run();

        System.out.println("*************************");

        Runnable r2 = () -> System.out.println("我爱吃油条");
        r2.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1); // -1

        System.out.println("******************************");

        // Lambda 表达式的写法
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(32, 21);
        System.out.println(compare2); // -1

        System.out.println("******************************");

        // 方法引用的写法
        Comparator<Integer> com3 = Integer::compare;
        int compare3 = com3.compare(32, 21);
        System.out.println(compare3); // -1
    }
}
