/*
	1. 什么是方法的重载

		相同类、相同方法名、不同参数列表的两个方法构成重载

		如何调用确定的方法：方法名 ----> 参数列表

	2. 说明 Java 方法中的参数传递机制的具体体现？

		值传递

		如果参数是基本数据类型，则直接将实参的值传递给形参

		如果参数是引用数据类型，则将实参的地址值传递给形参（含变量的数据类型）

		Person p1 = new Person();
		User u1 = p1;// 编译错误

	3. 成员变量和局部变量在声明的位置上、是否有默认初始化值上、是否能有权限修饰符上、内存分配的位置上有何不同？

		成员变量声明在类的{}内，有默认初始化值，和数组元素的默认初始化值完全相同，可以使用权限修饰符，存储在堆空间中

		局部变量声明在形参，方法体，代码块中，没有默认初始化值，使用前必须显式赋值，不能使用权限修饰符，存储在栈空间中

	4. 谈谈 return 关键字的使用

		当方法没有返回值时，可以使用 return; 直接结束当前方法

		当方法有返回值时，必须使用 return 数据 ，在结束当前方法的同时将数据返回

	5. 提供如下代码的内存解析

		public class ValueTransferExer {
	
			public static void main(String[] args) {
				
				ValueTransferExer test = new ValueTransferExer();
				test.first();
			}
			
			public void first() {
				
				int i = 5;
				Value v = new Value();
				v.i = 25;
				
				second(v,i);
				
				System.out.println(v.i); // 20
			}
			
			public void second(Value v, int i) {
				
				i = 0;
				v.i = 20;
				
				Value val = new Value();
				v = val;
				System.out.println(v.i + " " + i); // 15 0
			}
		}

		class Value{
			int i = 15;
		}

		1. 内存结构：栈（局部变量）、堆（new 出来的结构：对象(非 static 成员变量)、数组）

		2. 变量：成员变量 vs 局部变量（方法内、方法形参、构造器内、构造器形参、代码块内）



		补充：

		面试题：方法的重载与重写的区别？

				throws\throw

				String\StringBuffer\StringBuilder

				Collection\Collections

				final\finally\finalize

				....
				

				抽象类、 接口
				sleep() / wait()





*/