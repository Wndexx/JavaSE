package com.wndexx.java1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/*
	try-catch-finally  中 finally 的使用
	
	1. finally 是可选的
	
	2. finally 中声明的是一定会被执行的代码。 即使 catch 中又出现异常了， try 中有 return 语句，catch 中有 return 语句等情况
	
	3. 像数据库连接、输入输出流、网络编程 Socket 等资源， JVM 是不能自动的回收的，我们需要自己手动的进行资源的释放。此时的资源释放，就需要声明在 finally 中
	
	
	面试题：final、finally、finalize 三者的区别？
		
		类似：throw 、throws
		
			Collection 、Collections

			String、StringBuffer、StringBuilder

			ArrayList、LinkedList

			HashMap、LinkedHashMap
			
			重写、重载
			
		结构不相似的：
		
			抽象类、结构
			
			== 、equals()
			
			sleep()、wait()
	
*/
public class FinallyTest {

	@Test
	public void test1() {

		try {
			int a = 10;
			int b = 0;
			System.out.println(a / b);
		} catch (ArithmeticException e) {
			e.printStackTrace();

			// int[] arr = new int[10];
			// System.out.println(arr[10]);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("hhh~~");
		}

		System.out.println("hhh~~~~");
	}

	@Test
	public void testMethod() {
		int num = method();
		System.out.println(num);
	}

	public int method() {
		try {
			int[] arr = new int[10];
			System.out.println(arr[10]);
			return 1;
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return 2;
		} finally {
			System.out.println("我一定会被执行");
			return 3;
		}
	}

	@Test
	public void test2() {
		FileInputStream fis = null;
		try {
			File file = new File("hello1.txt");
			fis = new FileInputStream(file);

			int data = fis.read();
			while (data != -1) {
				System.out.print((char) data);
				data = fis.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
