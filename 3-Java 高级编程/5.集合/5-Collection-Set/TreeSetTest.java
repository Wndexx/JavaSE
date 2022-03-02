package com.wndexx.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author wndexx
 * @create 2022-03-02 12:29
 */
public class TreeSetTest {

    /*
        TreeSet 存储结构：红黑树。 特点：有序，存储速度比 List 快

            1. 向 TreeSet 中添加的数据，要求是相同类的对象

            2. 两种排序方式：自然排序（实现 Comparable 接口） 和 定制排序（Comparator）

            3. 自然排序中，比较两个对象是否相同的标准为：compareTo() 返回 0，不再是 equals()

            4. 定制排序中，比较两个对象是否相同的标准为：compare() 返回 0，不再是 equals()

        如果既有定制排序，也有自然排序，会优先使用 定制排序
    */
   // 方式一：自然排序
    @Test
    public void test1() {
        TreeSet set = new TreeSet();

        // 失败：不能添加不同类的对象
        /*set.add(123);
        set.add(456);
        set.add("AA");
        set.add(new User("Tom", 12));*/

        // 举例1：
        /*set.add(34);
        set.add(-34);
        set.add(43);
        set.add(11);
        set.add(8);*/

        // 举例2：
        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 32));
        set.add(new User("Jim", 2));
        set.add(new User("Mike", 65));
        set.add(new User("Jack", 33));
        set.add(new User("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

	// 方式二：定制排序
    @Test
    public void test2() {
        Comparator com = new Comparator() {
            // 按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if (!(o1 instanceof User && o2 instanceof User))
                    throw new RuntimeException("输入的数据类型不匹配");
                User u1 = (User) o1;
                User u2 = (User) o2;
                return Integer.compare(u1.getAge(), u2.getAge());
            }
        };

        TreeSet set = new TreeSet(com);

        set.add(new User("Tom", 12));
        set.add(new User("Jerry", 32));
        set.add(new User("Jim", 2));
        set.add(new User("Mike", 65));
        set.add(new User("Jack", 33));
        set.add(new User("Mary", 33));
        set.add(new User("Jack", 56));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
