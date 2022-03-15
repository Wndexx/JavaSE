package com.wndexx.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
	方法引用的使用

        1. 使用情境：当要传递给 Lambda 体的操作，已经有实现的方法了，可以使用方法引用！

        2. 方法引用，本质上就是 Lambda 表达式，而 Lambda 表达式作为函数式接口的实例，所以

           方法引用，也是函数式接口的实例

        3. 使用格式： 类(或对象) :: 方法名

        4. 具体分为如下的三种情况：

            情况1     对象 :: 非静态的方法
            情况2     类 :: 静态方法

            情况3     类 :: 非静态方法

        5. 方法引用使用的要求：

           情况1和情况2：要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同！

           情况3：抽象方法的第一个形参作为方法引用方法的调用者，第二个形参作为方法引用方法的参数（如果没有第二个形参，则方法引用方法不能有参数）；

                 抽象方法的返回值类型和引用方法的返回值类型相同
				 
		理解方法引用：
		
			方法引用可以看做是 Lambda 表达式深层次的表达。
			
			换句话说，方法引用就是 Lambda 表达式，也就是函数式接口的一个实例，通过方法的名字来指向一个方法，可以认为是 Lambda 表达式的一个语法糖
			
			
		使用建议：
		
			如果给函数式接口提供实例，恰好满足方法引用的使用情境，大家可以考虑使用方法引用给函数式接口提供实例。
			
			如果大家不熟悉方法引用，那么还可以使用 Lambda 表达式
			
			
 */
public class MethodRefTest {

    // 情况一：对象 :: 实例方法
    //Consumer中的void accept(T t)
    //PrintStream中的void println(T t)
    @Test
    public void test1() {
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("北京"); // 北京

        System.out.println("*******************************");

        PrintStream ps = System.out;
        Consumer<String> con2 = ps::println;
        con2.accept("beijing"); // beijing
    }

    //Supplier中的T get()
    //Employee中的String getName()
    @Test
    public void test2() {
        Employee emp = new Employee(1001, "Tom", 23, 5600);

        Supplier<String> sup1 = () -> emp.getName();
        System.out.println(sup1.get()); // Tom

        Supplier<String> sup2 = emp::getName;
        System.out.println(sup2.get()); // Tom
    }

    // 情况二：类 :: 静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3() {
        Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
        System.out.println(com1.compare(12, 21)); // -1

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(23, 12)); // 1
    }

    //Function中的R apply(T t)
    //Math中的Long round(Double d)
    @Test
    public void test4() {
        Function<Double, Long> func1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };

        Function<Double, Long> func2 = d -> Math.round(d);
        System.out.println(func2.apply(12.3)); // 12

        Function<Double, Long> func3 = Math::round;
        System.out.println(func3.apply(12.6)); // 13
    }

    // 情况三：类 :: 实例方法（有难度）
    // Comparator中的int compare(T t1,T t2)
    // String中的int t1.compareTo(t2)
    @Test
    public void test5() {
        Comparator<String> com1 = (s1, s2) -> s1.compareTo(s2);
        System.out.println(com1.compare("abc", "abd")); // -1

        Comparator<String> com2 = String::compareTo;
        System.out.println(com2.compare("abc", "abm")); // -10
    }

    //BiPredicate中的boolean test(T t1, T t2);
    //String中的boolean t1.equals(t2)
    @Test
    public void test6() {
        BiPredicate<String, String> pre1 = (t1, t2) -> t1.equals(t2);
        System.out.println(pre1.test("abc", "abd")); // false

        BiPredicate<String, String> pre2 = String::equals;
        System.out.println(pre2.test("abc", "abc")); // true
    }

    // Function中的R apply(T t)
    // Employee中的String getName();
    @Test
    public void test7() {
        Employee emp = new Employee(1001, "Tom", 23, 5600);

        Function<Employee, String> func1 = e -> e.getName();
        System.out.println(func1.apply(emp)); // Tom

        Function<Employee, String> func2 = Employee::getName;
        System.out.println(func2.apply(emp)); // Tom
    }

}
