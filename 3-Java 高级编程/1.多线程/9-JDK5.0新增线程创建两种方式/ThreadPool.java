package com.wndexx.java2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wndexx
 * @create 2022-02-23 11:11
 */
/*
    创建线程的方式四：使用线程池

    背景：经常创建和销毁、使用量特别大的资源，比如并发情况下的线程，对性能影响很大。

    思路：提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中。可以避免频繁创建销毁、实现重复利用。类似生活中的公共交通工具。

    好处：
        (1) 提高响应速度（减少了创建新线程的时间）

        (2) 降低资源消耗（重复利用线程池中线程，不需要每次都创建）

        (3) 便于线程管理

                - corePoolSize：核心池的大小

                - maximumPoolSize：最大线程数

                - keepAliveTime：线程没有任务时最多保持多长时间后会终止

    线程池相关 API:

    JDK 5.0起提供了线程池相关API：ExecutorService 和 Executors

        ExecutorService：真正的线程池接口。

            常见子类 ThreadPoolExecutor

            void execute(Runnable command) ：执行任务/命令，没有返回值，一般用来执行 Runnable

            <T> Future<T> submit(Callable<T> task)：执行任务，有返回值，一般又来执行 Callable

            void shutdown() ：关闭连接池

        Executors：工具类、线程池的工厂类，用于创建并返回不同类型的线程池

            Executors.newCachedThreadPool()：创建一个可根据需要创建新线程的线程池

            Executors.newFixedThreadPool(n); 创建一个可重用固定线程数的线程池

            Executors.newSingleThreadExecutor() ：创建一个只有一个线程的线程池

            Executors.newScheduledThreadPool(n)：创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。

    面试题：创建多线程有几种方式？四种！！

 */
class NumberThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + "：" + i);
        }
    }
}

class NumberThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + "：" + i);
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {

        // 1. 提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        // 设置线程池的属性
        // System.out.println(service.getClass());
        service1.setCorePoolSize(15);
        // service1.setKeepAliveTime();

        // 2. 执行指定的线程的操作。需要提供实现 Runnable 接口或 Callable 接口实现类的对象
        service.execute(new NumberThread());  // 适合使用于 Runnable

        service.execute(new NumberThread1());

        // service.submit(Callable callable); // 适合适用于 Callable

        // 3. 关闭连接池
        service.shutdown();
    }
}
