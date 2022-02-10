package com.wndexx.exer;

/*
	
	1. 创建程序,在其中定义两个类：Person和PersonTest类。定义如下：
	   用setAge()设置人的合法年龄(0~130)，用getAge()返回人的年龄。
	   在 PersonTest 类 中 实 例 化 Person 类 的 对 象 b ， 调 用 setAge() 和 getAge() 方法，体会Java的封装性。

		Person
		-age:int
		+setAge(i: int)
		+getAge(): int
		
	2. 在前面定义的 Person 类中添加构造器，利用构造器设置所有人的 age 属性初始值都为18。
	
	2. 修改上题中类和构造器，增加name属性,使得每次创建Person对象的同时初始化对象的age属性值和name属性值。
		Person
		-name:String
		+setName(i: String)
		+getName(): String
	
*/
public class Person {

	private String name;
	private int age;

	public Person() {
		age = 18;
	}

	public Person(String n, int a) {
		name = n;
		age = a;
	}

	public void setName(String n) {
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setAge(int a) {
		if (a < 0 || a > 130) {
			// throw new RuntimeException("传入的数据非法!!");
			System.out.println("传入的数据非法!!");
			return;
		}
		age = a;
	}

	public int getAge() {
		return age;
	}

	// 绝对不要这样写
	// public int doAge(int a) {
	// age = a;
	// return age;
	// }
}
