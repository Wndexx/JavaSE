package com.wndexx.exer;

public class PersonTest {
	
	public static void main(String[] args) {
		
		Person p = new Person();
		// p.setAge(10);
		System.out.println("年龄为：" + p.getAge());
		
		// p1.doAge(10);
		
		Person p2 = new Person("Tom", 21);
		System.out.println("name = " + p2.getName() + ", age = " + p2.getAge());
	}
}
