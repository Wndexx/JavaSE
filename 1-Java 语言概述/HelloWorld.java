// 1

/*
    1. Java 语言的特点

        (1) 面向对象性

            两个要素：类、对象

            三个特征：封装、继承、多态

        (2) 健壮性

            (1) 去除 C 语言中的指针

            (2) 自动的垃圾回收机制 (Garbage Collection)

                     ----->  仍会出现内存溢出、内存泄漏

        (3) 跨平台性

            write once,run anywhere

            原理：JVM，Java Virtual Machine


    2. 开发环境的搭建

        JDK     Java Development Kit        Java 开发工具包

        JRE     Java Runtime Environment    Java 运行环境

        JDK = JRE + 开发工具集 (javac.exe java.exe javadoc.exe)

        JRE = JVM + Java 核心类库

    
    3. 配置环境变量

        PATH 环境变量：windows 操作系统执行命令时搜寻的路径

        目的：任何目录下都可以使用 java 开发工具（javac.exe java.exe）

        方法：

            (1) 新增变量 JAVA_HOME = JDK 安装目录       D:\developer_tools\Java\jdk1.8.0_131

            (2) PATH 变量新增值                         %JAVA_HOME%\bin


    4. API application programming interface  语言提供的类库

*/
class HelloChina{
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
