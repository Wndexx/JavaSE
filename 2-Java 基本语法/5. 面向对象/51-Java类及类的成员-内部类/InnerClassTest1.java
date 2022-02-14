package com.wndexx.java3;
// 开发中局部内部类的使用
public class InnerClassTest1 {

	// 开发中很少见
	public void method() {
		// 局部内部类
		class AA {

		}
	}

	// 返回一个实现了 Comparable 接口的类的对象
	public Comparable getComparable() {
			
		// 创建一个实现了 Comparable 接口的类: 局部内部类
		// 方式一：
		// class MyComparable implements Comparable {
		//	 @Override
		//	 public int compareTo(Object o) {
		// 		 return 0;
		//	 }
		// }
		// return new MyComparable();
		
		// 方式二：局部内部匿名实现类的匿名对象
		return new Comparable() {
			@Override
			public int compareTo(Object o) {
				return 0;
			}
		};
	}
}
