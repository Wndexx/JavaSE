package com.wndexx.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wndexx
 * @create 2022-02-25 15:24
 */
public class StringDemo2 {
    /*
        获取两个字符串中最大相同子串。比如：str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"
        提示：将短的那个串进行长度依次递减的子串与较长的串比较。

        前提：两个字符串中只有一个最大相同子串
    */
    public String getMaxSameString(String str1, String str2) {

        if (str1 == null || str2 == null)
            return null;

        String minStr = str1.length() >= str2.length() ? str2 : str1; // short
        String maxStr = str1.length() < str2.length() ? str2 : str1; // long

        int len = minStr.length();

        for (int i = 0; i < len; i++) {
            for (int x = 0, y = len - i; y <= len; x++, y++) {
                String subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr))
                    return subStr;
            }
        }

        /*int startIndex = 0;
        int endIndex = minStr.length();

        for (; endIndex < 0; ) {
            for (int x = 0, y = endIndex; x <= startIndex; x++, y++) {
                subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr))
                    return subStr;
            }
            startIndex++;
            endIndex--;
        }
        */
        return null;
    }

    public String[] getMaxSameStringArray(String str1, String str2) {

        if (str1 == null || str2 == null)
            return null;

        String minStr = str1.length() >= str2.length() ? str2 : str1; // short
        String maxStr = str1.length() < str2.length() ? str2 : str1; // long

        String[] strs = new String[minStr.length()];
        int count = 0;
        int len = minStr.length();

        for (int i = 0; i < len; i++) {
            for (int x = 0, y = len - i; y <= len; x++, y++) {
                String subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr)) {
                    strs[count++] = subStr;
                }
            }
            if (count > 0)
                break;
        }

        if (count == 0)
            return null;
        String[] maxSameStrs = new String[count];
        for (int i = 0; i < count; i++) {
            maxSameStrs[i] = strs[i];
        }

        return maxSameStrs;
    }

    public String[] getMaxSameStringArray1(String str1, String str2) {

        if (str1 == null || str2 == null)
            return null;

        StringBuilder sb = new StringBuilder();

        String minStr = str1.length() >= str2.length() ? str2 : str1; // short
        String maxStr = str1.length() < str2.length() ? str2 : str1; // long

        int len = minStr.length();

        for (int i = 0; i < len; i++) {
            for (int x = 0, y = len - i; y <= len; x++, y++) {
                String subStr = minStr.substring(x, y);
                if (maxStr.contains(subStr)) {
                    sb.append(subStr + ",");
                }
            }
            if (sb.length() > 0)
                break;
        }

        String[] split = sb.toString().replaceAll(",$", "").split(",");

        return split;
    }

    @Test
    public void testGetMaxSameString() {

        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";

        String subStr = getMaxSameString(str1, str2);
        System.out.println(subStr); // hello

        String str3 = "abcwerthello1yuiodefabcdef";
        String str4 = "cvhello1bnmabcdef";
        String[] maxSameStringArray = getMaxSameStringArray(str3, str4);
        System.out.println(Arrays.toString(maxSameStringArray));

        String str5 = "abcwerthello1yuiodefabcdef";
        String str6 = "cvhello1bnmabcdef";
        String[] arr = getMaxSameStringArray1(str5, str6);
        System.out.println(Arrays.toString(arr));

    }
}
