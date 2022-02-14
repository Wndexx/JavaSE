package com.wndexx.exer4;
/*
	定义一个接口用来实现两个对象的比较。
	interface CompareObject{
		public int compareTo(Object o); //若返回值是 0, 代表相等; 若为正数,代表当前对象大;负数代表当前对象小
	}
*/
public interface CompareObject {
	/**
	 * @Description 返回值为 0，代表相等；若为正数，代表当前对象大；负数代表当前对象小
	 * @author wndexx
	 * @date 2022年2月14日上午10:09:21
	 * @param o
	 * @return
	 */
	public int compareTo(Object o);
}
