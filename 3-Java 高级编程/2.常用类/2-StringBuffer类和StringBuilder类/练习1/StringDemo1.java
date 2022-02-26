package com.wndexx.exer;

import org.junit.Test;

/**
 * @author wndexx
 * @create 2022-02-25 14:33
 */
public class StringDemo1 {
    /*
        获取一个字符串在另一个字符串中出现的次数。比如：获取 "ab" 在 "abkkcadkabkebfkabkskab" 中出现的次数
    */

    /**
     * 获取 subStr 在 mainStr 中出现的次数
     *
     * @param mainStr 主字符串
     * @param subStr
     * @return 次数
     */
    public int getCount(String mainStr, String subStr) {

        if (mainStr.length() < subStr.length())
            return 0;

        int count = 0;
        int index = 0;

        // 方式一：
        /*while ((index = mainStr.indexOf(subStr)) != -1) {
            count++;
            mainStr = mainStr.substring(index + subStr.length());
        }*/

        // 方式二：
        for (; ; ) {
            index = mainStr.indexOf(subStr, index);
            if (index == -1)
                break;
            count++;
            index += subStr.length();
        }

        return count;
    }

    @Test
    public void testGetCount() {

        String str1 = "abkkcadkabkebfkabkskab";
        String str2 = "ab";

        int count = getCount(str1, str2);

        System.out.println(count); // 4
    }

}
