package com.wndexx.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常用类的使用
 * 1. System
 * 2. Math
 * 3. BigInteger 和 BigDecimal
 *
 * @author wndexx
 * @create 2022-02-27 9:44
 */
public class OtherClassTest {
    /*
        System 类代表系统，系统级的很多属性和控制方法都放置在该类的内部。该类位于 java.lang 包

        由于该类的构造器是 private 的，所以无法创建该类的对象，也就是无法实例化该类。其内部的成员变量和成员方法都是 static 的，所以也可以很方便的进行调用。

        成员变量

            System 类内部包含 in、ou t和 err 三个成员变量，分别代表标准输入流(键盘输入)，标准输出流(显示器)和标准错误输出流(显示器)。

        成员方法

            native long currentTimeMillis()：

                该方法的作用是返回当前的计算机时间，时间的表达格式为当前计算机时间和 GMT 时间(格林威治时间) 1970 年 1 月 1 号 0 时 0 分 0 秒所差的毫秒数。

            void exit(int status)：

                该方法的作用是退出程序。其中 status 的值为0代表正常退出，非零代表异常退出。使用该方法可以在图形界面编程中实现程序的退出功能等。

            void gc()：

                该方法的作用是请求系统进行垃圾回收。至于系统是否立刻回收，则取决于系统中垃圾回收算法的实现以及系统执行时的情况。

            String getProperty(String key)：

                该方法的作用是获得系统中属性名为key的属性对应的值。系统中常见的属性名以及属性的作用如下表所示：

                    属性名             属性说明

                    java.version    Java 运行时环境版本

                    java.home       Java 安装目录

                    os.name         操作系统的名称

                    os.version      操作系统的版本

                    user.name       用户的账户名称

                    user.home       用户的主目录

                    user.dir        用户的当前工作目录
    */
    @Test
    public void test1() {

        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version:" + javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java的home:" + javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os的name:" + osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version:" + osVersion);

        String userName = System.getProperty("user.name");
        System.out.println("user的name:" + userName);

        String userHome = System.getProperty("user.home");
        System.out.println("user的home:" + userHome);

        String userDir = System.getProperty("user.dir");
        System.out.println("user的dir:" + userDir);
    }

    /*
        java.lang.Math 提供了一系列 静态方法 用于科学计算。其方法的参数和返回值类型一般为 double 型。

            abs                         绝对值

            acos\asin\atan\cos\sin\tan  三角函数

            sqrt                        平方根

            pow(double a, double b)     a 的 b 次幂

            log                         自然对数

            exp e为底指数

            max(double a, double b)

            min(double a, double b)

            random()                    返回 0.0 到 1.0 的随机数

            long round(double a)        double 型数据 a 转换为 long 型（四舍五入）

            toDegrees(double angrad)    弧度—>角度

            toRadians(double angdeg)    角度—>弧度
    */

    /*
        Integer 类作为 int 的包装类，能存储的最大整型值为2^31-1，Long 类也是有限的，最大为2^63-1。如果要表示再大的整数，不管是基本数据类型还是他们的包装类都无能为力，更不用说进行运算了

        java.math 包的 BigInteger 可以表示不可变的任意精度的整数

        构造器

            BigInteger(String val)：根据字符串构建 BigInteger 对象

        常用方法

            public BigInteger abs()：返回此 BigInteger 的绝对值的 BigInteger。

            BigInteger add(BigInteger val) ：返回其值为 (this + val) 的 BigInteger

            BigInteger subtract(BigInteger val) ：返回其值为 (this - val) 的 BigInteger

            BigInteger multiply(BigInteger val) ：返回其值为 (this * val) 的 BigInteger

            BigInteger divide(BigInteger val) ：返回其值为 (this / val) 的 BigInteger。整数相除只保留整数部分。

            BigInteger remainder(BigInteger val) ：返回其值为 (this % val) 的 BigInteger。

            BigInteger[] divideAndRemainder(BigInteger val)：返回包含 (this / val) 后跟(this % val) 的两个 BigInteger 的数组。

            BigInteger pow(int exponent) ：返回其值为 (this^exponent) 的 BigInteger


        一般的 Float 类和 Double 类可以用来做科学计算或工程计算，但在商业计算中，要求数字精度比较高，故用到 java.math.BigDecimal 类。

        BigDecimal 类支持不可变的、任意精度的有符号十进制定点数。

        构造器

            public BigDecimal(double val)

            public BigDecimal(String val)

        常用方法

            public BigDecimal add(BigDecimal augend)

            public BigDecimal subtract(BigDecimal subtrahend)

            public BigDecimal multiply(BigDecimal multiplicand)

            public BigDecimal divide(BigDecimal divisor, int scale, int roundingMode)
    */
    @Test
    public void testBigInteger() {

        BigInteger bi = new BigInteger("124332123333333333333333333321111111111114567841123");

        BigDecimal bd = new BigDecimal("12435.351");
        BigDecimal bd2 = new BigDecimal("11");

        System.out.println(bi); // 124332123333333333333333333321111111111114567841123

        // System.out.println(bd.divide(bd2)); // 如果除不尽，会报错
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP)); // 1130.486
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP)); // 1130.486454545454545 支持任意精度
    }

}
