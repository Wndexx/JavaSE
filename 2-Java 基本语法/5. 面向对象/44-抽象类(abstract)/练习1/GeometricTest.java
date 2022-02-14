package com.wndexx.exer;

/*
	定义三个类，父类GeometricObject代表几何形状，子类Circle代表圆形，MyRectangle代表矩形。
	
	定义一个测试类GeometricTest，
	编写equalsArea方法测试两个对象的面积是否相等（注意方法的参数类型，利用动态绑定技术），
	编写displayGeometricObject方法显示对象的面积（注意方法的参数类型，利用动态绑定技术）。
 */
public class GeometricTest {
	public static void main(String[] args) {

		GeometricTest test = new GeometricTest();

		Circle c = new Circle(1.0, "black", 1.0);
		MyRectangle r = new MyRectangle(2.0, 2.0, "white", 1.0);

		test.displayGeometricObject(c);
		test.displayGeometricObject(r);

		System.out.println("c 和 r 的面积是否相等：" + test.equalsArea(c, r));
	}

	// 测试两个对象的面积是否相等
	public boolean equalsArea(GeometricObject o1, GeometricObject o2) {
		return o1.findArea() == o2.findArea();
	}

	// 显示对象的面积
	public void displayGeometricObject(GeometricObject o) { // GeometricObject o = new Circle(...);
		System.out.println("面积为：" + o.findArea());
	}
}
