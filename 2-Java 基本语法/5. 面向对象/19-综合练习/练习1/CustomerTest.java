package com.wndexx.exer3;

/*
	写一个名为 Account 的类模拟账户。该类的属性和方法如下图所示。该类包括的属性：
	账号 id，余额 balance，年利率 annualInterestRate；包含的方法：访问器方法（getter 和 setter
	方法），取款方法 withdraw()，存款方法 deposit()。
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
		public void withdraw (double amount)//取钱
		public void deposit (double amount)//存钱
		提示：在提款方法 withdraw 中，需要判断用户余额是否能够满足提款数额的要求，如果不
		能，应给出提示。
	2. 创建 Customer 类。
		Customer
		private String firstName
		private String lastName
		private Account account
		public Customer(String f,String l)
		public String getFirstName()
		public String getLastName()
		public Account getAccount()
		public void setAccount(Account account)
		a. 声明三个私有对象属性：firstName、lastName 和 account。
		b. 声明一个公有构造器，这个构造器带有两个代表对象属性的参数（f 和 l）
		c. 声明两个公有存取器来访问该对象属性，方法 getFirstName 和 getLastName 返回相应的属
		性。
		d. 声明 setAccount 方法来对 account 属性赋值。
		e. 声明 getAccount 方法以获取 account 属性。
	3.写一个测试程序。
	（1） 创建一个 Customer ，名字叫 Jane Smith, 他有一个账号为 1000，余额为 2000 元，
		年利率为 1.23％ 的账户。
	（2） 对 Jane Smith 操作。
		存入 100 元，再取出 960 元。再取出 2000 元。
		打印出 Jane Smith 的基本信息
		成功存入 ：100.0
		成功取出：960.0
		余额不足，取款失败
		Customer [Smith, Jane] has a account: id is 1000, annualInterestRate is 1.23％, balance is
		1140.0
*/
public class CustomerTest {
	public static void main(String[] args) {

		Customer cust = new Customer("Jane", "Smith");
		
		cust.setAccount(new Account(1000, 2000, 0.0123));
		
		cust.getAccount().deposit(100);
		cust.getAccount().withdraw(960);
		cust.getAccount().withdraw(2000);
		
		cust.printInfo();
		
	}
}
























