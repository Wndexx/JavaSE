package com.wndexx.java;

import org.junit.Test;

import java.util.*;

/**
 * @author wndexx
 * @create 2022-03-01 18:34
 */
/*

    1. List 接口框架

        |---- Collection 接口：单列集合，用来存储一个一个的对象

                |---- List 接口：存储有序的、可重复的数据。   ---> "动态数组"，替换原有的数组

                    |---- ArrayList：作为 List 接口的主要实现类；线程不安全的，效率高；底层使用 Object[] elementData 存储

                    |---- LinkList：对于频繁的插入、删除操作，使用此类效率比 ArrayList 高；底层使用双向链表存储

                    |---- Vector：作为 List 接口的古老实现类；线程安全的，效率低；底层使用 Object[] elementData 存储

    2. ArrayList 的源码分析：

        2.1 jdk 7 的情况下：

            ArrayList = new ArrayList(); // 底层创建了长度是 10 的 Object[] 数组 elementData

            list.add(123); elementData[0] = new Integer(123)
            ...
            list.add(11); // 如果此次的添加导致底层 elementData 数组容量不够，则扩容。

                默认情况下，扩容为原来的容量的 1.5 倍，同时需要将原有数组中的数据复制到新的数组中

            结论：建议开发中使用带参的构造器：ArrayList list = new ArrayList(int initialCapacity);

        2.2 jdk 8 中 ArrayList 的变化

            ArrayList = new ArrayList(); // 底层 Object[] elementData 初始化为 {} ，意味着并没有创建长度为 10 的数组

            list.add(123); // 第一次调用 add() 时，底层才创建了长度为 10 的数组，并将数据 123 添加到 elementData[0]
            ...
            后续的添加和扩容操作与 jdk7 无异；

        2.3 小结：

            jdk 7 中的 ArrayList 的对象的创建类似于单例的饿汉式，而 jdk8 中的 ArrayList 的对象的创建类似于单例的懒汉式，延迟了数组的创建，节省内存

    3. LinkedList 的源码分析：

        LinkedList list = new LinkedList(); // 内部声明了 Node 类型的 first 和 last 属性，默认值为 null

        list.add(123); // 将 123 封装到 Node 中，创建了 Node 对象

        其中 Node 定义为： 体现了 LinkedList 的双向链表的说法

            private static class Node<E> {
                E item;
                Node<E> next;
                Node<E> prev;

                Node(Node<E> prev, E element, Node<E> next) {
                    this.item = element;
                    this.next = next;
                    this.prev = prev;
                }
            }

    4. Vector 的源码分析：jdk 7 和 jdk 8 中通过 Vector() 构造器创建对象时，底层都创建了长度为 10 的数组

        在扩容方面，默认扩容为原来的数组长度的 2 倍。

    面试题：ArrayList、LinkedList、Vector 三者的异同

        相同点：三个类都实现了 List 接口，存储数据的特点相同：存储有序的、可重复的数据。

        不同点：见上

    5. list 接口中的常用方法

        void add(int index, Object ele)             在 index 位置插入 ele 元素

        boolean addAll(int index, Collection eles)  从 index 位置开始将 eles 中的所有元素添加进来

        Object get(int index)                       获取指定 index 位置的元素

        int indexOf(Object obj)                     返回 obj 在集合中首次出现的位置

        int lastIndexOf(Object obj)                 返回 obj 在当前集合中末次出现的位置

        Object remove(int index)                    移除指定 index 位置的元素，并返回此元素

        Object set(int index, Object ele)           设置指定 index 位置的元素为 ele

        List subList(int fromIndex, int toIndex)    返回从 fromIndex 到 toIndex 位置的子集合


        总结：常用方法

        增： add(Object obj)

        删：remove(int index) / remove(Object obj)

        改：set(int index, Object ele)

        查：get(int index)

        插：add(int index, Object ele)

        长度：size()

        遍历: Iterator 迭代器方式；增强 for 循环；普通的循环
		
		
	存储的元素的要求：添加的对象所在的类要重写 equals() 方法

*/
public class ListTest {

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

        System.out.println(list); // [123, 456, AA, Person{name='Tom', age=12}, 456]

        // 1. void add(int index, Object ele)：在 index 位置插入 ele 元素
        list.add(1, "BB");
        System.out.println(list); // [123, BB, 456, AA, Person{name='Tom', age=12}, 456]

        // 2. boolean addAll(int index, Collection eles)：从 index 位置开始将 eles 中的所有元素添加进来
        List list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        // list.add(list1);
        System.out.println(list.size()); // 9

        // 3. Object get(int index)：获取指定 index 位置的元素
        System.out.println(list.get(0)); // 123
    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

        // 4. int indexOf(Object obj)：返回 obj 在集合中首次出现的位置；如果不存在，返回 -1
        int index = list.indexOf(456);
        System.out.println(index); // 1

        int index1 = list.indexOf(4567);
        System.out.println(index1); // -1

        // 5. int lastIndexOf(Object obj)：返回 obj 在当前集合中末次出现的位置；如果不存在，返回 -1
        System.out.println(list.lastIndexOf(456)); // 4

        // 6. Object remove(int index)：移除指定 index 位置的元素，并返回此元素
        Object obj = list.remove(0);
        System.out.println(obj); // 123
        System.out.println(list); // [456, AA, Person{name='Tom', age=12}, 456]

        // 7. Object set(int index, Object ele)：设置指定 index 位置的元素为 ele
        list.set(1, "CC");
        System.out.println(list); // [456, CC, Person{name='Tom', age=12}, 456]

        // 8. List subList(int fromIndex, int toIndex)：返回从 fromIndex 到 toIndex 位置的左闭右开区间的子集合
        List subList = list.subList(2, 4);
        System.out.println(list); // [456, CC, Person{name='Tom', age=12}, 456]
        System.out.println(subList.toString()); // [Person{name='Tom', age=12}, 456]
    }

    @Test
    public void test3() {
        // 遍历: Iterator 迭代器方式；增强 for 循环；普通的循环
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        // 方式一：Iterator 迭代器方式
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("****************************");

        // 方式二：增强 for 循环
        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println("****************************");

        // 方式三：普通的 for 循环
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
