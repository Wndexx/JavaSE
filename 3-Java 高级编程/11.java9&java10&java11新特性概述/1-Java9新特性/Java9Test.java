package com.wndexx.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author wndexx
 * @create 2022-03-14 19:42
 */
/*
    Java 9 的新特性:

        1. JDK 和 JRE 目录结构的改变

            JDK 8 的目录结构：

                bin 目录          包含命令行开发和调试工具，如 javac，jar 和 javadoc。

                include 目录      包含在编译本地代码时使用的 C/C++ 头文件

                lib 目录          包含 JDK 工具的几个 JAR 和其他类型的文件。 它有一个 tools.jar 文件，其中包含 javac 编译器的 Java 类

                jre/bin 目录      包含基本命令，如 java 命令。 在 Windows 平台上，它包含系统的运行时动态链接库（DLL）。

                jre/lib 目录      包含用户可编辑的配置文件，如 .properties 和 .policy 文件。包含几个 JAR。rt.jar 文件包含运行时的 Java 类和资源文件


            JDK 9 的目录结构:

                没有名为 jre 的子目录

                bin 目录          包含所有命令。 在 Windows 平台上，它继续包含系统的运行时动态链接库。

                conf 目录         包含用户可编辑的配置文件，例如以前位于 jre\lib 目录中的 .properties 和 .policy 文件

                include 目录      包含要在以前编译本地代码时使用的 C/C++ 头文件。 它只存在于 JDK 中

                jmods 目录        包含 JMOD 格式的平台模块。 创建自定义运行时映像时需要它。 它只存在于 JDK 中

                legal 目录        包含法律声明

                lib 目录          包含非 Windows 平台上的动态链接本地库。 其子目录和文件不应由开发人员直接编辑或使用


        2. 模块化系统: Jigsaw -> Modularity

            模块(module)的概念，其实就是 package 外再裹一层，不声明默就是隐藏。因此，模块化使得代码组织上更安全，因为它可以指定哪些部分可以暴露，哪些部分隐藏。

            实现目标

                模块化的主要目的在于减少内存的开销

                只须必要模块，而非全部 jdk 模块，可简化各种类库和大型应用的开发和维护

                改进 Java SE 平台，使其可以适应不同大小的计算设备

                改进其安全性，可维护性，提高性能

            模块将由通常的类和新的模块声明文件（module-info.java）组成。

            该文件是位于 java 代码结构的顶层，该模块描述符明确地定义了我们的模块需要什么依赖关系，以及哪些模块被外部使用。

            在 exports 子句中未提及的所有包默认情况下将封装在模块中，不能在外部使用。

            exports：控制着哪些包可以被其它模块访问到。所有不被导出的包默认都被封装在模块里面。

            requires：指明对其它模块的依赖。

        3. Java的 REPL 工具： jShell 命令

            交互式编程环境 REPL (read - evaluate - print - loop)了，以交互式的方式对语句和表达式进行求值

        4. 语法改进：接口的私有方法

        5. 语法改进：钻石操作符使用升级

            能够与匿名实现类共同使用钻石操作符（diamond operator）

        6. 语法改进：try 语句

            Java 8 中，可以实现资源的自动关闭，但是要求执行后必须关闭的所有资源必须在 try 子句中初始化，否则编译不通过

            Java 9 中，用资源语句编写 try 将更容易，我们可以在 try 子句中使用已经初始化过的资源，此时的资源是 final 的

        7. String 存储结构变更

*/
public class Java9Test {

    @Test
    public void test1() {
        try {
            URL url = new URL("https://www.baidu.com");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    // java 9 特性五：钻石操作符的升级
    @Test
    public void test2() {

        // 钻石操作符与匿名内部类在 java 8 中不能共存，在 java 9 可以
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        // jdk 7 中的新特性：类型推断
        ArrayList<String> list = new ArrayList<>();
    }

    // java9 特性六：try 操作的升级
    public static void main(String[] args) {

        // java 8 之前的资源关闭操作
        // InputStreamReader isr = null;
        // try {
        //     isr = new InputStreamReader(System.in);
        //     char[] cbuf = new char[20];
        //     int len;
        //     if ((len = isr.read(cbuf)) != -1) {
        //         String str = new String(cbuf, 0, len);
        //         System.out.println(str);
        //         System.out.println(1);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // } finally {
        //     try {
        //         if (isr != null)
        //             isr.close();
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        // }

        // java 8 中的资源关闭操作：Java 8 中，可以实现资源的自动关闭
        // 要求自动关闭的资源实例化必须放在 try 的一对小括号中
        // try (InputStreamReader isr = new InputStreamReader(System.in)) {
        //     char[] cbuf = new char[20];
        //     int len;
        //     if ((len = isr.read(cbuf)) != -1) {
        //         String str = new String(cbuf, 0, len);
        //         System.out.println(str);
        //         System.out.println(1);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // java 9 中资源的关闭操作
        // 需要自动关闭的资源的实例化可以放在 try 的一对小括号外
        // 此时的资源属性是常量，声明为 final 的，不可修改
        InputStreamReader isr = new InputStreamReader(System.in);
        try (isr) {
            char[] cbuf = new char[20];
            int len;
            if ((len = isr.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.println(str);
                System.out.println(1);
            }
            // isr = null; // Variable used as a try-with-resources resource should be final or effectively final
        } catch (IOException e) {
            e.printStackTrace();
        }

        // InputStreamReader reader = new InputStreamReader(System.in);
        // OutputStreamWriter writer = new OutputStreamWriter(System.out);
        // try (reader; writer) {
        //     //reader是final的，不可再被赋值
        //     //reader = null;
        //     //具体读写操作省略
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

    }
}
