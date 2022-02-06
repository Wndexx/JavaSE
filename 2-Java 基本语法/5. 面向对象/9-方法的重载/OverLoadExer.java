package com.wndexx.exer;
/*
	1. 编写程序，定义三个重载方法并调用。方法名为mOL。
	
	(1) 三个方法分别接收一个int参数、两个int参数、一个字符串参数。
	
	(2) 分别执行平方运算并输出结果，相乘并输出结果，输出字符串信息。
	
	(3) 在主类的 main() 方法中分别用参数区别调用三个方法。
	
	2. 定义三个重载方法max()
	
	(1) 第一个方法求两个int值中的最大值
	
	(2) 第二个方法求两个double值中的最大值
	
	(3) 第三个方法求三个double值中的最大，
	
	(4) 分别调用三个方法。
 */
public class OverLoadExer {
	public static void main(String[] args) {
		
		OverLoadExer ole = new OverLoadExer();
		
		int n = 1;
		int res1 = ole.mOL(1);
		System.out.println(res1);
		
		int m = 2;
		int res2 = ole.mOL(n,m);
		System.out.println(res2);
		
		String s = "hello world";
		ole.mOL(s);
		
	}
	
	// 1. 如下的三个方法构成重载
	public int mOL(int i) {
		// return i * i;
		return mOL(i,i);
	}
	
	public int mOL(int i,int j) {
		return i * j;
	}
	
	public void mOL(String s) {
		System.out.println(s);
	}
	
	// 2. 如下的三个方法构成重载
	public int max(int i,int j) {
		 return i > j ? i : j;
	}
	
	public double max(double d1,double d2) {
		return d1 > d2 ? d1 : d2;
	}
	
	public double max(double i,double j,double k) {
		return max(max(i,j), k);
	}
}


































