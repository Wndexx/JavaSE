package com.wndexx.java;

/**
 * @author wndexx
 * @create 2022-02-19 12:43
 */
/*
    例子：创建三个窗口卖票，总票数为 100 张，使用继承 Thread 类的方式

    使用同步代码块解决继承 Thread 类的方式的线程安全问题

 */
class Window2 extends Thread {

    private static int ticket = 100;
    private static Object obj = new Object();

    @Override
    public void run() {
        for (; ; ) {
            // 错误的： synchronized (this) {  此时的 this 代表着 t1，t2，t3 三个对象
            // synchronized (obj) { // 正确的
            synchronized (Window2.class) { // 正确的 类也是对象  Class clazz = Window2.class，Window2.class 只会加载一次
                if (ticket <= 0)
                    break;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(getName() + "：买票，票号为：" + ticket--);
            }
        }
    }
}


public class WindowTest2 {
    public static void main(String[] args) {

        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }
}