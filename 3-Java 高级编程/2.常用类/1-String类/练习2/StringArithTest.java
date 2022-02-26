package com.wndexx.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wndexx
 * @create 2022-02-24 12:44
 */
public class StringArithTest {
    /*
        1. 模拟一个trim方法，去除字符串两端的空格
    */
    @Test
    public void test1() {

        String str1 = "   hello world  ";
        String str2 = simuTrim(str1);
        System.out.println(str2);
    }

    public String simuTrim(String str) {

        int start = 0;
        int end = str.length() - 1;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ')
                continue;
            start = i;
            break;
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == ' ')
                continue;
            end = i;
            break;
        }

        return str.substring(start, end + 1);
    }

    /*
        2. 将一个字符串进行反转。将字符串中指定部分进行反转。比如 "abcdefg" 反转为 "abfedcg"
    */
    @Test
    public void test2() {

        String str1 = "abcdefg";
        String str2 = reverseStr(str1, 2, 6);
        System.out.println(str2);
    }

    public String reverseStr(String str, int index1, int index2) {
        if (index1 >= index2 || index1 < 0 || index2 < 0 || index1 >= str.length() || index2 >= str.length())
            return null;


        char[] arr = str.toCharArray();
        char[] newArr = new char[arr.length];

        for (int i = 0; i < index1; i++) {
            newArr[i] = arr[i];
        }

        for (int i = index2; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        int index = index2;
        for (int i = index1; i < index2; i++) {
            newArr[i] = arr[--index];
        }

        return new String(newArr);
    }

    /*
        3. 获取一个字符串在另一个字符串中出现的次数。比如：获取 "ab" 在 "abkkcadkabkebfkabkskab" 中出现的次数
    */
    @Test
    public void test3() {

        String str1 = "abkkcadkabkebfkabkskab";
        String str2 = "ab";

        int count = getCount(str1, str2);
        System.out.println(count);
    }

    public int getCount(String str1, String str2) {
        if (str2.length() > str1.length())
            return 0;

        int index = 0;
        int count = 0;

        l:
        for (; ; ) {
            if (index > str1.length() - 1)
                break;
            if (str1.charAt(index) != str2.charAt(0)) {
                index++;
                continue;
            }
            for (int i = 1; i < str2.length(); i++) {
                if (str1.charAt(index + i) != str2.charAt(i)) {
                    index++;
                    continue l;
                }
            }
            count++;
            index += str2.length();
        }
        return count;
    }

    /*
        4. 获取两个字符串中最大相同子串。比如：str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"
           提示：将短的那个串进行长度依次递减的子串与较长的串比较。
    */
    @Test
    public void test4() {

        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";

        String subString = getSubString(str1, str2);
        System.out.println(subString);
    }

    public String getSubString(String str1, String str2) {

        String s1 = str1.length() >= str2.length() ? str2 : str1; // short
        String s2 = str1.length() < str2.length() ? str2 : str1; // long

        String s3 = "";
        for (int i = 0; i < s1.length(); i++) {
            for (int j = s1.length() - 1; j > i; j--) {
                String s = s1.substring(i, j);
                if (!s2.contains(s)) {
                    continue;
                }
                if (s3.length() < s.length())
                    s3 = s;
                break;
            }
        }
        return s3;
    }

    /*
        5. 对字符串中字符进行自然顺序排序。

        提示：
            1）字符串变成字符数组。
            2）对数组排序，选择，冒泡，Arrays.sort();
            3）将排序后的数组变成字符串
    */
    @Test
    public void test5() {

        String str = "hello";
        String str2 = sort(str);
        System.out.println(str2);
    }

    public String sort(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}



























