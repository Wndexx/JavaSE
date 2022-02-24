package com.wndexx.java;

import org.junit.Test;

/**
 * @author wndexx
 * @create 2022-02-24 15:03
 */
/*
    关于 StringBuffer 和 StringBuilder 的使用


*/
public class StringBufferBuilderTest {

    /*
        String、StringBuffer、StringBuilder 三者的异同？

            String: 不可变的字符序列；底层结构使用 char[] 存储

            StringBuffer: 可变的字符序列，线程安全的，效率低；底层结构使用 char[] 存储

            StringBuilder: 可变的字符序列，线程不安全的，效率高，jdk5.0新增；底层结构使用 char[] 存储

        源码分析：

            String str = new String(); // char[] value = new char[0]
            String str1 = new String("abc"); // char[] value = new char[]{'a','b','c'}

            StringBuffer sb1 = new StringBuffer(); // char[] value = new char[16] 底层创建了一个长度是 16 的数组
            System.out.println(sb1.length); // 0
            sb1.append('a'); // value[0] = 'a'
            sb1.append('b'); // value[1] = 'a'

            StringBuffer sb2 = new StringBuffer("abc"); // char[] value = new char["abc".length + 16]

            // 问题1
            System.out.println(sb2.length); // 3

            // 问题2 扩容问题：如果添加的数据，底层数组盛不下了，那就需要扩容底层的数组

                    默认情况下，扩容为原来容量的 2 倍 + 2，同时将原有数组中的元素复制到新的数组中

                    指导意义：开发中建议大家使用： StringBuffer(int capacity) 或 StringBuilder(int capacity)
    */
    @Test
    public void test1() {

        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0, 'm');
        System.out.println(sb1); // mbc

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length()); // 0
    }

    /*
        StringBuffer 的常用方法：

        StringBuffer append(xxx)                                提供了很多的 append() 方法，用于进行字符串拼接

        StringBuffer delete(int start, int end)                 删除指定位置的内容

        StringBuffer replace(int start, int end, String str)    把 [start, end] 位置替换为 str

        StringBuffer insert(int offset, xxx)                    在指定位置插入xxx

        StringBuffer reverse()                                  把当前字符序列逆转

            以上方法支持 方法链操作

            方法链的原理：

            public StringBuilder append(String str){
                super.append(str);
                return this; // 返回自己
            }


        public int indexOf(String str)

        public String subString(int start, int end)             返回一个从 start 开始到 end 索引结束的左闭右开区间的子字符串

        public int length()

        public char charAt(int n)

        public void setCharAt(int n, char ch)

        总结：

            增：append(xxx)

            删：delete(int start, int end)

            改：setCharAt(int n, char ch) 、replace(int start, int end, String str)

            查：charAt(int n)

            插：insert(int offset, xxx)

            长度：length()

            遍历：for + charAt() / toString()

    */
    @Test
    public void test2() {

        // 1.  StringBuffer append(xxx)
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1); // abc11

        // 2. StringBuffer delete(int start, int end)
        // s1.delete(2, 4);
        System.out.println(s1); // ab1

        // 3. StringBuffer replace(int start, int end, String str)
        // s1.replace(2, 4, "hello");
        System.out.println(s1); // abhello1

        // 4. StringBuffer insert(int offset, xxx)
        // s1.insert(2, false);
        System.out.println(s1); // abfalsec11
        System.out.println(s1.length()); // 10

        // 5. StringBuffer reverse()
        // s1.reverse();
        System.out.println(s1); // 11cba
        System.out.println(s1.length()); // 5

        // 6. public int indexOf(String str)

        // 7. public String subString(int start, int end)
        String s2 = s1.substring(1, 3);
        System.out.println(s1); // abc11
        System.out.println(s2); // bc

        // 8. public int length()

        // 9. public char charAt(int n)

        // 10. public void setCharAt(int n, char ch)
    }

    /*
        String、StringBuffer、StringBuilder 效率对比

            从高到低排列：StringBuilder > StringBuffer > String

    */
    @Test
    public void test3() {

        // 初始位置
        long startTime = 0L;
        long endTime = 0L;

        String test = "";
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();

        // 开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer 的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder 的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            test += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String 的执行时间：" + (endTime - startTime));
    }

}
