package com.wndexx.java3;

/*
	类的内部成员之五：内部类
	
	1. Java 中允许将一个类 A 声明在另一个类 B 中，则类 A 就是一个内部类，类 B 称为外部类
	
	2. 内部类的分类：成员内部类(静态、非静态) vs 局部内部类(方法内、代码块内、构造器内)
	
	3. 成员内部类：
	
		(1) 一方面，作为外部类的成员：
		
			- 调用外部类的结构
		
			- 可以被 static 修饰
			
			- 可以被 4 种不同的权限修饰
			
		(2) 另一方面，作为一个类：
		
			- 类内可以定义属性、方法、构造器等
			
			- 可以被 final 修饰，表示此类不能被继承。言外之意，不使用final，可以被继承
			
			- 可以被 abstract 修饰
			
	4. 关注如下的 3 个问题
	
		(1) 如何实例化成员内部类的对象
		
		(2) 如何在成员内部类中区分调用外部类的结构
		
		(3) 开发中局部内部类的使用
	
*/
public class InnerClassTest {
	public static void main(String[] args) {

		// (1) 如何实例化成员内部类的对象
		// 创建 Dog 实例(静态的成员内部类)：
		Person.Dog dog = new Person.Dog();
		dog.show(); // 卡拉是条狗

		// 创建 Bird 实例(非静态的成员内部类)：
		// Person.Bird dog = new Person.Bird();
		Person p = new Person();
		Person.Bird bird = p.new Bird();
		bird.sing();

		System.out.println();
		
		bird.display("黄鹂");
	}
}

class Person {
	String name = "小明";
	int age;

	public void eat() {
		System.out.println("人吃饭");
	}

	// 静态成员内部类
	static class Dog {
		String name = "大黄";
		int age;

		public void show() {
			System.out.println("卡拉是条狗");
			// eat();
		}
	}

	// 非静态成员内部类
	final class Bird {
		String name = "杜鹃";

		public Bird() {

		}

		public void sing() {
			System.out.println("我是一只小小鸟");
			Person.this.eat(); // 调用外部类的非静态属性
			// eat();
			System.out.println(age);
		}

		public void display(String name) {
			Dog dog = new Dog();
			System.out.println(dog.name);
			System.out.println(name); // 方法的形参
			System.out.println(this.name); // 内部类的属性
			System.out.println(Person.this.name); // 外部类的属性
		}
	}

	public void method() {
		// 局部内部类
		class AA {

		}
	}

	{
		// 局部内部类
		class BB {

		}
	}

	public Person() {
		// 局部内部类
		class CC {

		}
	}
}