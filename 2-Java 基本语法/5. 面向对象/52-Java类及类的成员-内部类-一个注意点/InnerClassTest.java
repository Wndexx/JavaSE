package com.wndexx.java;

public class InnerClassTest {
	/*
	 * 在局部内部类的方法中(比如：show()) ，如果调用局部内部类所声明的方法(比如：method())中的局部变量(比如：num)的话，要求此局部变量声明为 final 的
	 * 
	 * jdk 7及之前版本，要求此局部变量显式的声明为 final
	 * 
	 * jdk 8及之后的版本，可以省略 final 的声明，但仍然是 final 的
	 * 
	 */
	public void method() {
		// 局部变量
		int num = 10;
		class AA{
			public void show() {
				// num = 20; // Local variable num defined in an enclosing scope must be final or effectively final
				System.out.println(num);
			}
		}
	}
}
