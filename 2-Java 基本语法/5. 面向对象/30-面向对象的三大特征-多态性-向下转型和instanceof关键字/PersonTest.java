package com.wndexx.java;

import java.util.Date;

/*
	面向对象特征之三：多态性(Polymorphism)
	
	1. 理解多态性：可以理解为一个事物的多种形态
	
	2. 何为多态性：
	
		- 对象的多态性：父类的引用指向子类的对象 (或子类的对象赋给父类的引用)  向上转型
	
	3. 多态的使用：虚拟方法调用 (Virtual Method Invocation)  多态是运行时行为
	
		- 有了对象的多态性以后，我们在编译期，只能调用父类中声明的方法，但在运行期，实际执行的是子类重写父类的方法
		
			- 虚拟方法调用(多态情况下)：子类中定义了与父类同名同参数的方法，在多态情况下，将此时父类的方法称为虚拟方法，父类根据赋给它的不同子类对象，动态调用属于子类的该方法。这样的方法调用在编译期是无法确定的。
			
			- 编译时类型和运行时类型：编译时为父类型，而方法的调用是在运行时确定的，所以调用的是子类的重写的方法。------ 动态绑定
		
		总结：编译，看左边；运行，看右边
		
	4. 多态性的使用前提：
	
		- 要有类的继承关系
		
		- 方法的重写
		
	5. 对象的多态性，只适用于方法，不适用于属性 (编译和运行都看左边)
	
	
	******************************************************************************************************************
	
	
	方法的重载与重写
	
	1. 二者的定义细节：略
	
	2. 从编译和运行的角度看：
	
		- 重载，是指允许存在多个同名方法，而这些方法的参数不同，编译器根据方法不同的参数列表，对同名方法的名称作修饰。
		
		  对于编译器而言，这些同名方法就构成了不同的方法。它们的调用地址在编译期就绑定了。Java 的重载是可以包括父类和子类的，即子类可以重载父类的同名不同参数的方法
		  
		  所以，对于重载而言，在方法调用之前，编译器就已经确定了所要调用的方法，这称为 "早绑定" 或 "静态绑定"
		  
		  而对于多态，只有等到方法调用的那一刻，解释运行器才会确定所要调用的具体方法，这称为 "晚绑定" 或 "动态绑定" 


	面试题：

		1. 谈谈你对多态性的理解？

			(1) 实现代码的通用性

			(2) Object 类中定义的 public boolean equals(Object obj){}

			JDBC: 使用 java 程序操作数据库(MySQL、Oracle、DB2、SQL Server)：获取数据库连接、CRUD

			(3) 抽象类、接口的使用肯定体现了多态性。（抽象类、接口不能实例化）


		2. 多态是编译时行为还是运行时行为？

			运行时行为
	
*/
public class PersonTest {

	public static void main(String[] args) {

		Person p1 = new Person();
		p1.eat();

		Man man = new Man();
		man.eat();
		man.age = 25;
		man.earnMoney();

		System.out.println("***********************************************");

		// 对象的多态性：父类的引用指向子类的对象
		Person p2 = new Man();
		// Person p3 = new Woman();
		// 多态的使用：当调用子父类同名同参数的方法时，实际执行的是子类重写父类的方法 ------------- 虚拟方法调用
		p2.eat();
		p2.walk();

		// 编译的时候看左边声明的类型，如果该类型没有对应方法，就不能调用
		// p2.earnMoney(); // The method earnMoney() is undefined for the type Person

		System.out.println(p2.id); // 1001

		System.out.println("***********************************************");

		// 不能调用子类所特有的方法、属性：编译时，p2 是 Person 类型
		p2.name = "Tom";
		// p2.earnMoney();
		// isSmoking cannot be resolved or is not a field
		// p2.isSmoking = true;

		// 有了对象的多态性以后，内存中实际上加载了子类特有的属性和方法的，但是由于变量声明为父类类型，导致编译时只能调用父类中声明的属性和方法，子类特有的属性和方法不能调用

		// 如何才能调用子类特有的属性和方法？
		// 向下转型：使用强制类型转换符
		Man m1 = (Man) p2;
		m1.earnMoney();
		m1.isSmoking = true;

		// 使用强转时，可能出现 ClassCastException 的异常
		// java.lang.ClassCastException 类型转换异常
		// Woman w1 = (Woman)p2;
		// w1.goShopping();

		/*
			instanceof 关键字的使用:
			
			a instanceof A: 判断 对象a 是否是 类A 的实例，如果是，返回true；如果不是，返回 false
			
			使用情境：为了避免在向下转型时，出现 ClassCastException 的异常，我们在向下转型之前，先进行 instanceof 的判断。
				
				- 一旦返回 true ，就进行向下转型
				
				- 如果返回 false，不进行向下转型
			
			如果 a instanceof A 返回 true，则 a instanceof B 也返回 true。其中，类B 是 类A 的父类
		 	
		 	要求 a 所属的类与 类A 必须是子类和父类的关系，否则编译错误

		*/

		if (p2 instanceof Woman) {
			Woman w1 = (Woman) p2;
			w1.goShopping();
			System.out.println("*********Woman************");
		}

		if (p2 instanceof Man) {
			Man m2 = (Man) p2;
			m2.earnMoney();
			System.out.println("*********Man************");
		}

		if (p2 instanceof Person) {
			System.out.println("*********Person*********");
		}

		if (p2 instanceof Object) {
			System.out.println("*********Objct*********");
		}

		// 练习：
		// 问题1：编译时通过，运行时不通过
		// 举例1：
		// Person p3 = new Woman();
		// Man m3 = (Man)p3;
		// 举例2：
		// Person p4 = new Person();
		// Man p4 = (Man)p4;

		// 问题2：编译通过，运行时也通过
		Object obj = new Woman();
		Person p = (Person) obj;

		// 问题3：编译不通过
		// Man m5 = new Woman();
		
		//String str = new Date();
		
		// Object o = new Date();
		// String str1 = (String) o;
	}
}
