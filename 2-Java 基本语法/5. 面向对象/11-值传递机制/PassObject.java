package com.wndexx.exer1;
/*
	考查参数的值传递
	
	（1）定义一个 Circle 类，包含一个 double 型的 radius 属性代表圆的半径，一个 findArea() 方法返回圆的面积。
	
	（2）定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下：public void printAreas(Circle c, int time)
	
		在 printAreas 方法中打印输出1到 time 之间的每个整数半径值，以及对应的面积。例如，time 为5，则输出半径1，2，3，4，5，以及对应的圆面积。
		
	（3）在main方法中调用printAreas()方法，调用完毕后输出当前半径值。程序运行结果如图所示
	
*/

public class PassObject {

	public static void main(String[] args) {

		PassObject test = new PassObject();
		Circle c = new Circle();

		test.printAreas(c, 5);

		System.out.println("Now radius is " + c.radius);
	}

	public void printAreas(Circle c, int time) {

		String str = "Radius\tArea\n";
		
		int i = 1;
		for (; i <= time; i++) {
			// 设置圆的半径
			c.radius = i;
			str += c.radius + "\t" + c.findArea() + "\n";
		}
		
		c.radius = i;

		System.out.println(str);
	}
}