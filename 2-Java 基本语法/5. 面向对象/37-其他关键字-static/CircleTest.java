package com.wndexx.java1;

// static 关键字的应用
public class CircleTest {
	public static void main(String[] args) {
		
		Circle c1 = new Circle();
		Circle c2 = new Circle();
		Circle c3 = new Circle(3.4);
		
		System.out.println("c1 的 id: " + c1.getId()); // 1001
		System.out.println("c2 的 id: " + c2.getId()); // 1002
		System.out.println("c3 的 id: " + c3.getId()); // 1003
		
		System.out.println("创建的圆的个数为：" + Circle.getTotal()); // 3
	}
}

class Circle {

	private double radius;
	private int id; // 自动赋值
	
	private static int total; // 创建的圆的个数
	private static int init = 1001; // static 声明的属性被所有对象所共享

	public Circle() {
		id = init++;
		total++;
	}
	
	public Circle(double radius) {
		this();
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public int getId() {
		return id;
	}
	
	public static int getTotal() {
		return total;
	}

	public double findArea() {
		return 3.14 * radius * radius;
	}
}
