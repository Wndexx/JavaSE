package com.wndexx.exer1;

/**
 * 
 * @Description Circle 类
 * @author wndexx
 * @version
 * @date 2022年2月6日下午7:40:15
 *
 */
public class Circle {
	/**
	 * 半径
	 */
	double radius;

	/**
	 * 
	 * @Description 获得圆的面积
	 * @author wndexx
	 * @date 2022年2月6日下午7:41:17
	 * @return
	 *
	 */
	public double findArea() {
		return Math.PI * radius * radius;
	}
}
