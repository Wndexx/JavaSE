package com.wndexx.java;

/**
 * @author wndexx
 * @create 2022-02-19 13:18
 */
/*
    使用同步方法解决实现 Runnable 接口的线程安全问题
 */
class Window3 implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        for (; ; ) {
            show();
        }
    }

    private synchronized void show() { // 同步监视器：this
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket--);
        }
    }
}

public class WindowTest3 {
    public static void main(String[] args) {

        Window3 window3 = new Window3();

        Thread t1 = new Thread(window3);
        Thread t2 = new Thread(window3);
        Thread t3 = new Thread(window3);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
