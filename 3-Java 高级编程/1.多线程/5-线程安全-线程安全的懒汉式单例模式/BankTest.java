package com.wndexx.java1;

/**
 * @author wndexx
 * @create 2022-02-19 14:04
 */
/*
    使用同步机制将单例模式中的懒汉式改写为线程安全的
*/
public class BankTest {

}

class Bank {
    private static Bank instance = null;

    private Bank() {

    }

    // 方式一：效率稍差
    /*public static synchronized Bank getInstance() { // 同步监视器：Bank.class
        if (instance == null)
            instance = new Bank();
        return instance;
    }*/

    /*public static Bank getInstance() { // 同步监视器：Bank.class
        synchronized (Bank.class) {
            if (instance == null)
                instance = new Bank();
            return instance;
        }
    }*/

    // 方式二：效率更高
    public static Bank getInstance() { // 同步监视器：Bank.class
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null)
                    instance = new Bank();
            }
        }
        return instance;
    }
}
