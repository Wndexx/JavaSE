package com.wndexx.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author wndexx
 * @create 2022-03-01 16:19
 */

/*
    集合 Collection 元素的遍历操作，使用迭代器 Iterator 接口     不包括 Map

    1. 内部的方法：hasNext() 和 next()

    2. Iterator 仅用于遍历集合，Iterator 本身并不提供承装对象的能力。如果需要创建 Iterator 对象，则必须有一个被迭代的集合

    3. 集合对象每次调用 iterator() 方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前。

    4. 内部定义了一个 remove()，可以在遍历的时候删除集合中的元素。此方法不同于集合直接调用 remove()

        - 如果还未调用 next()或在上一次调用 next 方法之后已经调用了 remove 方法，再调用 remove 都会报 IllegalStateException
*/
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        // 方式一：
        /*
            System.out.println(iterator.next()); // 123
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            System.out.println(iterator.next());
            // 报异常：NoSuchElementException
            // System.out.println(iterator.next());  // java.util.NoSuchElementException
        */

        // 方式二：不推荐
        /*
            for (int i = 0; i < coll.size(); i++) {
                System.out.println(iterator.next());
            }
        */

        // 方式三：推荐
        // (1) hasNext():判断是否还有下一个元素
        while (iterator.hasNext()) {
            // (2) next():指针下移；将下移以后集合位置上的元素返回
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        Iterator iterator = coll.iterator();

        // 错误方式一：会导致跳着输出，还会报 NoSuchElementException 异常
        /*while ((iterator.next()) != null){
            System.out.println(iterator.next());
        }*/

        // 错误方式二： 死循环，不断输出 123
        // 集合对象每次调用 iterator() 方法都得到一个全新的迭代器对象，默认游标都在集合的第一个元素之前
        /*while (coll.iterator().hasNext()) {
            System.out.println(coll.iterator().next());
        }*/
    }

    // 测试 Iterator 的 remove() 方法
    // 如果还未调用 next()或在上一次调用 next 方法之后已经调用了 remove 方法，再调用 remove 都会报 IllegalStateException
    @Test
    public void test3() {
        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // 删除集合中 "Tom"
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()) {
            // iterator.remove(); // java.lang.IllegalStateException
            Object obj = iterator.next();
            if ("Tom".equals(obj)) {
                iterator.remove();
                // iterator.remove(); // java.lang.IllegalStateException
            }
        }

        // 重新遍历集合
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
