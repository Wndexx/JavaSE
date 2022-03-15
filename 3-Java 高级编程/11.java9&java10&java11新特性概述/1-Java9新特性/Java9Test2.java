package com.wndexx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author wndexx
 * @create 2022-03-15 9:19
 */
/*
    10. Stream API 的加强

        takeWhile()：用于从 Stream 中获取一部分数据，接收一个 Predicate 来进行选择。在有序的 Stream 中，takeWhile 返回从开头开始的按照制定规则尽量多的元素

        dropWhile()：dropWhile 的行为与 takeWhile 相反，返回剩余的元素

        ofNullable()：Java 8 中 Stream 不能完全为 null，否则会报空指针异常。

                     Java 9 中的 ofNullable 方法允许我们创建一个单元素 Stream，可以包含一个非空元素，也可以创建一个空 Stream

        iterate()重载：iterate 方法的新重载方法，可以让你提供一个 Predicate (判断条件)来指定什么时候结束迭代。

    11. Optional 获取 Stream 的方法

            Optional 类中 stream() 的使用

    12. JavaScript 引擎升级：Nashorn

*/
public class Java9Test2 {

    // java 9 新特性十：Stream API 的加强
    @Test
    public void test1() {

        List<Integer> list = Arrays.asList(23, 43, 45, 55, 61, 54, 32, 2, 45, 89, 7);

        // takeWhile： 返回从开头开始的按照制定规则尽量多的元素
        list.stream().takeWhile(x -> x < 60).forEach(System.out::println); // 23 43 45 55

        System.out.println();

        // dropWhile：与 takeWhile 相反， 返回剩余的元素
        list.stream().dropWhile(x -> x < 60).forEach(System.out::println); // 61 54 32 2 45 89 7
    }

    @Test
    public void test2() {

        // of() 参数中的多个元素，可以包含 null 值
        Stream<Integer> stream1 = Stream.of(1, 2, 3, null);
        stream1.forEach(System.out::println);

        // of() 参数不能存储单个 null 值，否则报异常 java.lang.NullPointerException
        // Stream<Object> stream2 = Stream.of(null);

        Stream<Object> stream2 = Stream.of(null, null);
        stream2.forEach(System.out::println);

        System.out.println();

        Integer i = 10;
        i = null;
        // ofNullable()：形参变量是可以为 null 值的单个元素
        Stream<Integer> stream3 = Stream.ofNullable(i);
        System.out.println(i); // null
        System.out.println(stream3.count()); // 0
    }

    @Test
    public void test3() {

        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);

        System.out.println();

        // java 9 中新增的 iterate 重载的方法
        Stream.iterate(0, x -> x < 100, x -> x + 1).forEach(System.out::println);
    }

    // java 9 新特性十一：Optional 提供了新的方法 stream()
    @Test
    public void test4() {

        List<String> list = new ArrayList<>();

        list.add("Tom");
        list.add("Jerry");
        list.add("Tim");

        Optional<List<String>> optional = Optional.ofNullable(list);

        Stream<List<String>> stream = optional.stream();
        // long count = stream.count();
        // System.out.println(count); // 1

        stream.flatMap(x -> x.stream()).forEach(System.out::println);
    }

    // @Test
    // public void test5() {
    //     List<String> list = Arrays.asList("Tom", "Jerry", "Tim");
    //     list.stream().forEach(System.out::println);
    // }
}
