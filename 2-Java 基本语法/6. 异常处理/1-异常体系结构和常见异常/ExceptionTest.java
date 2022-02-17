package com.wndexx.java1;

import java.io.File;
import java.io.FileInputStream;

import org.junit.jupiter.api.Test;

/*
	一、异常体系结构
	
		java.lang.Throwable
		
			java.lang.Error: 一般不编写针对性的代码进行处理
			
			java.lang.Exception： 可以进行异常的处理
			
				编译时异常(checked, 受检异常)：执行 javac.exe 命令时，可能出现的异常
				
					IOException
					
						FileNotFoundException
					
					ClassNotFoundException
				
				运行时异常(unchecked, 非受检异常  RuntimeException)：执行 java.exe 命令时，可能出现的异常
				
					NullPointerException
					
					ArrayIndexOutOfBoundException
					
					ClassCastException
					
					NumberFormatException
					
					InputMismatchException
					
					ArithmeticException
			
		
	面试题：常见的异常有哪些？举例说明
	
*/
public class ExceptionTest {

	/*
	 * 运行时异常
	 *
	 */
	// 1. NullPointerException
	@Test
	public void test1() {

		// int[] arr = null;
		// System.out.println(arr[1]);

		String str = "abc";
		str = null;
		System.out.println(str.charAt(0));
	}

	// 2. IndexOutOfBoundException
	@Test
	public void test2() {

		// (1) ArrayIndexOutOfBoundException
		// int[] arr = new int[10];
		// System.out.println(arr[10]);

		// (2) StringIndexOutOfBoundsException
		// String str = "abc";
		// System.out.println(str.charAt(3));
	}

	// 3. ClassCastException
	@Test
	public void test3() {

		// Object obj = new Date();
		// String str = (String) obj;
	}

	// 4. NumberFormatException
	@Test
	public void test4() {

		// String str = "123";
		// str = "abc";
		// int num = Integer.parseInt(str);
	}

	// 5. InputMismatchException
	@Test
	public void test5() {

		// Scanner scanner = new Scanner(System.in);
		// int score = scanner.nextInt();
		// System.out.println(score);
		
		// scanner.close();
	}

	// 6. ArithmeticException
	@Test
	public void test6() {
		// int a = 10;
		// int b = 0;
		// System.out.println(a / b);
	}

	/*
	 * 编译时异常
	 * 
	 */
	@Test
	public void test7() {
		// File file = new File("hello.txt");
		// FileInputStream fis = new FileInputStream(file);
		//
		// int data = fis.read();
		// while (data != -1) {
		//	 System.out.print((char)data);
		//	 data = fis.read();
		// }
		//
		// fis.close();
	}

}
