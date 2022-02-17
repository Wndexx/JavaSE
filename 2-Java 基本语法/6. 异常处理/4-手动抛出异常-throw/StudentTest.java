package com.wndexx.java2;
/*
	在程序执行中，除了自动抛出异常对象的情况之外，我们还可以手动的 throw 一个异常类的对象

	面试题：throw 和 throws 区别：
	
		throw 表示抛出一个异常类的对象，生成异常对象的过程。声明在方法体内
		
		throws 属于异常处理的一种方式，声明在方法的声明处
	
*/
public class StudentTest {

	public static void main(String[] args) {

		try {
			Student s = new Student();
			s.regist(-1001);
			System.out.println(s.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

class Student {
	private int id;

	public void regist(int id) throws Exception {
		if (id > 0)
			this.id = id;
		else
			// System.out.println("您输入的数据非法！！");
			// 手动抛出异常对象
			// throw new RuntimeException("您输入的数据非法");
			throw new MyException("不能输入负数");
	}

	@Override
	public String toString() {
		return "Student [id=" + id + "]";
	}
}
