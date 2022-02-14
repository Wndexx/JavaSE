package com.wndexx.exer1;

public class Test {
	public static void main(String[] args) {
		Person p = new Man();
		p.show(); // a
		
		Man m = new Man();
		m.show(); // b
	}
}

class Person {
	public static void show() {
		System.out.println("a");
	}
}

class Man extends Person {
	public static void show() {
		System.out.println("b");
	}
}