package com.wndexx.java1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/*
	一、异常的处理：抓抛模型    预案     上游排污 下游治污
	
		过程一："抛"：
		
			程序在正常执行的过程中，一旦出现异常，就会在异常代码处生成一个对应异常类的对象，并将此对象抛出
		
			一旦抛出对象以后，其后的代码就不再执行
			
			关于异常对象的产生：
			
				系统自动生成的异常对象
				
				手动的生成一个异常，并抛出(throw)
		
		过程二："抓"：
		
			可以理解为异常的处理方式：
			
				try-catch-finally
				
				throws
				
	二、try-catch-finally 的使用
	
		try{
		
			// 可能出现异常的代码
		
		}catch(异常类型1 变量名1){
			
			// 处理异常的方式1
			
		}catch(异常类型2 变量名2){
			
			// 处理异常的方式2
			
		}catch(异常类型3 变量名3){
			
			// 处理异常的方式4
			
		}
		...
		finally{
			
			// 一定会执行的代码
			
		}
		
		说明：
		
		1. finally 是可选的
		
		2. 使用 try 将可能出现异常代码包装起来，在执行过程中，一旦出现异常，就会生成一个对应异常类的对象，根据此对象的类型，去 catch 中进行匹配
		
		3. 一旦 try 中的异常对象匹配到某一个 catch 时，就进入 catch 中进行异常的处理。
		
		   一旦处理完成，就跳出当前的 try-catch 结构(在没有写 finally 的情况)，继续执行其后的代码
		   
		4. catch 中的异常类型，如果没有子父类关系，则谁声明在上，谁声明在下无所谓
		
		   catch 中的异常类型，如果满足子父类关系，则子类一定声明在父类的上面，否则，报错
		   
		5. 常用的异常对象处理的方式：
		
			(1) String getMessage()
			
			(2) printStackTrance()
			
		6. 在 try 结构中声明的变量，在出了 try 结构以后，就不能再被调用
		
		7. try-catch-finally 结构可以嵌套
	
	体会1：使用 try-catch-finally 处理编译时异常，使得程序在编译时不再报错，但是运行时仍可能报错，相当于我们使用 try-catch-finally 将一个编译时可能出现的异常，延迟到运行时出现
	
	体会2：开发中由于运行时异常比较常见，所以我们通常就不在运行时异常编写 try-catch-finally 了
	
		 针对于编译时异常，一定要考虑异常的处理
		 
		 
*/
public class ExceptionTest1 {

	@Test
	public void test1() {

		String str = "123";
		str = "abc";

		int num = 0;
		try {
			num = Integer.parseInt(str);
			System.out.println("hello-----------1");
		} catch (NumberFormatException e) {

			// System.out.println("出现数值转换异常了，不要着急....");

			// String getMessage()
			// System.out.println(e.getMessage());

			// printStackTrance()
			e.printStackTrace();

		} catch (NullPointerException e) {
			System.out.println("出现空指针异常了，不要着急....");
		} catch (Exception e) {
			System.out.println("出现异常了，不要着急....");
		}

		System.out.println(num);

		System.out.println("hello-----------2");
	}

	@Test
	public void test2() {
		try {
			File file = new File("hello.txt");
			FileInputStream fis = new FileInputStream(file);

			int data = fis.read();
			while (data != -1) {
				System.out.print((char) data);
				data = fis.read();
			}

			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
