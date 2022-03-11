package com.wndexx.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author wndexx
 * @create 2022-03-10 15:26
 */
/*
    了解类的加载器
*/
public class ClassLoaderTest {

    @Test
    public void test1() {

        // 对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader); // sun.misc.Launcher$AppClassLoader@18b4aac2 系统类加载器

        // 调用系统类加载器的 getParent()：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1); // sun.misc.Launcher$ExtClassLoader@27716f4 扩展类加载器

        // 调用扩展类加载器的 getParent()：无法获取引导类加载器
        // 引导类加载器主要负责加载 java 的核心类库，无法加载自定义类的
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2); // null 引导类加载器，但我们无法直接获取到

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3); // null
    }

    /*
        Properties：用来读取配置文件
    */
    @Test
    public void test2() throws IOException {

        Properties pros = new Properties();

        // 读取配置文件的方式一：
        // 此时的文件默认在当前的 module 下
        // FileInputStream fis = new FileInputStream("jdbc.properties");
        FileInputStream fis = new FileInputStream("src\\jdbc1.properties");
        pros.load(fis);

        // 读取配置文件的方式二：使用 Classloader
        // 配置文件默认识别为：当前 module 的 src 下
        // ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        // pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");

        System.out.println("user = " + user + ", password = " + password); // user = 张三, password = abc123

    }

    public static void main(String[] args) {
        System.out.println(A.m); // 100
    }
}

class A {
    static {
        m = 300;
    }

    static int m = 100;
}
//第二步：链接结束后 m=0
//第三步：初始化后，m 的值由<clinit>()方法执行决定
// 这个A的类构造器<clinit>()方法由类变量的赋值和静态代码块中的语句按照顺序合并产生，类似于
// <clinit>(){
// m = 300;
// m = 100;
// }
