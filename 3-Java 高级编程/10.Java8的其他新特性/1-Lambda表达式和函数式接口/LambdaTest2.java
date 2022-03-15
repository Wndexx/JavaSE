package com.wndexx.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author wndexx
 * @create 2022-03-12 14:20
 */
/*
    java 内置的 4 大核心函数式接口 : java.util.function

        消费型接口   Consumer<T>         void accept(T t)

        供给型接口   Supplier<T>         T get()

        函数型接口   Function<T, R>      R apply(T t)

        断定型接口   Predicate<T>        boolean test(T t)
		
		
		
	函数式接口 				参数类型 	返回类型 		用途
	
	Consumer<T>	消费型接口	  T			void			对类型为 T 的对象应用操作，包含方法：void accept(T t)
	
	Supplier<T> 供给型接口     无 		T 				返回类型为 T 的对象，包含方法：T get()
	
	Function<T, R> 函数型接口   T 		R 				对类型为 T 的对象应用操作，并返回结果。结果是 R 类型的对象。包含方法：R apply(T t)
	
	Predicate<T> 断定型接口 	   T 		boolean 		确定类型为 T 的对象是否满足某约束，并返回boolean 值。包含方法：boolean test(T t)


    其他接口：

    函数式接口                            参数类型        返回类型           用途

    BiFunction<T, U, R>                  T, U            R             对类型为 T, U 参数应用操作，返回 R 类型的结果。包含方法为： R apply(T t, U u);

    UnaryOperator<T>(Function子接口)      T               T             对类型为T的对象进行一元运算，并返回T类型的结果。包含方法为：T apply(T t);

    BinaryOperator<T>(BiFunction 子接口)  T, T            T             对类型为T的对象进行二元运算，并返回T类型的结果。包含方法为： T apply(T t1, T t2);

    BiConsumer<T, U>                      T, U          void           对类型为T, U 参数应用操作。包含方法为： void accept(T t, U u)

    BiPredicate<T,U>                      T,U           boolean        包含方法为： boolean test(T t,U u)

    ToIntFunction<T>                                    int
    ToLongFunction<T>                      T            long            分别计算int、long、double值的函数 applyAsInt
    ToDoubleFunction<T>                                 double

    IntFunction<R>                         int
    LongFunction<R>                        long          R              参数分别为int、long、double 类型的函数
    DoubleFunction<R>                      double
	

*/
public class LambdaTest2 {

    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("小笼包，价格为：" + aDouble);
            }
        });

        System.out.println("**********************************");

        happyTime(400, money -> System.out.println("小笼包，价格为：" + money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }


    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs); // [北京, 南京, 东京, 西京, 普京]

        System.out.println("**********************************");

        List<String> list1 = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStrs1 = filterString(list1, s -> s.contains("京"));
        System.out.println(filterStrs); // [北京, 南京, 东京, 西京, 普京]
    }

    // 根据给定的规则，过滤集合中的字符串。此规则由 Predicate 的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)) {
                filterList.add(s);
            }
        }
        return filterList;
    }
}
