package com.wndexx.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * @author wndexx
 * @create 2022-03-01 9:27
 */
/*
    一、集合框架的概述

    1. 集合、数组都是对多个数据进行存储操作的结构，简称 Java 容器

        说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt，.jpg，.avi，数据库中，...）

    2.
        数组在存储多个数据方面的特点：

            (1) 一旦初始化以后，其长度就确定了

            (2) 数组一旦定义好，其元素的类型也就确定了，我们也就只能操作指定类型的数据了。

                比如：String[] arr；int[] arr1；Object[] arr2；（表现多态性）

        数组在存储多个数据方面的缺点：

            (1) 一旦初始化以后，其长度就不可修改

            (2) 数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高

            (3) 获取数组中实际元素的个数的需求，数组没有现成的属性或方法可用

            (4) 数组存储数据的特点：有序、可重复；对于无序、不可重复的需求，不能满足

    二、集合框架 java.util

        |---- Collection 接口：单列集合，用来存储一个一个的对象

            |---- List 接口：存储有序的、可重复的数据。   ---> "动态数组"

                |---- ArrayList、LinkList、Vector

            |---- Set 接口：存储无序的、不可重复的数据    ---> 高中讲的 "集合"：无序性，确定性，互异性

                |---- HashSet、LinkedHashSet、TreeSet

        |---- Map 接口：双列集合，用来存储一对(key-value)一对的数据         ---> 高中函数：y = f(x)

            |--- HashMap、LinkedHashMap、TreeMap、Hashtable、Properties

    三、Collection 接口中的方法的使用

*/
public class CollectionTest {

    @Test
    public void test1() {

        Collection coll = new ArrayList();

        // 1. add(Object e)：将元素 e 添加到集合 coll 中
        coll.add("AA");
        coll.add("BB");
        coll.add(123); // 自动装箱
        coll.add(new Date());

        // 2. size()：获取添加的元素的个数
        System.out.println(coll.size()); // 4

        // 3. addAll(Collection coll1)：将 coll1 集合中的元素添加到当前的集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);

        System.out.println(coll.size()); // 6
        System.out.println(coll); // [AA, BB, 123, Tue Mar 01 13:08:21 CST 2022, 456, CC]

        // 4. clear()：清空集合元素
        coll.clear();

        // 5. isEmpty()：判断当前集合是否为空（即当前集合是否有元素）
        System.out.println(coll.isEmpty()); // true
    }
}
