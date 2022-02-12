package com.wndexx.java3;
/*
	对属性可以赋值的位置：
	
		(1) 默认初始化
		
		(2) 显式初始化 (5) 在代码块中赋值
		
		(3) 构造器中初始化
		
		(4) 有了对象以后，可以通过 "对象.属性" 或 "对象.方法" 的方式，进行赋值
		
		执行的先后顺序：1 - 2 / 5 - 3 - 4
		
*/
public class OrderTest {
	public static void main(String[] args) {
		Order order = new Order();
		System.out.println(order.orderId); // 3
		order.show(); // 3
	}
}

class Order{
	public void show(){
		System.out.println(orderId);
	}
	// 谁放在前面，谁先执行
	{
		orderId = 4;
	}
	int orderId = 3;
}
