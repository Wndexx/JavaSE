package com.wndexx.java;

/**
 * 
创建多线程的方式二：实现 Runnable 接口

	1. 创建一个实现了 Runnable 接口的类
	
	2. 实现类去实现 Runnable 中的抽象方法：run()
	
	3. 创建实现类的对象
	
	4. 将此对象作为参数传递到 Thread 类的构造器中，创建 Thread 类的对象
	
	5. 通过 Thread 类的对象调用 start()

比较创建线程的两种方式：

	开发中：优先选择实现 Runnable 接口的方式
	
	原因：1. 实现的方式没有类的单继承性的局限性
	
		 2. 实现的方式更适合处理多个线程有共享数据的情况

	联系：public class Thread implements Runnable
	
	相同点：两种方式都需要重写 run()，将线程要执行的逻辑声明在 run() 中
	
			目前两种方式，要想启动线程，都是调用的 Thread 类中的 start() 方法

*/
// 1. 创建一个实现了 Runnable 接口的类
class MThread implements Runnable{

    // 2. 实现类去实现 Runnable 中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}
public class ThreadTest1 {
    public static void main(String[] args) {

        // 3. 创建实现类的对象
        MThread mThread = new MThread();

        // 4. 将此对象作为参数传递到 Thread 类的构造器中，创建 Thread 类的对象
        Thread t1 = new Thread(mThread);

        t1.setName("线程1");

        // 5. 通过 Thread 类的对象调用 start()：启动线程；调用当前线程的 run() ---> 调用了 Runnable 类型的 target 的 run()
        t1.start();

        // 再启动一个线程，遍历 100 以内的偶数
        Thread t2 = new Thread(mThread);
        t2.setName("线程2");
        t2.start();
    }
}
