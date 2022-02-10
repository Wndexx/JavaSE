package com.wndexx.exer;

import java.util.Arrays;

/*
 * 网红题2
 * 微软：定义一个 int 型的数组：int[] arr = new int[]{12, 3, 3, 34, 56, 77, 432};
 * 	   让数组的每个位置上的值去除以首位置的元素，得到的结果作为该位置上的新值。遍历新的数组
 * 
 */
public class ValueTransferExer2 {
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{12, 3, 3, 34, 56, 77, 432};
		
		// 方法1：
		int el = arr[0];
		for(int i = 0;i < arr.length;i++) {
			arr[i] = arr[i] / el;
		}
		
		// 方法2：
		// for(int i = arr.length - 1;i >= 0;i--) {
		// 	arr[i] = arr[i] / arr[0];
		// }
		
		System.out.println(Arrays.toString(arr));
	}
}
