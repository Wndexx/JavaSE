package com.wndexx.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author wndexx
 * @create 2022-02-24 11:07
 */
/*
    涉及到 String 与其他结构之间的转换
*/
public class StringTest1 {

    /*
        复习：

            String 与基本数据类型、包装类之间的转换

            String ---> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)

            基本数据类型、包装类 ---> String：调用 String 重载的 valueOf(xxx)
    */
    @Test
    public void test1() {

        String str1 = "123";
        int num = Integer.parseInt(str1); // 123
        System.out.println(num);

        String str2 = String.valueOf(num); // "123"
        System.out.println(str2);

        String str3 = num + "";

        System.out.println(str1 == str3); // false
    }

    /*
        String 与 char[] 之间的转换

        String ---> char[]：调用 String 的 toCharArray()

        char[] ---> String：调用 String 的构造器
    */
    @Test
    public void test2() {

        String str1 = "abc123";
        char[] chars = str1.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);

        // 题目：abc123 ---> a21cb3
        char[] arr1 = str1.toCharArray();
        char[] arr2 = new char[arr1.length];
        arr2[0] = arr1[0];
        arr2[arr2.length - 1] = arr1[arr1.length - 1];
        for (int i = 1; i < arr2.length - 1; i++) {
            arr2[i] = arr1[arr1.length - 1 - i];
        }
        String str3 = new String(arr2);
    }


    /*
        String 与 byte[] 之间的转换

        编码： String ---> byte[] ：调用 String 的 getBytes()

        解码：byte[] ---> String : 调用 String  的构造器


        编码：字符串 ---> 字节 (看得懂 ---> 看不懂的二进制数据)

        解码：编码的逆过程，字节 ---> 字符串 (看不懂的二进制数据 ---> 看得懂)

        在解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
    */
    @Test
    public void test3() throws UnsupportedEncodingException {

        String str1 = "abc123";
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes)); // [97, 98, 99, 49, 50, 51]

        str1 = "abc123中国"; // 汉字 utf-8 三个字节
        byte[] bytes1 = str1.getBytes(); // 使用默认的字符集进行编码
        System.out.println(Arrays.toString(bytes1)); // [97, 98, 99, 49, 50, 51, -28, -72, -83, -27, -101, -67]

        byte[] gbks = str1.getBytes("gbk"); // 使用 gbk 字符集进行编码
        System.out.println(Arrays.toString(gbks)); // [97, 98, 99, 49, 50, 51, -42, -48, -71, -6]

        System.out.println("**************");

        String str2 = new String(bytes1); // 使用默认的字符集进行解码
        System.out.println(str2); // abc123中国

        String str3 = new String(gbks);
        System.out.println(str3); // abc123�й� 出现乱码，原因：编码集和解码集不一致

        String str4 = new String(gbks, "gbk");
        System.out.println(str4); // abc123中国 没有出现乱码，原因：编码集和解码集一致

    }
}
