package com.wndexx.java2;

/**
 * 线程通信的例子：使用两个线程打印 1 - 100，线程1，线程2 交替打印
 *
 * @author wndexx
 * @create 2022-02-19 18:02
 */

/*
    涉及到的三个方法：

        wait()

            - 一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器

        notify()

            - 一旦执行此方法，就会唤醒被 wait 的一个线程。如果有多个线程被 wait，就唤醒优先级高的哪个

        notifyAll()

            - 一旦执行此方法，就会唤醒所有被 wait 的线程。

    说明：

        1. wait()、notify()、notifyAll() 三个方法必须使用在同步代码块或同步方法中。lock 方法不行

        2. wait()、notify()、notifyAll() 三个方法的调用者必须是同步代码块或同步方法中的同步监视器

            否则，会出现 IllegalMonitorStateException 异常

        3.  wait()、notify()、notifyAll() 三个方法是定义在 java.lang.Object 类中


    面试题：sleep() 和 wait() 的异同？

    1. 相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态

    2. 不同点：(1) 两个方法声明的位置不同：Thread 类中声明 sleep()，Object() 类中声明的 wait()

              (2) 调用的要求不同：sleep() 可以在任何需要的场景下调用，wait() 必须使用在同步代码块或同步方法中

              (3) 关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep() 不会释放锁，wait() 会释放锁


	释放锁的操作：
	
		- 当前线程的同步方法、同步代码块执行结束。
		
		- 当前线程在同步代码块、同步方法中遇到 break 、return 终止了该代码块、该方法的继续执行。
		
		- 当前线程在同步代码块、同步方法中出现了未处理的 Error 或 Exception ，导致异常结束。
		
		- 当前线程在同步代码块、同步方法中执行了线程对象的 wait() 方法，当前线程暂停，并释放锁
		
	不会释放锁的操作：
	
		- 线程执行同步代码块或同步方法时，程序调用 Thread.sleep() 、Thread.yield() 方法暂停当前线程的执行
		
		- 线程执行同步代码块时，其他线程调用了该线程的 suspend() 方法将该线程挂起，该线程不会释放锁（同步监视器）。
		
			- 应尽量避免使用 suspend() 和 resume() 来控制线程
	
	
*/
class Number implements Runnable {
    private int number = 1;
    private Object obj = new Object();
    @Override
    public void run() {
        for (; ; ) {
             synchronized (obj) {  // IllegalMonitorStateException
                 obj.notify();
                if (number > 100)
                    break;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":" + number++);
                try {
                    // 使得调用如下 wait() 方法的线程进入阻塞状态，同时释放同步监视器(锁)
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class CommunicationTest {
    public static void main(String[] args) {

        Number number = new Number();

        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();
    }
}
