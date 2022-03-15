package com.wndexx.java1;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author wndexx
 * @create 2022-03-15 10:56
 */
public class Java10Test {

    /*
        java 10 新特性一：局部变量的类型推断

            工作原理：在处理 var 时，编译器先是查看表达式右边部分，并根据右边变量值的类型进行推断，作为左边变量的类型，然后将该类型写入字节码当中

            注意：

                var 不是一个关键字

                    你不需要担心变量名或方法名会与 var 发生冲突，因为 var 实际上并不是一个关键字，而是一个类型名，只有在编译器需要知道类型的地方才需要用到它。

                    除此之外，它就是一个普通合法的标识符。也就是说，除了不能用它作为类名，其他的都可以，但极少人会用它作为类名。

                这不是 JavaScript

                    var 并不会改变 Java 是一门静态类型语言的事实。编译器负责推断出类型，并把结果写入字节码文件，就好像是开发人员自己敲入类型一样。
    */
    @Test
    public void test1() {

        // 1. 声明变量时，根据所赋的值，推断变量的类型
        // int num = 10;
        var num = 10;

        // ArrayList<String> list = new ArrayList<>();
        var list = new ArrayList<Integer>();
        list.add(123);

        // 2. 遍历操作
        // 增强 for 循环
        for (var i : list) {
            System.out.println(i); // 123
            System.out.println(i.getClass()); // class java.lang.Integer
        }

        // 普通的遍历操作
        for (var i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        // 1. 局部变量不赋值，就不能实现类型推断
        var num = "hello";
        System.out.println(num.getClass());

        // 2. lambda 表达式中，左边的函数式接口不能声明为 var
        // Supplier<Double> sup = Math::random;
        // Supplier<Double> sup = () -> Math.random();
        // var sup = () -> Math.random();

        // 3. 方法引用中，左边的函数式接口不能声明为 var
        // Consumer<String> con = System.out::println;
        // var con = System.out::println;

        // 4. 数组的静态初始化中，注意如下的情况也不可以
        // int[] arr = new int[]{1, 2, 3, 4};
        // var arr = {1, 2, 3, 4};
    }

    @Test
    public void test3() {
        /*

        局部变量类型推断不适用以下的结构中

            情况1：没有初始化的局部变量声明

            情况2：方法的返回类型

            情况3：方法的参数类型

            情况4：构造器的参数类型

            情况5：属性

            情况6：catch块
        */
        // 1. 情况1：没有初始化的局部变量声明
        // var s = null;

        // 情况6：catch块
        // try {
        //
        // } catch (var e) {
        //     e.printStackTrace();
        // }

    }

    // 情况2：方法的返回类型
    // public var method1() {
    //     return 0;
    // }

    // 情况3：方法的参数类型
    // public void method2(var num){
    //
    // }

    // 情况4：构造器的参数类型
    // public Java10Test(var i){
    //
    // }

    // 情况5：属性
    // var num = 10;

    @Test
    public void test4() {

        try {
            var url = new URL("http://www.atguigu.com");
            var connection = url.openConnection();
            var reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
            java 10 新特性二：集合中新增的 copyOf()，用于创建一个只读的集合

            集合新增创建不可变集合的方法

            自 Java 9 开始，jdk 里面为集合（List / Set / Map）都添加了 of (jdk9 新增)和 copyOf (jdk10 新增)方法，它们两个都用来创建不可变的集合
    */

    @Test
    public void test5() {

        var list1 = List.of("Java", "Python", "C");
        var copy1 = List.copyOf(list1);
        System.out.println(list1 == copy1); // true

        var list2 = new ArrayList<String>();
        list2.add("aaaa");
        var copy2 = List.copyOf(list2);
        System.out.println(list2 == copy2); // false

        // 示例 1 和 2 代码基本一致，为什么一个为 true，一个为 false?
        // 结论：copyOf(Xxx coll)：
        // 如果参数 coll 本身就是一个只读集合，则 copyOf() 返回值即为当前的 coll
        // 如果参数 coll 不是一个只读集合，则 copyOf() 返回一个新的集合，这个集合是只读的

    }
}
