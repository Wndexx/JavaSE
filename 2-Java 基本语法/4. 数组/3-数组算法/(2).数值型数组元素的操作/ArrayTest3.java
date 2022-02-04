package com.wndexx.java;

/*
	算法的考察：求数值型数组中元素的最大值、最小值、平均值、总和等
	
	定义一个int型的一维数组，包含 10 个元素，分别赋一些随机整数，
	然后求出所有元素的最大值、最小值、和值、平均值
	要求：所有随机数都是两位数
	
	[m,n] 内随机数 
	公式：(int)(Math.random * (n + 1 - m) + m)
	
 */
public class ArrayTest3 {
	public static void main(String[] args) {

		// 1. 定义一个int型的一维数组，包含 10 个元素，分别赋一些随机整数，所有随机数都是两位数
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 90 + 10);
		}
		
		// 遍历数组
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// 2. 求数组元素的最大值
		// maxValue 不要赋初值为 0，如果数组元素最大值为负数，会导致结果出错
		int maxValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (maxValue < arr[i]) {
				maxValue = arr[i];
			}
		}
		System.out.println("最大值为：" + maxValue);

		// 3. 求数组元素的最小值
		// minValue 不要赋初值为 0，如果数组元素最小值为正数，会导致结果出错
		int minValue = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (minValue > arr[i]) {
				minValue = arr[i];
			}
		}
		System.out.println("最小值为：" + minValue);

		// 4. 求数组元素的总和
		int sum = 0;
		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println("总和为：" + sum);

		// 5. 求数组元素的平均值
		int avgValue = 0;
		avgValue = sum / arr.length;
		System.out.println("平均值为：" + avgValue);
	}
}
