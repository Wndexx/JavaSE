package com.wndexx.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wndexx
 * @create 2022-03-10 9:55
 */
public class RefectionTest {

    // 反射之前，对于 Person 的操作
    @Test
    public void test1() {

        // 1. 创建 Person 类的对象
        Person p1 = new Person("Tom", 12);

        // 2. 通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1);

        p1.show();

        // 在 Person 类外部，不可以通过 Person 类的对象调用其内部私有结构
        // 比如：私有的属性（name）、私有的方法（showNation()）以及私有的构造器
    }

    /*
        相关 API:
            
            java.lang.Class：反射的源头

            java.lang.reflect.Method

            java.lang.reflect.Field

            java.lang.reflect.Constructor

            ...


        Java反射机制提供的功能

            在运行时判断任意一个对象所属的类

            在运行时构造任意一个类的对象

            在运行时判断任意一个类所具有的成员变量和方法

            在运行时获取泛型信息

            在运行时调用任意一个对象的成员变量和方法

            在运行时处理注解

            生成动态代理
            
    */
    // 反射之后，对于 Person 的操作
    @Test
    public void test2() throws Exception {

        Class clazz = Person.class;

        // 1. 通过反射，创建 Person 类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);

        Object obj = cons.newInstance("Tom", 12);
        System.out.println(obj); // Person p = ()

        Person p = (Person) obj;
        System.out.println(p);

        // 2. 通过反射，调用对象指定的属性、方法
        // 调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p); // Person{name='Tom', age=10}

        // 调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p); // 你好，我是一个人

        System.out.println("*******************************");

        // 通过反射，可以调用 Person 类的私有结构。比如：私有的构造器、方法、属性
        // 调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1); // Person{name='Jerry', age=0}

        // 调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Jack");
        System.out.println(p1); // Person{name='Jack', age=0}

        // 调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国"); // 相当于 String nation = p1.showNation("中国") 我的国籍是：中国
        System.out.println(nation); // 中国
    }

    // 疑问1：通过直接 new 的方式或反射的方式都可以调用公共的结构，开发中到底用哪个？
    // 建议：直接 new 的方式。
    // 什么时候会使用：反射的方式。反射的特征：动态性

    // 疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    // 不矛盾。

    /*
        关于 java.lang.Class 类的理解

        1. 类的加载过程：

            程序在经过 javac.exe 命令以后，会生成一个或多个字节码文件(.class 结尾)。

            接着我们使用 java.exe 命令对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中。此过程就称为类的加载。

            加载到内存中的类，我们就称为运行时类，此运行时类，就作为 Class 的一个实例

       2. 换句话说，Class 的实例就对应着一个运行时类。

            加载到内存中的运行时类，会缓存一定的时间，再次时间之内，我们可以通过不同的方式来获取此运行时类

    */
    /*
        获取 Class 的实例的方式（前三种方式需要掌握）
    */
    @Test
    public void test3() throws ClassNotFoundException {

        // 方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1); // class com.wndexx.java.Person

        // 方式二：通过运行时类的对象，调用 getClass()
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2); // class com.wndexx.java.Person

        // 方式三：调用 Class 的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.wndexx.java.Person");
        // clazz3 = Class.forName("java.lang.String");
        System.out.println(clazz3); // class com.wndexx.java.Person

        System.out.println(clazz1 == clazz2); // true
        System.out.println(clazz1 == clazz3); // true

        // 方式四：使用类的加载器：ClassLoader（了解）
        ClassLoader classLoader = RefectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.wndexx.java.Person");
        System.out.println(clazz4); // class com.wndexx.java.Person

        System.out.println(clazz1 == clazz4); // true
    }

    // 万事万物皆对象？对象.xxx，File，URL，反射，前端、数据库操作


    /*
        总结：创建类的对象的方式？

            方式一：new + 构造器

            方式二：要创建 Xxx 类的对象，可以考虑：Xxx、Xxxs、XxxFactory、XxxBuilder 类中查看是否有静态方法的存在。可以调用其静态方法，创建 Xxx 对象

            方式三：通过反射
        
    */

    /*
        哪些类型可以有Class对象？

            （1）class：

                外部类，成员(成员内部类，静态内部类)，局部内部类，匿名内部类

            （2）interface：接口

            （3）[]：数组

            （4）enum：枚举

            （5）annotation：注解 @interface

            （6）primitive type：基本数据类型

        （7）void

    */
    // Class 实例可以是哪些结构的说明：
    @Test
    public void test4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组的元素类型与维度一样，就是同一个Class
        System.out.println(c10 == c11); // true
    }


}
