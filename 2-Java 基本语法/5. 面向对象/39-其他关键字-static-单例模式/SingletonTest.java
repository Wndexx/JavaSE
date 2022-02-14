package com.wndexx.java;

public class SingletonTest {
	public static void main(String[] args) {
		
		Bank bank1 = Bank.instance;
		Bank bank2 = Bank.instance;
		System.out.println(bank1 == bank2); // true
		
		// Bank.instance = null;
		// bank2 = Bank.instance;
		// System.out.println(bank1 == bank2); // false
	}
}

class Bank{
	
	public static final Bank instance = new Bank();
	
	private Bank() {
		
	}
}
