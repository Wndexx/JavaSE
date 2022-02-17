package com.wndexx.java1;
/*
	接口的使用：
	
	1. 接口使用 interface 来定义
	
	2. Java 中，接口和类是并列的两个结构
	
	3. 如何定义接口，定义接口中的成员
	
		(1) JDK7 及以前: 只能定义全局常量和抽象方法
		
			- 全局常量： public static final 的，但是书写时，可以省略不写
			
			- 抽象方法：public abstract
		
		(2) JDK8: 除了定义全局常量和抽象方法，还可以定义静态方法、默认方法
		
	4. 接口中不能定义构造器！！意味着接口不可以实例化
	
	5. Java 开发中，接口都通过让类去实现(implements)的方式来使用
	
	   如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
	   
	   如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
	   
	6. Java 类可以实现多个接口 -----> 弥补了 Java 单继承性的局限性
	
	   格式：class AA extends BB implements CC,DD,EE{}
	   
	7. 接口与接口之间可以继承，而且可以多继承   接口不能继承类
	
	**********************************************************
	
	8. 接口的具体使用，体现多态性
	
	9. 接口，实际上可以看作是一种规范。
	
	面试题：抽象类与接口有哪些异同？
	
	
	
	面试题：
	
	interface A {
		int x = 0; // public static abstract
	}
	class B {
		int x = 1;
	}
	class C extends B implements A {
		public void pX(){
			System.out.println(x); // x 模棱两可 ambiguous
		}
		public static void main(String[] args){
			new C().pX(); // 
		}
	}
	
	
*/
public class InterfaceTest {
	public static void main(String[] args) {
		System.out.println(Flyable.MAX_SPEED);
		System.out.println(Flyable.MIN_SPEED);
		// Flyable.MIN_SPEED = 2; // The final field Flyable.MIN_SPEED cannot be assigned
		
		Plane plane = new Plane();
		plane.fly();
	}
}

interface Flyable{
	// 全局常量
	public static final int MAX_SPEED = 7900; // 第一宇宙速度
	int MIN_SPEED = 1; // 省略了 public static final 
	
	// 抽象方法
	public abstract void fly();
	void stop(); // 省略了 public abstract
	
	// public Flyable() {} // Interfaces cannot have constructors
}

interface Attackable{
	void attack();
}

class Plane implements Flyable{

	// implements com.wndexx.java1.Flyable.fly 抽象方法的重写叫实现
	@Override
	public void fly() {
		System.out.println("通过引擎起飞");
	}

	@Override
	public void stop() {
		System.out.println("驾驶员减速停止");
	}
}

abstract class Kite implements Flyable{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}
}

class Bullet extends Object implements Flyable,Attackable,CC{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		
	}
}

// *******************************************************

interface AA{
	void method1();
}

interface BB{
	void method2();
}

interface CC extends AA,BB{
	
}





