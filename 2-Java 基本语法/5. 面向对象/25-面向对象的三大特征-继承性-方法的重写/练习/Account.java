package com.wndexx.exer2;

/*
	写一个名为 Account 的类模拟账户。该类的属性和方法如下图所示。
	
	该类包括的属性：
		账号 id，
		余额 balance，
		年利率 annualInterestRate；
		
	包含的方法：
		访问器方法（getter 和setter 方法），
		返回月利率的方法 getMonthlyInterest()，
		取款方法 withdraw()，
		存款方法deposit()。
		
		Account
		private int id
		private double balance
		private double annualInterestRate
		
		public Account (int id, double balance, double annualInterestRate )
		public int getId()
		public double getBalance()
		public double getAnnualInterestRate()
		public void setId( int id)
		public void setBalance(double balance)
		public void setAnnualInterestRate(double annualInterestRate)
		public double getMonthlyInterest()
		public void withdraw (double amount)
		public void deposit (double amount)
		
	写一个用户程序测试 Account 类。
	在用户程序中，创建一个账号为 1122、余额为 20000、年利率 4.5%的 Account 对象。
	使用 withdraw 方法提款 30000 元，并打印余额。
	再使用 withdraw 方法提款 2500 元，使用 deposit 方法存款 3000 元，然后打印余额和月利
*/
public class Account {
	
	private int id; // 账户
	private double balance; // 余额
	private double annualInterestRate; // 年利率

	public Account(int id, double balance, double annualInterestRate) {
		super();
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

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	/**
	 * @Description 返回月利率
	 * @author wndexx
	 * @date 2022年2月10日下午2:12:35
	 * @return
	 */
	public double getMonthlyInterest() {
		return annualInterestRate / 12;
	}

	/**
	 * @Description 取款
	 * @author wndexx
	 * @date 2022年2月10日下午2:13:20
	 * @param amount
	 */
	public void withdraw(double amount) {
		if(amount < 0) {
			System.out.println("请输出正确金额");
			return;
		}
		if(amount > balance) {
			System.out.println("余额不足");
			return;
		}
		balance -= amount;
	}

	/**
	 * @Description 取款
	 * @author wndexx
	 * @date 2022年2月10日下午2:13:55
	 * @param amount
	 */
	public void deposit(double amount) {
		if(amount < 0) {
			System.out.println("请输出正确金额");
			return;
		}
		balance += amount;
	}

}
