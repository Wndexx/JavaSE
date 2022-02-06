package com.wndexx.exer;

import java.io.PrintStream;

/*
 * 网红题1
 */
public class ValueTransferExer1 {
	public static void main(String[] args) {
		
		int a = 10;
		int b = 10;
		
		method(a,b); // 需要在 method 方法被调用之后，仅打印出 a = 100, b = 200，请写出 method 方法的代码
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}
	
	// 代码编写处
	public static void method(int a, int b) {
		
		// 方法1：
		// System.out.println("a=100,b=200");
		// System.exit(0);
		
		// 方法2：
		PrintStream ps = new PrintStream(System.out) {
			@Override
			public void println(String x) {
				if("a=10".equals(x)) {
					x = "a=100";
				}else if("b=10".equals(x)) {
					x = "b=200";
				}
				super.println(x);
			}
		};
		System.setOut(ps);
		
	}
}
