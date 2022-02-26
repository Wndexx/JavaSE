package com.wndexx.exer;

import org.junit.Test;

/**
 * @author wndexx
 * @create 2022-02-25 13:41
 */
public class StringDemo {

    /*
        将一个字符串进行反转。将字符串中指定部分进行反转。比如 "abcdefg" 反转为 "abfedcg"

        方式一：先转换为 char[]
    */
    public String reverse(String str, int startIndex, int endIndex) {

        if (str == null || str.trim().length() == 0)
            return str;

        char[] arr = str.toCharArray();

        for (int i = startIndex, j = endIndex; i < j; i++, j--) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        return new String(arr);
    }

    /*
        方式二：
    */
    public String reverse1(String str, int startIndex, int endIndex) {

        if (str == null || str.trim().length() == 0)
            return str;

        StringBuilder s1 = new StringBuilder(str).delete(startIndex, endIndex + 1);
        StringBuilder s2 = new StringBuilder(str.substring(startIndex, endIndex + 1)).reverse();

        return s1.insert(startIndex, s2).toString();
    }

    /*
        方式三：使用 String 的拼接
    */
    public String reverse2(String str, int startIndex, int endIndex) {

        if (str == null || str.trim().length() == 0)
            return str;

        String reverseStr = str.substring(0, startIndex);
        for (int i = endIndex; i >= startIndex; i--) {
            reverseStr += str.charAt(i);
        }
        reverseStr += str.substring(endIndex + 1, str.length());

        return reverseStr;
    }

    /*
        方式三：使用 StringBuffer / StringBuilder 替换 String
    */
    public String reverse3(String str, int startIndex, int endIndex) {

        if (str == null || str.trim().length() == 0)
            return str;

        StringBuilder reverseStr = new StringBuilder(str.substring(0, startIndex));
        /*for (int i = endIndex; i >= startIndex; i--) {
            reverseStr .append(str.charAt(i)) ;
        }*/
        reverseStr.append(new StringBuilder(str.substring(startIndex, endIndex)).reverse());
        reverseStr.append(str.substring(endIndex + 1, str.length()));

        return new String(reverseStr);
    }

    public String reverse4(String str, int startIndex, int endIndex) {

        if (str == null || str.trim().length() == 0)
            return str;

        StringBuilder builder = new StringBuilder(str.length());

        // 第 1 部分
        builder.append(str.substring(0, startIndex));
        // 第 2 部分
        for (int i = endIndex; i >= startIndex; i--) {
            builder.append(str.charAt(i));
        }
        // 第 3 部分
        builder.append(str.substring(endIndex + 1, str.length()));

        return new String(builder);
    }

    @Test
    public void testReverse() {

        String str = "abcdefg";
        String reverse = reverse(str, 2, 5);
        System.out.println(reverse);

        String reverse1 = reverse(str, 2, 5);
        System.out.println(reverse1);

        String reverse2 = reverse(str, 2, 5);
        System.out.println(reverse2);

        String reverse3 = reverse(str, 2, 5);
        System.out.println(reverse3);

        String reverse4 = reverse(str, 2, 5);
        System.out.println(reverse4);
    }
}
