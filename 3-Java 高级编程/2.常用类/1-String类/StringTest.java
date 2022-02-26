package com.wndexx.java;

import org.junit.Test;

/**
 * @author wndexx
 * @create 2022-02-23 15:10
 */

public class StringTest {
    /*
        String 的使用

        String:字符串，使用一对 "" 来表示

        1. String 声明为 final 的，不可被继承

        2. String 实现了 Serializable接口：表示字符串是支持序列化的

                实现了 Comparable接口：表示 String 可以比较大小

        3. String 内部定义了 final char[] value 用于存储字符串数据

        4. String：代表不可变的字符序列。简称：不可变性

        体现：- 当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用原有的 value 进行赋值

             - 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的 value 进行赋值

             - 当调用 String 的 replace() 方法修改内部指定的字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的 value 进行赋值

        5. 通过字面量的方式（区别与 new ）给一个字符串赋值，此时的字符串值声明在字符串常量池中

        6. 字符串常量池中是不会存储相同内容(使用 String 类的 equals()比较，返回true)的字符串的
    */
    @Test
    public void test1() {

        String s1 = "abc"; // 字面量的定义方式
        String s2 = "abc";
        // s1 = "hello";

        System.out.println(s1 == s2); // 比较 s1 和 s2 的地址值 ：true

        System.out.println(s1); // hello
        System.out.println(s2); // abc


        System.out.println("**************************");

        String s3 = "abc";
        s3 += "def";
        System.out.println(s3); // abcdef
        System.out.println(s2); // abc

        System.out.println("**************************");

        String s4 = "abc";
        String s5 = s4.replace('a', 'm');

        System.out.println(s4); // abc
        System.out.println(s5); //mbc
    }

    /*
        String 的实例化方式：

        方式一：通过字面量定义的方式

        方式二：通过 new + 构造器的方式

        面试题：String s = new String("abc"); 方式创建对象，在内存中创建了几个对象？

               两个：一个是堆空间中 new 结构，另一个是 char[] 对应的常量池中的数据："abc"

    */
    @Test
    public void test2() {

        // 通过字面量定义的方式：此时的 s1 和 s2 的数据 javaEE 声明在方法区中的字符串常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";

        // 通过 new + 构造器的方式：此时的 s3 和 s4 保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s4); // false
        System.out.println(s3 == s4); // false

        System.out.println("**************************");

        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name)); // true
        System.out.println(p1.name == p2.name); // true

        p1.name = "Jerry";
        System.out.println(p2.name); // Tom
    }

    /*
        结论：

        1. 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。只要有一个是变量，结果就在堆中

        2. 如果拼接的结果调用 intern() 方法，返回值就在常量池中

    */
    @Test
    public void test3() {

        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4); // true
        System.out.println(s3 == s5); // false
        System.out.println(s3 == s6); // false
        System.out.println(s3 == s7); // false
        System.out.println(s5 == s6); // false
        System.out.println(s5 == s7); // false
        System.out.println(s6 == s7); // false

        String s8 = s5.intern(); // 返回得到的 s8 是使用的常量池中已经存在的 "javaEEhadoop"
        System.out.println(s3 == s8); // true
    }

    @Test
    public void test4() {

        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";

        System.out.println(s1 == s3); // false

        final String s4 = "javaEE"; // s4：常量
        String s5 = s4 + "hadoop";

        System.out.println(s1 == s5); // true

        String s6 = s4.concat("hadoop");
        System.out.println(s4 == s6); // false
    }
	
	/*
		JVM 中字符串常量池存放位置说明：
		
			jdk 1.6(jdk 6.0，java 6.0) ：字符串常量池存储在方法区（永久区）
			
			jdk 1.7：字符串常量池存储在堆空间
			
			jdk 1.8：字符串常量池存储在方法区（元空间）
	*/
}
