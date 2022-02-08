package com.wndexx.exer4;

public class Account {

	private double balance;

	public Account(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	/**
	 * 
	 * @Description 取钱
	 * @author wndexx
	 * @date 2022年2月8日上午11:07:36
	 * @param account
	 *
	 */
	public void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("余额不足，取款失败");
			return;
		}
		balance -= amount;
		System.out.println("成功取出：" + amount);
	}

	/**
	 * 
	 * @Description 存钱
	 * @author wndexx
	 * @date 2022年2月8日上午11:08:26
	 * @param amount
	 *
	 */
	public void deposit(double amount) {
		if (amount < 0) {
			System.out.println("请输入正确数额");
			return;
		}
		balance += amount;
		System.out.println("成功存入：" + amount);
	}
}
