package com.wndexx.java2;

import org.junit.Test;

/*
 * 关于包装类使用的面试题
 */
public class InterviewTest {

	@Test
	public void test1() {
		//面试题：
		Object o1 = true ? new Integer(1) : new Double(2.0);
		System.out.println(o1); // 1.0 
		
		Object o2;
		if (true)
			o2 = new Integer(1);
		else
			o2 = new Double(2.0);
		System.out.println(o2); // 1
	}
	
	@Test
	public void test2() {
		
		Integer i = new Integer(1);
		Integer j = new Integer(1);
		System.out.println(i == j); // false 比较的是地址
		
		// Integer 内部定义了 IntegerCache 结构：IntegerCache 中定义了 Integet[]，保存了从 -128 ~ 127 范围的正数。
		// 如果我们使用自动装箱的方式，给 Integer 赋值的范围在 -128 ~ 127 范围内时，可以直接使用数组中的元素，不用再去 new 了。 目的：提高效率
		Integer m = 1;
		Integer n = 1;
		System.out.println(m == n); // true
		
		Integer x = 128; // 相当于 new 了一个 Integer 对象
		Integer y = 128; // 相当于 new 了一个 Integer 对象
		System.out.println(x == y); // false
	}
}
