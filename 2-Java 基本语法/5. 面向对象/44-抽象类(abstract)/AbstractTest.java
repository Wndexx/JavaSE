package com.wndexx.java;
/*
	abstract 关键字的使用
	
	1. abstract：抽象的 
	
	2. abstract 可以用来修饰的结构：类 、 方法
	
	3. abstract 修饰类：抽象类
	
		(1) 此类不能实例化 
		
		(2) 抽象类中一定有构造器，便于子类实例化时调用(设计：子类对象实例化的全过程)
		
		(3) 开发中，都会提供抽象类的子类，让子类对象实例化，完成相关的操作
		
	4. abstract 修饰方法：抽象方法
		
		(1) 抽象方法只有方法的声明，没有方法体
	
		(2) 包含抽象方法的类一定是一个抽象类。反之，抽象类中是可以没有抽象方法的
		
		(3) 若子类重写了父类中的所有的抽象方法后，此子类方可实例化
		
			若子类没有重写父类中的所有的抽象方法后，则次子类也必须是一个抽象类，需要使用 abstract 修饰
			
*/
public class AbstractTest {
	public static void main(String[] args) {
		
		// Cannot instantiate the type Person
		// 一旦 Person 类抽象了，就不可实例化
		// Person p1 = new Person();
		// p1.eat();
		
	}
}

abstract class Creature{
	public abstract void breath();
}

abstract class Person extends Creature{
	String name;
	int age;
	
	public Person() {
		
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// 不是抽象方法
	// public void eat() {
		
	// }
	
	// 抽象方法
	public abstract void eat();
	
	public void walk() {
		System.out.println("人走路");
	}
}

class Student extends Person{
	
	public Student() {
		
	}
	
	public Student(String name,int age) {
		super(name,age);
	}
	
	 public void eat() {
		 System.out.println("学生多吃有营养的食物");
	 }

	@Override
	public void breath() {
		System.out.println("学生应该呼吸新鲜空气");
	}
}
