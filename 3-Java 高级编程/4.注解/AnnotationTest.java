package com.wndexx.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author wndexx
 * @create 2022-02-27 17:38
 */

/*
    注解的使用

    1. 理解 Annotation

        (1) jdk 5.0 新增的功能

        (2) Annotation 其实就是代码里的特殊标记, 这些标记可以在编译, 类加载, 运行时被读取, 并执行相应的处理。

            通过使用 Annotation, 程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息

        (3) 在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。

            在JavaEE/Android中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。

            框架 = 注解 + 反射 + 设计模式。

    2. Annotation 的使用示例

        示例一：生成文档相关的注解

            @author     标明开发该类模块的作者，多个作者之间使用,分割

            @version    标明该类模块的版本

            @see        参考转向，也就是相关主题

            @since      从哪个版本开始增加的

            @param      对方法中某参数的说明，如果没有参数就不能写

            @return     对方法返回值的说明，如果方法的返回值类型是void就不能写

            @exception  对方法可能抛出的异常进行说明 ，如果方法没有用throws显式抛出的异常就不能写

            其中

                @param @return 和 @exception 这三个标记都是只用于方法的。

                @param 的格式要求：@param 形参名 形参类型 形参说明

                @return 的格式要求：@return 返回值类型 返回值说明

                @exception 的格式要求：@exception 异常类型 异常说明

                @param 和 @exception 可以并列多个

        示例二：在编译时进行格式检查(JDK内置的三个基本注解)

            @Override           限定重写父类方法, 该注解只能用于方法

            @Deprecated         用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择。（仍可以使用，但不推荐）

            @SuppressWarnings   抑制编译器警告

        示例三：跟踪代码依赖性，实现替代配置文件功能

            - Servlet3.0 提供了注解(annotation)，使得不再需要在 web.xml 文件中进行 Servlet 的部署

            - spring框架中关于 "事务" 的管理

            - ...

    3. 如何自定义注解：参照 @SuppressWarnings 定义

        (1) 注解声明为：@interface

        (2) 内部定义成员，通常使用 value 表示

        (3) 可以指定成员的默认值，使用 default 定义

        (4) 如果自定义的注解没有成员，表明是一个标识作用

        如果注解有成员，在使用注解时，需要指明成员的值

        自定义注解必须配上注解的信息处理流程（使用反射）才有意义

        自定义注解通常都会指明两个元注解：Retention、Target

    4. jdk 提供的 4 种元注解

       元注解：对现有的注解进行解释说明的注解

        Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS(默认行为)\RUNTIME

            只有声明为 RUNTIME 生命周期的注解，才能通过反射获取

        Target：用于指定被修饰的 Annotation 能用于修饰哪些程序元素

        *********************出现的频率较低*****************************

        Documented：表示所修饰的注解在被 javadoc 解析时，保留下来

            - 定义为 Documented 的注解必须设置 Retention 值为 RUNTIME。

        Inherited：被它修饰的 Annotation 将具有继承性。如果某个类使用了被 @Inherited 修饰的 Annotation, 则其子类将自动具有该注解

    5. 通过反射获取注解信息
	
		前提：要求此注解的元注解 Retention 中声明的生命周期状态为 ：RUNTIME

    6. jdk 8 中注解的新特性：可重复注解、类型注解

        (1) 可重复注解：

            - 在 MyAnnotation 上声明 @Repeatable，成员值为 MyAnnotations.class

            - MyAnnotation 的 Target 、Retention、Inherited等元注解与 MyAnnotations 相同

        (2) 类型注解：

            - ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。

            - ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中

*/
public class AnnotationTest {
    public static void main(String[] args) {

        Person p = new Person();
        p.walk();

        Date date = new Date(2020, 10, 11);
        System.out.println(date); // Thu Nov 11 00:00:00 CST 3920

        @SuppressWarnings("unused")
        int num = 10;
        // System.out.println(num);

        @SuppressWarnings({"unused", "rawtypes"})
        ArrayList list = new ArrayList();
    }

    @Test
    public void testAnnotation() {
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]); // @com.wndexx.java1.MyAnnotation(value=hi)
        }
    }
}

// jdk 8 之前的写法
// @MyAnnotations({@MyAnnotation(value = "hi"), @MyAnnotation(value = "abc")})
@MyAnnotation(value = "hi")
@MyAnnotation(value = "abc")
class Person {

    private String name;
    private int age;

    public Person() {
    }

    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    public void walk() {
        System.out.println("人走路");
    }

    public void eat() {
        System.out.println("人吃饭");
    }
}

interface Info {
    void show();
}

class Student extends Person implements Info {

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}

class Generic<@MyAnnotation T> {

    public void show() throws @MyAnnotation RuntimeException {

        ArrayList<@MyAnnotation String> list = new ArrayList<>();

        int num = (@MyAnnotation int) 10L;
    }
}