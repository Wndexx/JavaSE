package com.wndexx.exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wndexx
 * @create 2022-03-02 19:21
 */
public class SetExer {

    // 在List内去除重复数字值，要求尽量简单
    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(2));
        list.add(new Integer(4));
        list.add(new Integer(4));
        List list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    public List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }

    @Test
    public void test2() {

        HashSet set = new HashSet();

        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");

        set.add(p1);
        set.add(p2);

        // p1.name = "CC";
        p1.setName("CC");

        // 注意先根据 hashCode() 判断所在位置，有需要再根据 equals() 判断是否相等
        set.remove(p1);
        System.out.println(set); // [Person{id=1002, name='BB'}, Person{id=1001, name='CC'}]

        set.add(new Person(1001, "CC")); // [Person{id=1002, name='BB'}, Person{id=1001, name='CC'}, Person{id=1001, name='CC'}]
        System.out.println(set);

        set.add(new Person(1001, "AA")); // [Person{id=1002, name='BB'}, Person{id=1001, name='CC'}, Person{id=1001, name='CC'}, Person{id=1001, name='AA'}]
        System.out.println(set);
        // 其中Person类中重写了hashCode()和equal()方法
    }
}
