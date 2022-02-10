package com.wndexx.java3;

import com.wndexx.java2.Order;

public class SubOrder extends Order {
	
	public void method() {
		orderProtected = 1;
		orderPublic = 2;
		
		methodProtected();
		methodPublic();
		
		// 在不同包的子类中，不能调用 Order 类中声明为 private 和缺省权限的属性、方法
		// The field Order.orderDefault is not visible
		// orderDefault  = 3;
		//orderPrivate = 4;
		
		// The method methodDefault() from the type Order is not visible
		// methodDefault();
		// methodPrivate();
	}
}
