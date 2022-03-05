package com.wndexx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wndexx
 * @create 2022-03-04 17:52
 */
/*
    Collections：操作 Collection、Map 的工具类

    排序操作：（均为static方法）

        reverse(List)           反转 List 中元素的顺序

        shuffle(List)           对 List 集合元素进行随机排序

        sort(List)              根据元素的自然顺序对指定 List 集合元素按升序排序

        sort(List，Comparator)  根据指定的 Comparator 产生的顺序对 List 集合元素进行排序

        swap(List，int， int)   将指定 list 集合中的 i 处元素和 j 处元素进行交换

    查找、替换

        Object max(Collection)                                        根据元素的自然顺序，返回给定集合中的最大元素

        Object max(Collection，Comparator)                            根据 Comparator 指定的顺序，返回给定集合中的最大元素

        Object min(Collection)

        Object min(Collection，Comparator)

        int frequency(Collection，Object)                             返回指定集合中指定元素的出现次数

        void copy(List dest,List src)                                 将src中的内容复制到 dest 中

        boolean replaceAll(List list，Object oldVal，Object newVal)   使用新值替换List 对象的所有旧值

    Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题

    面试题：Collection 和 Collections 的区别？

*/
public class CollectionsTest {

    @Test
    public void test1() {

        List list = new ArrayList();

        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list); // [123, 43, 765, -97, 0]

        // 1. reverse(List)：反转 List 中元素的顺序
        // Collections.reverse(list);
        // System.out.println(list); // [0, -97, 765, 43, 123]

        // 2. shuffle(List)：对 List 集合元素进行随机排序
        // Collections.shuffle(list);
        // System.out.println(list);

        // 3. sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
        // Collections.sort(list);
        // System.out.println(list); // [-97, 0, 43, 123, 765]

        // 4. swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
        // Collections.swap(list, 1, 2);
        // System.out.println(list); // [123, 765, 43, -97, 0]

        // 5. int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
        // int frequency = Collections.frequency(list, 765);
        // System.out.println(frequency); // 3
    }

    @Test
    public void test2() {

        // 6. void copy(List dest,List src)：将src中的内容复制到 dest 中
        List list = new ArrayList();

        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        // 错误的，报异常：IndexOutOfBoundsException: Source does not fit in dest
        // List dest = new ArrayList();
        // Collections.copy(dest, list); // java.lang.IndexOutOfBoundsException: Source does not fit in dest
        // System.out.println(dest);

        // 正确的：
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest, list);
        System.out.println(dest); // [123, 43, 765, 765, 765, -97, 0]

        /*
            Collections 类中提供了多个 synchronizedXxx() 方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题
			
			说明：ArrayList 和 HashMap 都是线程不安全的，如果程序要求线程安全，
			
			我们可以将 ArrayList、HashMap 转换为线程安全的，使用 synchronizedList(List list) 和 synchronizedMap(Map map)
			
        */
        // 返回的 list1 即为线程安全的 list
        List list1 = Collections.synchronizedList(list);

    }
}
