package com.wndexx.exer3;

public class Account {

	private int id; // 账号
	private double balance; // 余额
	private double annualInterestRate; // 年利率

	public Account() {

	}

	public Account(int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRatee(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	/**
	 * 
	 * @Description 取钱
	 * @author wndexx
	 * @date 2022年2月8日上午11:07:36
	 * @param account
	 *
	 */
	// 在提款方法 withdraw 中，需要判断用户余额是否能够满足提款数额的要求，如果不能，应给出提示
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
