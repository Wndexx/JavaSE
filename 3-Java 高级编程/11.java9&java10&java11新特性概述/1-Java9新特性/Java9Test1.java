package com.wndexx.java;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * @author wndexx
 * @create 2022-03-15 8:12
 */
/*
    8. 集合工厂方法：快速创建只读集合

        调用集合中静态方法 of()，可以将不同数量的参数传输到此工厂方法中。此功能可用于 Set 和 List ，也可用于 Map 的类似形式。

        此时得到的集合，是不可变的：在创建后，继续添加元素到这些集合会导致 "UnsupportedOperationException"。

    9. InputStream 加强：

        transferTo，可以用来将数据直接传输到 OutputStream，这是在处理原始数据流时非常常见的一种用法


*/
public class Java9Test1 {

    // java 8  中创建只读集合的写法：
    @Test
    public void test1() {

        List<String> namesList = new ArrayList<>();

        namesList.add("Joe");
        namesList.add("Bob");
        namesList.add("Bill");

        // 返回的 namesList 是一个只读的集合
        namesList = Collections.unmodifiableList(namesList);

        // namesList.add("Tom"); // java.lang.UnsupportedOperationException

        System.out.println(namesList);
    }

    @Test
    public void test2() {

        List<String> list = Collections.unmodifiableList(Arrays.asList("a", "b", "c"));

        Set<String> set = Collections.unmodifiableSet(new HashSet<>(Arrays.asList("a", "b", "c")));

        // 如下操作不适用于jdk 8 及之前版本,适用于jdk 9
        Map<String, Integer> map = Collections.unmodifiableMap(new HashMap<>() {
            {
                put("a", 1);
                put("b", 2);
                put("c", 3);
            }
        });

        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    public void test3() {

        // 此时得到的集合 list 也是一个只读集合
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // list.add(6); // 报异常， java.lang.UnsupportedOperationException
    }


    // java 9 新特性八：集合工厂方法创建只读集合
    @Test
    public void test4() {

        List<Integer> list1 = List.of(1, 2, 3, 4, 5);
        // 不能添加， 报异常：java.lang.UnsupportedOperationException
        // list1.add(6);
        System.out.println(list1);

        Set<Integer> set1 = Set.of(23, 1, 4, 5, 6, 7, 8, 11, 54, 233);
        // 不能添加， 报异常：java.lang.UnsupportedOperationException
        // set1.add(54);
        System.out.println(set1);


        Map<String, Integer> map1 = Map.of("Tom", 23, "Jerry", 54, "Jack", 12);
        // 不能添加， 报异常：java.lang.UnsupportedOperationException
        // map1.put("lilei",34);
        System.out.println(map1);

        Map<String, Integer> map2 = Map.ofEntries(Map.entry("Tom", 34), Map.entry("Jerry", 21));
        // 不能添加， 报异常：java.lang.UnsupportedOperationException
        // map2.put("lilei", 34);
        System.out.println(map2);
    }

    // java 9 新特性九：InputStream 的新方法：transferTo()
    @Test
    public void test5() {

        ClassLoader cl = this.getClass().getClassLoader();

        try (InputStream is = cl.getResourceAsStream("hello.txt");
             OutputStream os = new FileOutputStream("src\\hello1.txt")) {
            is.transferTo(os); // 把输入流中的所有数据直接自动地复制到输出流中
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
