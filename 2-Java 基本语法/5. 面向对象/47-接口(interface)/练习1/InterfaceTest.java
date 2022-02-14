package com.wndexx.exer4;
// 定义一个测试类InterfaceTest，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。
public class InterfaceTest {
	public static void main(String[] args) {
		
		ComparableCircle c1 = new ComparableCircle(1.0);
		ComparableCircle c2 = new ComparableCircle(2.0);
		
		System.out.println(c1.compareTo(c2));
		
		// int compareValue1 = c1.compareTo(new String("aa"));
		// System.out.println(compareValue1); // 传入的数据类型不匹配
		
		ComparableRectangle r1 = new ComparableRectangle(1.0, 2.0);
		ComparableRectangle r2 = new ComparableRectangle(1.0, 2.0);
		
		System.out.println(r1.compareTo(r2));
	}
}
