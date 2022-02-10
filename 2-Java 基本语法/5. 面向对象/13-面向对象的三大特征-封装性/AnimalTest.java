package com.wndexx.java;
/*
	面向对象的特征一：封装与隐藏 (封装性) 3w: what why how
	
	一、问题的引入
	
		- 当我们创建一个类的对象以后，可以通过 "对象.属性" 的方式，对对象的属性进行赋值。
		
		  这里，赋值操作要受到属性的数据类型和存储范围的制约。但是除此之外，没有其他制约条件。
		  
		  但是，在实际问题中，我们往往需要给属性赋值加入额外的限制条件。
		  
		  这个限制条件就不能在属性声明时体现。我们只能通过方法进行限制条件的添加。（比如 setLegs()）
		  
		  同时，我们需要避免用户再使用 "对象.属性" 的方式对属性进行赋值，则需要将属性声明为私有的（private）
		  
		  此时，针对属性就体现了封装性
		  
	二、封装性的一个体现
	
		- 我们将类的属性私有化(private)，同时提供公共(public)的方法来获取(getXxx)和设置(setXxx)此属性的值
		
		拓展：
		
			封装性的体现：(1) 如上 (2) 不对外暴露的私有的方法 (3) 单例模式(将构造器私有化) (4) 如果不希望类在包外被调用，可以将类声明为缺省的
			
	三、封装性的体现，需要权限修饰符来配合
	
		1. Java 规定的4种权限(从大到小)：private、 缺省、 protected、 public
		
			修饰符		类内部		同一个包		不同包的子类	同一个工程
			
			private		yes	
			
			(缺省)		yes			yes
			
			protected	yes			yes			yes
			
			public		yes			yes			yes			yes
		  
		2. 4 种权限可以用来修饰类及类的内部结构：属性、方法、构造器、内部类
		
		3. 具体的，4 种权限都可以用来修饰类的内部结构：属性、方法、构造器、内部类
				
			修饰类的话，只能使用：缺省、public
			
	总结封装性：Java 提供了 4 种权限修饰符来修饰类及类的内部结构，体现类及类的内部结构在被调用时的可见性的大小
			
			
*/
public class AnimalTest {
	
	public static void main(String[] args) {
		
		Animal a = new Animal();
		
		a.name = "大黄";
		// a.age =  1;
		// a.legs = 4; The field Animal.legs is not visible
		a.show();
		
		// a.legs = -1;
		// a.setLegs(6);
		a.setLegs(-6);
		a.show();
		
		System.out.println(a.name);
	}
}

class Animal{
	
	String name;
	private int age;
	private int legs; // 腿的个数
	
	// 提供关于属性 age 的 get 和 set 方法 
	public int getAge() {
		return age;
	}
	
	public void getAge(int a) {
		age = a;
	}
	
	// 对属性的设置
	public void setLegs(int l) {
		if(l >= 0 && l % 2 ==0) {
			legs = l;
		}else {
			legs = 0;
			// 抛出一个异常
		}
	}
	
	// 对属性的获取
	public int getLegs() {
		return legs;
	}
	
	public void eat() {
		System.out.println("动物进食");
	}
	
	public void show() {
		System.out.println("name = " + name + ", age = " + age + ", legs = " + legs);
	}
}
