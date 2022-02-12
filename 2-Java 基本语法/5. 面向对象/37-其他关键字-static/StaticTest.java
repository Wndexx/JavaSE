package com.wndexx.java1;

/*
	static 关键字的使用
	
	1. static ：静态的
	
	2. static 可以用来修饰：属性、 方法、 代码块、 内部类
	
	3. 使用 static 修饰属性：静态变量(或类变量)
	
		(1) 属性，按是否使用 static 修饰，又分为：静态属性 vs 非静态属性(实例变量)
		
			- 实例变量：我们创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性。当修改其中一个对象中的非静态属性时，不会导致其他对象中同样的属性值的修改
			
			- 静态变量：我们创建了类的多个对象，多个对象共享同一个静态变量。当通过某一个对象修改静态变量时，会导致其他对象调用此静态变量时，是修改过了的
	
		(2) static 修饰属性的其他说明：
		
			- 静态变量随着类的加载而加载。可以通过 "类.静态变量" 的方式进行调用
			
			- 静态变量的加载要早于对象的创建
			
			- 由于类只会加载一次，则静态变量在内存中也只会存在一份，存在方法区的静态域中
			
			- 			类变量 		实例变量
						
				类		yes			
				
				对象		yes			yes
				
		(3) 静态属性举例：System.out; Math.PI; 
	
	4. 使用 static 修饰方法：静态方法
	
		(1) 随着类的加载而加载，可以通过 "类.静态方法" 的方式进行调用
		
		(2)				静态方法 		非静态方法
						
				类		yes			
				
				对象		yes			yes
	
		(3) 静态方法中只能调用静态的方法或属性(生命周期一致)
		
			非静态方法中，既可以调用非静态的方法或属性，也可以调用静态的方法或属性
	
	5. static 注意点：
	
		(1) 在静态的方法内，不能使用 this 关键字、 super 关键字
		
		(2) 关于静态属性和静态方法的使用，大家都从生命周期的角度去理解(类的生命周期、对象的生命周期)
		
	6. 总结：
	
		- 开发中，如何确定一个属性是否要声明为 static 的？
		
			- 属性是可以被多个对象所共享的，不会随着对象的不同而不同的
			
			- 类中的常量也常常声明为 static
			
		- 开发中，如何确定一个方法是否要声明为 static 的？
		
			- 操作静态属性的方法，通常设置为 static 的
		
			- 工具类中的方法，习惯上声明为 static 的。比如：Math、 Arrays、 Collections
		
*/
public class StaticTest {
	public static void main(String[] args) {

		Chinese.nation = "中国";

		Chinese c1 = new Chinese();
		c1.name = "张三";
		c1.age = 20;
		c1.nation = "CHN";

		Chinese c2 = new Chinese();
		c2.name = "李四";
		c2.age = 25;
		c1.nation = "CHINA";

		System.out.println(c2.nation); // CHINA

		// Chinese.name = "王五"; // 编译不通过

		c1.eat();

		Chinese.show();

		// Chines.eat(); // 编译不通过
		
		// Chines.info(); // 编译不通过
	}
}

// 中国人
class Chinese {

	String name;
	int age;
	static String nation;

	public void eat() {
		System.out.println("中国人吃中餐");
		
		// 调用非静态结构
		this.info();
		System.out.println("name : " + name);
		
		// 调用静态结构
		walk();
		System.out.println("nation : " + Chinese.nation);
	}

	public static void show() {
		
		// 不能调用非静态的结构
		// eat(); // Cannot make a static reference to the non-static method eat() from the type Chinese
		// name = "Tom"; // Cannot make a static reference to the non-static field name
		
		System.out.println("我是一个中国人");
		
		// 可以调用静态的结构
		System.out.println(Chinese.nation);
		System.out.println(nation);
		
		walk();
	}

	public void info() {
		System.out.println("name :" + name + ", age :" + age);
	}
	
	public static void walk() {
		
	}
}