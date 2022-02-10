package com.wndexx.java;
/*
	一、设计类，其实就是设计类的成员
	
		属性 = 成员变量 = field = 域、字段
	
		方法 = 成员方法 = 函数 = method
		
		创建类的对象 = 类的实例化 = 实例化类
		
		
	二、类和对象的使用(面向对象思想落地的实现)
	
		1. 创建类，设计类的成员 class 类名{}
		
		2. 创建类的对象  类名 对象名 = new 类名();
		
		3. 调用对象的结构 对象.属性、对象.方法 
		
		
	三、如果创建了一个类的多个对象，则每个对象都独立的拥有一套类的属性。(非 static 的)
	   
	   意味着：如果我们修改一个对象的属性a，则不影响另外一个对象的属性a 的值
	   
	   
	四、对象的内存解析
		
*/

// 测试类
public class PersonTest {
	public static void main(String[] args) {
		
		// 2. 创建 Person 类的对象
		Person p1 = new Person();
		// Scanner Scanner = new Scanner(System.in);
		
		// 3. 调用对象的结构：属性、方法
		// (1) 调用属性：对象.属性
		p1.name = "Tom";
		p1.isMale = true;
		System.out.println(p1.name);
		
		// (2) 调用方法：对象.方法
		p1.eat();
		p1.sleep();
		p1.talk("Chinese");
		
		
		System.out.println("*********************************************");
		
		
		Person p2 = new Person();
		System.out.println(p2.name); // null
		System.out.println(p2.isMale); // false
		
		
		System.out.println("*********************************************");
		
		// array2 = array1
		// 将 p1 变量保存的对象地址值赋给 p3，导致 p1 和 p3 指向了堆空间中的同一个对象实体
		Person p3 = p1;
		System.out.println(p3.name); // Tom
		
		p3.age = 10;
		System.out.println(p1.age); // 10
		
	}
}

// 	1. 创建类，设计类的成员
class Person{
	
	// 属性
	String name;
	int age = 1;
	boolean isMale;
	
	// 方法
	public void eat() {
		System.out.println("人可以吃饭");
	}
	
	public void sleep() {
		System.out.println("人可以睡觉");
	}
	
	public void talk(String language) {
		System.out.println("人可以说话，使用的是：" + language);
	}
	
}
