package com.wndexx.java;

import org.junit.Test;

import java.util.*;

import java.util.Map.*;

/**
 * @author wndexx
 * @create 2022-03-05 9:47
 */
/*
    泛型的使用

    所谓泛型，就是允许在定义类、接口时通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。

    这个类型参数将在使用时（例如，继承或实现这个接口，用这个类型声明变量、创建对象时）确定（即传入实际的类型参数，也称为类型实参）

    1. jdk 5.0 新增的特性

    2. 在集合中使用泛型：

        总结：

        (1) 集合接口或集合类在 jdk5.0 时都修改为带泛型的结构

        (2) 在实例化集合类时，可以指明具体的泛型类型

        (3) 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等等）使用到类的泛型的位置，都指定为实例化的泛型类型

            比如：add(E e) ---> 实例化以后：add(Integer e)

        (4) 泛型的类型必须是一个类，不能是基本数据类型，需要用到基本数据类型的位置，拿包装类替换

        (5) 如果实例化时，没有指明泛型的类型。默认类型为 java.lang.Object 类型

    3. 如何自定义泛型：泛型类、泛型接口；泛型方法。见：GenericTest1.java


*/
public class GenericTest {

    // 在集合中使用泛型之前的情况：
    @Test
    public void test1() {
        ArrayList list = new ArrayList();

        // 需求：存放学生的成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);

        // 问题一：类型不安全
        // list.add("Tom");

        for (Object score : list) {
            // 问题二：强转时，可能出现类型转换异常：ClassCastException
            int stuScore = (Integer) score;

            System.out.println(stuScore);
        }
    }

    // 在集合中使用泛型的情况：以 ArrayList 为例
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65);

        // 编译时，就会进行类型检查，保证数据的安全
        // list.add("Tom");

        // 方式一：
        // for (Integer score : list) {
        //     // 避免了强转操作
        //     int stuScore = score;
        //
        //     System.out.println(stuScore);
        // }

        // 方式二：
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    // 在集合中使用泛型的情况：以 HashMap 为例
    @Test
    public void test3() {
        // Map<String, Integer> map = new HashMap<String, Integer>();
        // jdk 7 新特性：类型推断
        Map<String, Integer> map = new HashMap<>();

        map.put("Tom", 87);
        map.put("Jerry", 87);
        map.put("Jack", 67);

        // map.put(123, "ABC");

        // 泛型的嵌套
        Set<Entry<String, Integer>> entry = map.entrySet();
        Iterator<Entry<String, Integer>> iterator = entry.iterator();
        while (iterator.hasNext()) {
            Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "--->" + value);
        }
    }
}
