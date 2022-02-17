package com.wndexx.java;

/*
	异常：在Java语言中，将程序执行中发生的不正常情况称为"异常"。(开发过程中的语法错误和逻辑错误不是异常)
	
	Java程序在执行过程中所发生的异常事件可分为两类：
	
		Error：Java虚拟机无法解决的严重问题。如：JVM系统内部错误、资源耗尽等严重情况。比如：StackOverflowError和OOM。一般不编写针对性的代码进行处理
		
		Exception: 其它因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理。例如：
		
			空指针访问
			试图读取不存在的文件
			网络连接中断
			数组角标越界
			
*/
public class ErrorTest {
	public static void main(String[] args) {

		// 1. 栈溢出：java.lang.StackOverflowError
		// main(args); // 递归调用

		// 2. 堆溢出：java.lang.OutOfMemoryError
		// Integer[] arr = new Integer[1024 * 1024 * 1024];
		
	}
}
