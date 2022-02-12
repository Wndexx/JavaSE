package com.wndexx.java;

import org.junit.jupiter.api.Test;

public class ReviewTest {

	// 数组也作为 Object 类的子类出现，可以调用 Object 类中声明的方法
	@Test
	public void test1() {
		int[] arr = new int[] { 1, 2, 3 };
		// 数组可以看作一类特殊的类
		print(arr);
		System.out.println(arr.getClass().getSuperclass()); // class [I   class java.lang.Object
	}

	public void print(Object obj) {
		System.out.println(obj);
	}
	
	// 区别手动写的和自动生成的 equals()
	@Test
	public void test2() {
		Person p = new Person("Tom",12);
		Man m = new Man("Tom",12);
		System.out.println(p.equals(m)); // false
	}
	
	// 关于 toString()
	@Test
	public void test3() {
		
		String s = "abc";
		System.out.println(s); // abc
		System.out.println(s.toString()); // abc
		
		s = null;
		System.out.println(s); // null
		// System.out.println(s.toString()); // NullPointerException
	}
	
	
	
	
}
