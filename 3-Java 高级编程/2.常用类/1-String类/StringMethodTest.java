package com.wndexx.java;

import org.junit.Test;

import java.util.Locale;

/**
 * @author wndexx
 * @create 2022-02-23 18:42
 */

public class StringMethodTest {

    /*
        int length()                                    返回字符串的长度        return value.length

        char charAt(int index)                          返回某索引处的字符      return value[index]

        boolean isEmpty()                               判断是否是空字符串      return value.length == 0

        String toLowerCase()                            使用默认语言环境，将 String 中的所有字符转换为小写

        String toUpperCase()                            使用默认语言环境，将 String 中的所有字符转换为大写

        String trim()                                   返回字符串的副本，忽略前导空白和尾部空白

        boolean equals(Object obj)                      比较字符串的内容是否相同

        boolean equalsIgnoreCase(String anotherString)  与 equals 方法类似，忽略大小写

        String concat(String str)                       将指定字符串连接到此字符串的结尾。等价于用 "+"

        int compareTo(String anotherString)             比较两个字符串的大小

        String substring(int beginIndex)                返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串

        String substring(int beginIndex, int endIndex)  返回一个新字符串，它是此字符串从 beginIndex 开始截取到 endIndex (不包含)的一个子字符串
    */
    @Test
    public void test1() {

        // 1.  int length()
        String s1 = "helloworld";
        System.out.println(s1.length()); // 10

        // 2. char charAt(int index)
        System.out.println(s1.charAt(0)); // h
        System.out.println(s1.charAt(9)); // d
        // System.out.println(s1.charAt(10)); // StringIndexOutOfBoundsException

        // 3. boolean isEmpty()
        s1 = "";
        System.out.println(s1.isEmpty()); // true

        // 4. String toLowerCase()
        s1 = "HelloWorld";
        String s2 = s1.toLowerCase();
        System.out.println(s1); // HelloWorld s1不可变，仍然为原来的字符串
        System.out.println(s2); // helloworld 改成小写以后的字符串

        // 5. String toUpperCase()
        System.out.println(s1.toUpperCase()); // HELLOWORLD

        // 6. String trim()
        String s3 = "     he          l lo   world            ";
        String s4 = s3.trim();
        System.out.println("----" + s3 + "----"); // ----     he          l lo   world            ----
        System.out.println("----" + s4 + "----"); // ----he          l lo   world----

        // 7. boolean equals(Object obj)
        System.out.println(s1.equals("HelloWorld")); // true

        // 8. boolean equalsIgnoreCase(String anotherString)
        String s5 = "HelloWorld";
        String s6 = "helloworld";
        System.out.println(s5.equals(s6)); // false
        System.out.println(s5.equalsIgnoreCase(s6)); // true

        // 9. String concat(String str)
        String s7 = "abc";
        String s8 = s7.concat("def");
        System.out.println(s8); // abcdef

        // 10. int compareTo(String anotherString)
        String s9 = "abc";
        String s10 = new String("abe");
        System.out.println(s9.compareTo(s10)); // -2 涉及到字符串排序

        // 11. String substring(int beginIndex)
        String s11 = "钟山风雨起苍黄";
        String s12 = s11.substring(5);
        System.out.println(s11); // 钟山风雨起苍黄
        System.out.println(s12); // 苍黄

        // 12. String substring(int beginIndex, int endIndex)
        String s13 = s11.substring(2, 4);
        System.out.println(s13); // 风雨
    }

    /*
        boolean endsWith(String suffix)                 测试此字符串是否以指定的后缀结束

        boolean startsWith(String prefix)               测试此字符串是否以指定的前缀开始

        boolean startsWith(String prefix, int toffset)  测试此字符串从指定索引开始的子字符串是否以指定前缀开始

        boolean contains(CharSequence s)                当且仅当此字符串包含指定的 char 值序列时，返回 true

        int indexOf(String str)                         返回指定字符串在此字符串中第一次出现处的索引

        int indexOf(String str, int fromIndex)          返回指定字符串在此字符串中第一次出现处的索引，从指定的索引开始

        int lastIndexOf(String str)                     返回指定字符串在此字符串中最后一次出现出的索引

        int lastIndexOf(String str, int fromIndex)      返回指定字符串在此字符串中最后一次出现出的索引，从指定的索引开始反向搜索

        注：indexOf 和 lastIndexOf 相同时，表明所要查找的子字符串要么只有一个，要么不存在
    */
    @Test
    public void test2() {

        // 1. boolean endsWith(String suffix)
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1); // true

        // 2. boolean startsWith(String prefix)
        boolean b2 = str1.startsWith("He");
        System.out.println(b2); // false

        // 3. boolean startsWith(String prefix, int toffset)
        boolean b3 = str1.startsWith("ll", 2);
        System.out.println(b3); // true

        // 4. boolean contains(CharSequence s)
        String str2 = "wo";
        System.out.println(str1.contains(str2)); // true

        // 5. int indexOf(String str)
        System.out.println(str1.indexOf("lo")); // 3
        System.out.println(str1.indexOf("lol")); // -1

        // 6. int indexOf(String str, int fromIndex)
        System.out.println(str1.indexOf("lo", 5)); // -1

        // 7. int lastIndexOf(String str)
        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or")); // 7

        // 8. int lastIndexOf(String str, int fromIndex)
        System.out.println(str3.lastIndexOf("or", 6)); // 4

        // 什么情况下，indexOf(str) 和 lastIndexOf(str) 返回值相同 ?
        // 情况一：存在唯一的一个 str 情况二：不存在 str

    }

    /*
        替换：

        String replace(char oldChar, char newChar)                      返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的

        String replace(CharSequence target, CharSequence replacement)   使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串

        String replaceAll(String regex, String replacement)             使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串

        String replaceFirst(String regex, String replacement)           使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串

        匹配：

        boolean matches(String regex)                                   告知此字符串是否匹配给定的正则表达式

        切片：

        String[] split(String regex)                                    根据给定正则表达式的匹配拆分此字符串

        String[] split(String regex, int limit)                         根据匹配给定的正则表达式来拆分此字符串，最多不超过 limit 个，如果超过了，剩下的全部放到最后一个元素中
    */
    @Test
    public void test3() {

        // 1. String replace(char oldChar, char newChar)
        String str1 = "一朝春尽红颜老春";
        String str2 = str1.replace('春', '秋');
        System.out.println(str1); // 一朝春尽红颜老春
        System.out.println(str2); // 一朝秋尽红颜老秋

        // 2. String replace(CharSequence target, CharSequence replacement)
        str1 = "一朝春春尽红颜老春尽";
        String str3 = str1.replace("春尽", "秋来");
        System.out.println(str3); // 一朝春秋来红颜老秋来

        // 3. String replaceAll(String regex, String replacement)
        String str4 = "12hello34world5java7891mysql456";
        // 把字符串中的数字替换成,，如果结果中开头和结尾有 , 的话去掉
        String str5 = str4.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(str5);

        // 4. boolean matches(String regex)
        // 判断 str 字符串中是否全部由数字组成，即由 1-n 个数字组成
        String str6 = "12345";
        boolean matches = str6.matches("\\d+"); // true
        System.out.println(matches);
        // 判断是否是一个杭州的固定电话
        String tel = "0571-4534289";
        boolean result = tel.matches("^0571-\\d{7,8}$"); // true
        System.out.println(result);

        // 5. String[] split(String regex)
        String str7 = "hello|world|java";
        String[] strs = str7.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        System.out.println();
        String str8 = "hello.world.java";
        String[] strs2 = str8.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);
        }
    }
}
















