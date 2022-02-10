package com.wndexx.exer1;

public class CylinderTest {

	public static void main(String[] args) {

		Cylinder cl = new Cylinder();

		cl.setRadius(2);
		cl.setLength(2);

		double vol = cl.findVolume();
		System.out.println("体积：" + vol);

		// 没有重写 findArea() 时
		// double area = cl.findArea();
		// System.out.println("底面积：" + area);

		// 重写 findArea() 以后
		double area = cl.findArea();
		System.out.println("圆柱的表面积：" + area);

		System.out.println("*************************");

		Cylinder c2 = new Cylinder();
		double vol2 = c2.findVolume();
		System.out.println("体积：" + vol2);
	}
}
