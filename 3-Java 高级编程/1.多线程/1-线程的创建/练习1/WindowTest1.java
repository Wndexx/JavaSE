package com.wndexx.java;

/**
 * 例子：创建三个窗口买票，总票数为 100 张，使用实现 Runnable 接口的方式
 *
 * 存在线程的安全问题，待解决
 *
 * @author wndexx
 * @create 2022-02-18 13:30
 */
class Window1 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        for (; ; ) {
            if (ticket <= 0)
                break;
            System.out.println(Thread.currentThread().getName() + "买票，票号为：" + ticket--);
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {

        Window1 window1 = new Window1();

        Thread t1 = new Thread(window1);
        Thread t2 = new Thread(window1);
        Thread t3 = new Thread(window1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}
