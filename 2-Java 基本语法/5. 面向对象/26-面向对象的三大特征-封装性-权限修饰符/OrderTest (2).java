package com.wndexx.java3;

import com.wndexx.java2.Order;

public class OrderTest {

	public static void main(String[] args) {

		Order order = new Order();

		order.orderPublic = 1;
		order.methodPublic();

		// 不同包下的普通类(非子类)要使用 Order 类，不可以调用声明为 private、 缺省、 protected 权限的属性、方法
		// The field Order.orderPrivate is not visible
		// order.orderPrivate = 2;
		// order.orderDefault = 3;
		// order.orderProtected = 4;

		// The method methodPrivate() from the type Order is not visible
		// order.methodPrivate();
		// order.methodDefault();
		// order.methodProtected();

	}

	public void show(Order order) {

		order.orderPublic = 1;
		order.methodPublic();

		// 不同包下的普通类(非子类)要使用 Order 类，不可以调用声明为 private、 缺省、 protected 权限的属性、方法
		// The field Order.orderPrivate is not visible
		// order.orderPrivate = 2;
		// order.orderDefault = 3;
		// order.orderProtected = 4;

		// The method methodPrivate() from the type Order is not visible
		// order.methodPrivate();
		// order.methodDefault();
		// order.methodProtected();
	}
}
