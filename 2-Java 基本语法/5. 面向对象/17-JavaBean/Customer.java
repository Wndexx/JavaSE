package com.wndexx.java1;
/*

	拓展知识：
	
		JavaBean
		
			1. JavaBean 是一种 Java 语言写成的可重用组件
			
			2. 所谓 JavaBean，是指符合如下标准的 Java 类：
			
				- 类是公共的
				
				- 有一个无参的公共的构造器
				
				- 有属性，且有对应的 get、set 方法
				
			3. 用户可以使用 JavaBean 将功能、处理、值、数据库访问和其它任何可以用 Java 代码创造的对象进行打包，
			
			   并且其他的开发者可以通过内部的 JSP 页面、Servlet、其他 JavaBean、applet 程序或者应用来使用这些对象。
			   
			   用户可以认为 JavaBean 提供了一种随时随地的复制和粘贴的功能，而不用关心任何改变
			   
		UML 类图
		
		1. + 表示 public类型，- 表示 private类型， # 表示 protected 类型
		
		2. 方法的写法：
		
			- 方法的类型(+、-) 方法名(参数名：参数类型):返回值类型
			
			- 方法有下划线表示为构造器
				
				Person
				-name:String
				+setName(i: String)
				+getName(): String
		
 */
public class Customer {
	
	private int id;
	private String name;
	
	public Customer(){
		
	}
	
	public void setId(int i) {
		id = i;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
}
