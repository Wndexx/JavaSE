package com.wndexx.java2;

/*
	单例设计模式:
	
	1. 设计模式是在大量的实践中总结和理论化之后优选的代码结构、编程风格、以及解决问题的思考方式。 "套路"
	
	   类的单例设计模式，就是采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例。
	   
	2. 如何实现？
	
		饿汉式 vs 懒汉式
		
	3. 区分 饿汉式 和 懒汉式
	
		饿汉式：
			坏处： 对象加载时间过长。
			
			好处：饿汉式是线程安全的
		
		懒汉式：
			好处： 延迟对象的创建
			
			目前写法的坏处：线程不安全  ---> 到多线程内容时，再修改
	
	4. 应用场景：
	
		(1) 网站的计数器，一般也是单例模式实现，否则难以同步。
		
		(2) 应用程序的日志应用，一般都使用单例模式实现，这一般是由于共享的日志文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加。
		
		(3) 数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。
		
		(4) 项目中，读取配置文件的类，一般也只有一个对象。没有必要每次使用配置
		
		(5) 文件数据，都生成一个对象去读取。
		
		(6) Application 也是单例的典型应用
		
		(7) Windows的Task Manager (任务管理器)就是很典型的单例模式
		
		(8) Windows的Recycle Bin (回收站)也是典型的单例应用。在整个系统运行过程中，回收站一直维护着仅有的一个实例。
		
*/
public class SingletonTest1 {
	public static void main(String[] args) {
		
		Bank bank1 = Bank.getInstance();
		Bank bank2 = Bank.getInstance();
		
		System.out.println(bank1 == bank2); // true
	}
}

// 饿汉式
class Bank{
	
	// 1. 私有化类的构造器
	private Bank() {
		
	}
	
	// 2. 内部创建类的对象
	// 4. 要求此对象也必须声明为静态的
	private static Bank instance = new Bank();
	
	// 3. 提供公共的静态方法返回类的对象
	public static Bank getInstance() {
		return instance;
	}
}