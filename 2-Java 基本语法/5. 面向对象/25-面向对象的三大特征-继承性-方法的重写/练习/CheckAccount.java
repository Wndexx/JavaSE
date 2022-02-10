package com.wndexx.exer2;

/*
	创建 Account 类的一个子类 CheckAccount 代表可透支的账户，
	
	该账户中定义一个属性
		overdraft 代表可透支限额。
		
	在 CheckAccount 类中重写 withdraw 方法，其算法如下：
		如果（取款金额<账户余额），可直接取款
		如果（取款金额>账户余额），计算需要透支的额度
		判断可透支额 overdraft 是否足够支付本次透支需要，如果可以将账户余额修改为 0，冲减可透支金额
		如果不可以提示用户超过可透支额的限额
		
	要求：写一个用户程序测试 CheckAccount 类。
	在用户程序中，创建一个账号为 1122、余额为 20000、年利率 4.5%，可透支限额为 5000 元的 CheckAccount 对象。
	使用 withdraw 方法提款 5000 元，并打印账户余额和可透支额。
	再使用 withdraw 方法提款 18000 元，并打印账户余额和可透支额。
	再使用 withdraw 方法提款 3000 元，并打印账户余额和可透支额。
	
 */
public class CheckAccount extends Account {

	private double overdraft; // 可透支限额

	public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft = overdraft;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	@Override
	public void withdraw(double amount) {
		if (amount <= getBalance()) { // 余额足够消费
			// setBalance(getBalance() - amount);
			super.withdraw(amount);
		} else if (amount <= getBalance() + overdraft) { // 透支额度 + 余额足够消费
			overdraft -= amount - getBalance();
			// setBalance(0);
			super.withdraw(getBalance());
		} else {
			System.out.println("超过可透支限额!");
		}
	}

}
