package com.wndexx.exer4;

/*
	定 义 一 个ComparableCircle 类 ，继 承 Circle 类 并且 实 现 CompareObject 接 口 。 
	在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小
 */
public class ComparableCircle extends Circle implements CompareObject {

	public ComparableCircle(double radius) {
		super(radius);
	}

	@Override
	public int compareTo(Object o) {
		if (this == o)
			return 0;
		if (o instanceof ComparableCircle) {
			
			// 错误的：
			// return (int)(this.getRadius() - ((ComparableCircle) o).getRadius());
			
			// 正确的：
			// 方式一:
			// if (this.getRadius() - ((ComparableCircle) o).getRadius() > 0)
			//	 return 1;
			// else if (this.getRadius() - ((ComparableCircle) o).getRadius() == 0)
			//	 return 0;
			// else
			//	 return -1;
			// 方式二：
			// 当属性 radius 声明为 Double 类型时，可以调用包装类的方法 compareTo
			return this.getRadius().compareTo(((ComparableCircle) o).getRadius());
		}
		throw new RuntimeException("传入的数据类型不匹配");
	}
}
