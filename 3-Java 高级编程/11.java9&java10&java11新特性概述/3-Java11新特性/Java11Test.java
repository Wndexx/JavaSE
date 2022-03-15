package com.wndexx.java2;

import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author wndexx
 * @create 2022-03-15 12:15
 */
public class Java11Test {

    // java 11 新特性一：String 中新增的方法
    /*
        描述                      举例

        判断字符串是否为空白       " ".isBlank(); // true

        去除首尾空白              " Javastack ".strip(); // "Javastack"

        去除尾部空格              " Javastack ".stripTrailing(); // " Javastack"

        去除首部空格              " Javastack ".stripLeading(); // "Javastack "

        复制字符串                "Java".repeat(3);// "JavaJavaJava"

        行数统计                 "A\nB\nC".lines().count(); // 3

    */
    @Test
    public void test1() {
        // 1. isBlank()：判断字符串是否为空白
        System.out.println("       ".isBlank()); // true
        System.out.println("   \t \t \n     ".isBlank()); // true  制表符、换行符、回车符也去掉

        // 2. strip()：去除首尾空白
        System.out.println("--------" + "   \t abc \t \n     ".strip() + "-------------"); // --------abc-------------

        // 3. stripTrailing()：去除尾部空格
        System.out.println("--------" + "   \t abc \t \n     ".stripTrailing() + "-------------"); // --------   	 abc-------------

        // 4. stripLeading()：去除首部空格
        System.out.println("--------" + "   \t abc \t \n     ".stripLeading() + "-------------");

        // 5. repeat(int count)：复制字符串
        String str1 = "abc";
        String str2 = str1.repeat(5);
        System.out.println(str2); // abcabcabcabcabc

        // 6. lines().count()：行数统计
        String str3 = "abc\nd\nefg";
        System.out.println(str3.lines().count()); // 3

    }


    // java 11 新特性二：Optional 加强
    /*
        新增方法                                                            描述                                                          新增的版本

        boolean isEmpty()                                                   判断value是否为空                                               JDK 11

        ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)   value非空，执行参数1功能；如果value为空，执行参数2功能             JDK 9

        Optional<T> or(Supplier<? extends Optional<? extends T>> supplier)  value非空，返回对应的Optional；value为空，返回形参封装的Optional   JDK 9

        Stream<T> stream()                                                  value非空，返回仅包含此value的Stream；否则，返回一个空的Stream      JDK 9

        T orElseThrow()                                                     value非空，返回value；否则抛异常NoSuchElementException             JDK 10
    */
    @Test
    public void test2() {

        var op = Optional.empty();
        System.out.println(op.isPresent()); // false // 判断内部的 value 是否存在
        System.out.println(op.isEmpty()); // true // 判断内部的 value 是否为空

        op = Optional.of("abc");
        // orElseThrow()：value非空，返回value；否则抛异常NoSuchElementException
        var o = op.orElseThrow();
        System.out.println(o);

        op = Optional.empty();
        // or：value非空，返回对应的Optional；value为空，返回形参封装的Optional
        Optional<String> op1 = Optional.of("hello");
        Optional<Object> op2 = op.or(() -> op1);
        System.out.println(op2);

    }

    // java 11 新特性三：局部变量类型推断升级
    /*
        在 var 上添加注解的语法格式，在 jdk10 中是不能实现的。在 jdk11 中加入了这样的语法。
    */
    @Test
    public void test3() {
        //错误的形式: 必须要有类型, 可以加上 var
        //Consumer<String> con1 = (@Deprecated t) ->System.out.println(t.toUpperCase());

        //正确的形式:
        //使用 va r的好处是在使用 lambda 表达式时给参数加上注解。
        Consumer<String> con2 = (@Deprecated var t) -> System.out.println(t.toUpperCase());
    }

    // java 11 新特性四：全新的 HTTP 客户端 API ：HttpClient 替换原有的 HttpURLConnection
    @Test
    public void test4() {
        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();

            HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = client.send(request, responseBodyHandler);

            String body = response.body();
            System.out.println(body);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test5() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create("http://127.0.0.1:8080/test/")).build();
        HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
        CompletableFuture<HttpResponse<String>> sendAsync = client.sendAsync(request, responseBodyHandler);
        sendAsync.thenApply(t -> t.body()).thenAccept(System.out::println);
        //HttpResponse<String> response = sendAsync.get();
        //String body = response.body();
        //System.out.println(body);
    }

    // java 11 新特性五：更简化的编译运行程序
    /*
        在我们的认知里面，要运行一个 Java 源代码必须先编译，再运行，两步执行动作。而在未来的 Java 11 版本中，通过一个 java 命令就直接搞定了，如以下所示：

            java Javastack.java

        一个命令编译运行源代码的注意点：

            执行源文件中的第一个类, 第一个类必须包含主方法。

            并且不可以使用其它源文件中的自定义类, 本文件中的自定义类是可以使用的
    */

    // java 11 新特性六：废弃 Nashorn 引擎

    // java 11 新特性七：ZGC
    /*
        ZGC, A Scalable Low-Latency Garbage Collector(Experimental) ZGC, 这应该是JDK11最为瞩目的特性, 没有之一

        ZGC 是一个并发, 基于 region, 压缩型的垃圾收集器, 只有 root 扫描阶段会 STW(stop the world), 因此 GC 停顿时间不会随着堆的增长和存活对象的增长而变长。

        优势：

            GC 暂停时间不会超过 10 ms

            既能处理几百兆的小堆, 也能处理几个 T 的大堆(OMG)

            和 G1 相比, 应用吞吐能力不会下降超过15%

            为未来的 GC 功能和利用 colord 指针以及 Load barriers 优化奠定基础

            初始只支持64位系统

        ZGC的设计目标是：支持TB级内存容量，暂停时间低（<10ms），对整个程序吞吐量的影响小于15%。

        将来还可以扩展实现机制，以支持不少令人兴奋的功能，例如多层堆（即热对象置于DRAM和冷对象置于NVMe闪存），或压缩堆
    */

    // 其它新特性
    /*
        Unicode 10

        Deprecate the Pack200 Tools and API

        新的 Epsilon 垃圾收集器

        完全支持 Linux 容器（包括 Docker）

        支持 G1 上的并行完全垃圾收集

        最新的 HTTPS 安全协议 TLS 1.3

        Java Flight Recorder
    */

}
