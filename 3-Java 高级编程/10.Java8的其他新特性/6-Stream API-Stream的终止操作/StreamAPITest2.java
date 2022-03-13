package com.wndexx.java3;

import com.wndexx.java2.Employee;
import com.wndexx.java2.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wndexx
 * @create 2022-03-13 12:23
 */
/*
    Stream 的终止操作
*/
public class StreamAPITest2 {

    // 1-匹配与查找
    /*
        方法                      描述

        allMatch(Predicate p)   检查是否匹配所有元素

        anyMatch(Predicate p)   检查是否至少匹配一个元素

        noneMatch(Predicate p)  检查是否没有匹配所有元素

        findFirst()             返回第一个元素

        findAny()               返回当前流中的任意元素

        count()                 返回流中元素总数

        max(Comparator c)       返回流中最大值

        min(Comparator c)       返回流中最小值

        forEach(Consumer c)     内部迭代(使用 Collection 接口需要用户去做迭代，称为外部迭代。相反，Stream API 使用内部迭代——它帮你把迭代做了)
    */
    @Test
    public void test1() {

        List<Employee> employees = EmployeeData.getEmployees();

        // 1. allMatch(Predicate p)：检查是否匹配所有元素
        // 练习：是否所有的员工的年龄都大于 18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch); // false

        // 2. anyMatch(Predicate p)：检查是否至少匹配一个元素
        // 练习：是否存在员工的工资大于 10000
        boolean anyMatch = employees.stream().allMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch); // false

        // 3. noneMatch(Predicate p)：检查是否没有匹配的元素
        // 练习：是否存在员工姓 "雷"
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("雷"));
        System.out.println(noneMatch); // false

        // 4. findFirst()：返回第一个元素
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);

        // 5. findAny：返回当前流中的任意元素
        // Optional<Employee> employee1 = employees.stream().findAny();
        // parallelStream() 并行流
        Optional<Employee> employee1 = employees.parallelStream().findAny();
        System.out.println(employee1);

    }

    @Test
    public void test2() {

        List<Employee> employees = EmployeeData.getEmployees();

        // 6. count()：返回流中元素总数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);

        // 7. max(Comparator c)：返回流中最大值
        // 练习：返回最高的工资
        Optional<Double> maxSalary = employees.stream().map(Employee::getSalary).max(Double::compare);
        // 或
        // Optional<Double> maxSalary = employees.stream().map(Employee::getSalary).max(Double::compareTo);
        System.out.println(maxSalary);

        // 8. min(Comparator c)：返回流中最小值
        // 练习：返回最低工资的员工
        // employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        Optional<Employee> employee = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println(employee);

        System.out.println();

        // 9. forEach：内部迭代
        employees.stream().forEach(System.out::println);
        // 使用集合的遍历操作
        employees.forEach(System.out::println); // 外部迭代
    }


    // 2-归约
    /*
        方法                                  描述
        reduce(T identity, BinaryOperator b)    可以将流中元素反复结合起来，得到一个值。返回 T

        reduce(BinaryOperator b)            可以将流中元素反复结合起来，得到一个值。返回 Optional<T>


        map 和 reduce 的连接通常称为 map-reduce 模式，因 Google 用它来进行网络搜索而出名。
    */
    @Test
    public void test3() {

        // 1. reduce(T identity, BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 T        identity：初始值
        // 练习1：计算 1 ~ 10 的自然数的和
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        list.stream().reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer i1, Integer i2) {
                return Integer.sum(i1, i2);
            }
        });
        list.stream().reduce(0, (i1, i2) -> Integer.sum(i1, i2));
        Integer sum = list.stream().reduce(0, Integer::sum); //

        System.out.println(sum); // 55

        System.out.println();

        // 2. reduce(BinaryOperator b)：可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
        // 计算公司所有员工工资的总和
        List<Employee> employees = EmployeeData.getEmployees();

        // Optional<Double> sumSalary = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        Optional<Double> sumSalary = employees.stream().map(Employee::getSalary).reduce((d1, d2) -> d1 + d2);

        // employees.stream().map(new Function<Employee, Double>() {
        //     @Override
        //     public Double apply(Employee employee) {
        //         return employee.getSalary();
        //     }
        // }).reduce(new BinaryOperator<Double>() {
        //
        //     @Override
        //     public Double apply(Double o, Double o2) {
        //         return Double.sum(o, o2);
        //     }
        // });

        System.out.println(sumSalary.get());
    }


    // 3-收集
    /*
        方 法                     描 述

        collect(Collector c)    将流转换为其他形式。接收一个 Collector 接口的实现，用于给 Stream 中元素做汇总的方法

        Collector 接口中方法的实现决定了如何对流执行收集的操作(如收集到 List、Set、Map)。 另外， Collectors 实用类提供了很多静态方法，可以方便地创建常见收集器实例，

        具体方法与实例如下表：

        方法                  返回类型                作用

        toList              List<T>                 把流中元素收集到 List
        List<Employee> emps= list.stream().collect(Collectors.toList());

        toSet               Set<T>                  把流中元素收集到Set
        Set<Employee> emps= list.stream().collect(Collectors.toSet());

        toCollection        Collection<T>           把流中元素收集到创建的集合
        Collection<Employee> emps =list.stream().collect(Collectors.toCollection(ArrayList::new));

        counting            Long                    计算流中元素的个数
        long count = list.stream().collect(Collectors.counting());

        summingInt          Integer                 对流中元素的整数属性求和
        int total=list.stream().collect(Collectors.summingInt(Employee::getSalary));

        averagingInt        Double                  计算流中元素Integer属性的平均值
        double avg = list.stream().collect(Collectors.averagingInt(Employee::getSalary));

        summarizingInt      IntSummaryStatistics    收集流中Integer属性的统计值。如：平均值
        int SummaryStatisticsiss= list.stream().collect(Collectors.summarizingInt(Employee::getSalary));

        joining             String                  连接流中每个字符串
        String str= list.stream().map(Employee::getName).collect(Collectors.joining());

        maxBy               Optional<T>             根据比较器选择最大值
        Optional<Emp>max= list.stream().collect(Collectors.maxBy(comparingInt(Employee::getSalary)));

        minBy               Optional<T>             根据比较器选择最小值
        Optional<Emp> min = list.stream().collect(Collectors.minBy(comparingInt(Employee::getSalary)));

        reducing            归约产生的类型            从一个作为累加器的初始值开始，利用BinaryOperator与流中元素逐个结合，从而归约成单个值
        int total=list.stream().collect(Collectors.reducing(0, Employee::getSalar, Integer::sum));

        collectingAndThen   转换函数返回的类型         包裹另一个收集器，对其结果转换函数
        int how= list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));

        groupingBy          Map<K, List<T>>          根据某属性值对流分组，属性为K，结果为V
        Map<Emp.Status, List<Emp>> map= list.stream().collect(Collectors.groupingBy(Employee::getStatus));

        partitioningBy      Map<Boolean, List<T>>    根据true或false进行分区
        Map<Boolean,List<Emp>> vd = list.stream().collect(Collectors.partitioningBy(Employee::getManage));

    */
    @Test
    public void test4() {

        // 1. collect(Collector c)：将流转换为其他形式。接收一个 Collector 接口的实现，用于给 Stream 中元素做汇总的方法
        // 练习1：查找工资大于 6000 的员工，结果返回为一个 List 或 Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);

        System.out.println();

        Set<Employee> employeeSet = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);

        System.out.println();

        ArrayList<Employee> employeeArrayList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toCollection(ArrayList::new));
        employeeArrayList.forEach(System.out::println);
    }
}
