package com.wndexx.exer;

/*
 * 练习2
 * 2. 利用面向对象的编程方法，设计类Circle计算圆的面积。
 */
public class CircleTest {
	public static void main(String[] args) {
		
		Circle c1 = new Circle();
		
		c1.radius = 3.0;
		
		// 对应方式1：
		// double area = c1.findArea();
		// System.out.println("c1 的面积为：" + area);
		
		// 对应方式2：
		c1.findArea();
		
		// 对应错误情况
		// double area = c1.findArea(3.4);
		// System.out.println(area);
	}
}

// 圆
class Circle{
	// 属性
	double radius;
	
	// 求圆的面积的方法
	// 方式1：
	// public double findArea() {
	//	double area = Math.PI * radius * radius;
	//	return area;
	// }
	
	// 方式2：
	public void findArea() {
		double area = Math.PI * radius * radius;
		System.out.println("面积为：" + area);
	}
	
	// 错误情况
	public double findArea(double r) {
		double area = Math.PI * r * r;
		return area;
	}
}