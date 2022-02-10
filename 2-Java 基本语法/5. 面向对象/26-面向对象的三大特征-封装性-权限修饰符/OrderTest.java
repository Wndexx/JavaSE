package com.wndexx.java2;

public class OrderTest {
	
	public static void main(String[] args) {
		
		Order order = new Order();
		
		order.orderDefault = 1;
		order.orderProtected = 2;
		order.orderPublic = 3;
		
		order.methodDefault();
		order.methodProtected();
		order.methodPublic();
		
		// 同一个包种的其他类，不可以调用 Order 类中私有的属性和方法
		// The field Order.orderPrivate is not visible
		// order.orderPrivate = 4;
		
		// The method methodPrivate() from the type Order is not visible
		// order.methodPrivate();
		
	}
}
