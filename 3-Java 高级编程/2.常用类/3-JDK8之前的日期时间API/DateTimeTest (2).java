package com.wndexx.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author wndexx
 * @create 2022-02-26 8:53
 */
/*
    jdk 8 之前的日期时间的 API 测试

    1. System.currentTimeMillis()

    2. java.util.Date 和子类 java.sql.Date

    3. SimpleDateFormat

    4. Calendar

        注意：获取月份时：一月是 0，二月是 1，以此类推，十二月是 11

             获取星期时：周日是 1，周一是 2，...，周六是 7
*/

public class DateTimeTest {

    /*
        SimpleDateFormat 的使用：SimpleDateFormat 对日期 Date 类的格式化和解析

        1. 两个操作：

            (1) 格式化： 日期 ---> 字符串

            (2) 解析：格式化的逆过程，字符串 ---> 日期

        2. SimpleDateFormat 的实例化

    */
    @Test
    public void testSimpleDateFormat() throws ParseException {

        // 1. SimpleDateFormat 的实例化：使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        // (1) 格式化： 日期 ---> 字符串
        Date date = new Date();
        System.out.println(date); // Sat Feb 26 09:00:29 CST 2022

        String format = sdf.format(date);
        System.out.println(format); // 22-2-26 上午9:00

        // (2) 解析：格式化的逆过程，字符串 ---> 日期
        // String str = "2022-1-1";
        String str = "22-2-26 上午9:00";
        Date date1 = sdf.parse(str);
        // System.out.println(date1); // ParseException
        System.out.println(str); // Sat Feb 26 09:00:00 CST 2022

        // *********************** 按照指定的方式格式化和解析：调用带参的构造器 *****************************

        // SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String format1 = sdf1.format(date);
        System.out.println(format1); // 2022-02-26 09:20:36
        // 解析：要求字符串必须符合 SimpleDateFormat 识别的格式(通过构造器参数实现)，否则抛 ParseException 异常
        Date date2 = sdf1.parse("2023-02-26 09:20:36");
        System.out.println(date2); // Sun Feb 26 09:20:36 CST 2023
    }

    /*
        练习一：字符串 "2020-09-08" 转换为 java.sql.Date
    */
    @Test
    public void testExer() throws ParseException {

        String birth = "2020-09-08";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(birth);
        System.out.println(date); // Tue Sep 08 00:00:00 CST 2020

        java.sql.Date date1 = new java.sql.Date(date.getTime());
        System.out.println(date1); // 2020-09-08
    }

    /*
        Calendar 日历类(抽象类)的使用
    */
    @Test
    public void testCalendar() {

        // 1. 实例化
        // 方式一：创建其子类（GregorianCalendar）的对象
        // 方式二：调用其静态方法 getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); // class java.util.GregorianCalendar

        // 2. 常用方法
        // (1) get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 26

        System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); // 57

        // (2) set()
        // calendar 可变的
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 22

        // (3) add()
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 25

        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 22

        // (4) getTime()：日历类 ---> Date
        Date date = calendar.getTime();
        System.out.println(date); // Tue Feb 22 14:20:04 CST 2022

        // (5) setTime()：Date ---> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days); // 26
    }
}
