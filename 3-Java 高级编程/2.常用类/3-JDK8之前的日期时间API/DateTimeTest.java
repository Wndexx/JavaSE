package com.wndexx.java;

import org.junit.Test;

import java.util.Date;

/**
 * @author wndexx
 * @create 2022-02-25 10:42
 */
/*
    JDK 8 之前日期和时间的 API 测试
*/
public class DateTimeTest {

    /*
        1. System 类中的 currentTimeMills()：返回当前时间与 1970 年 1 月 1 日 0 时 0 分 0 秒之间以毫秒为单位的时间差，称为时间戳
    */
    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        System.out.println(time); // 1645757088079
    }

    /*
        2.  java.util.Date 类

                java.sql.Date 类

            (1) 两个构造器的使用

                    - 构造器一：Date()：创建一个对应当前时间的 Date 对象

                    - 构造器二：创建指定毫秒数的 Date 对象

            (2) 两个方法的使用

                    - toString()：显示当前的年、月、日、时、分、秒

                    - getTime()：获取当前 Date 对象对应的毫秒数(时间戳)

        3. java.sql.Date 对应着数据库中的日期类型的变量

            (1) 如何实例化：new java.sql.Date(long date)

            (2) sql.Date  ---> util.Date 直接赋值，多态

                如何将 java.util.Date 对象转换为 java.sql.Date 对象
    */
    @Test
    public void test2() {
        // 构造器一：Date()：创建一个对应当前时间的 Date 对象
        Date date1 = new Date();
        System.out.println(date1.toString()); // Fri Feb 25 10:51:09 CST 2022
        System.out.println(date1.getTime()); // 1645757541280

        // 构造器二：创建指定毫秒数的 Date 对象
        Date date2 = new Date(1645757541280L);
        System.out.println(date2); // Fri Feb 25 10:52:21 CST 2022

        // 创建 java.sql.Date 对象
        java.sql.Date date3 = new java.sql.Date(32323232232L);
        System.out.println(date3); // 1971-01-10

        // 如何将 java.util.Date 对象转换为 java.sql.Date 对象
        // 情况一：
        // Date date4 = new java.sql.Date(2323333333333L);
        // java.sql.Date date5 = (java.sql.Date) date4;
        // 情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }
}
