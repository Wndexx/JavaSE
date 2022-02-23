package com.wndexx.exer;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行有一个账户，有两个储户分别向同一个账户存 3000 元，每次存 1000，存 3 次，每次存完打印账户余额
 *
 * 分析:
 * 1. 是否是多线程的问题？ 是，两个储户线程
 * 2. 是否有共享数据？ 有，账户（或账户余额）
 * 3. 是否有线程安全问题？有
 * 4. 需要考虑如何解决线程安全问题？同步机制：有三种方式
 *
 * @author wndexx
 * @create 2022-02-19 16:02
 */

class AddBalance implements Runnable {

    private int balance = 0;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            try {
                lock.lock();
                if (balance >= 3000)
                    break;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                balance += 1000;
                System.out.println(Thread.currentThread().getName() + "存钱后，余额：" + balance);
            } finally {
                lock.unlock();
            }
        }
    }
}

public class AccountTest {

    public static void main(String[] args) {

        AddBalance add = new AddBalance();

        Thread t1 = new Thread(add);
        Thread t2 = new Thread(add);

        t1.setName("储户1");
        t2.setName("储户2");

        t1.start();
        t2.start();
    }
}


