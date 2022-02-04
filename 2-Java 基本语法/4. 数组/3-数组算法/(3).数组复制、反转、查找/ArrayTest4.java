package com.wndexx.java;

/*
 * 算法的考察：数组的复制、反转、查找（线性查找、二分法查找）
 * 
 */
public class ArrayTest4 {
	public static void main(String[] args) {

		String[] arr = new String[] { "JJ", "DD", "MM", "BB", "GG", "AA" };

		// 1. 数组的复制（区别于数组变量的赋值：arr1 = arr）
		String[] arr1 = new String[arr.length];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = arr[i];
		}

		// 2. 数组的反转
		// 方法1
		// for (int i = 0; i < arr.length / 2; i++) {
		// 	String temp = arr[i];
		// 	arr[i] = arr[arr.length - 1 - i];
		// 	arr[arr.length - 1 - i] = temp;
		// }

		// 方法2
		// for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
		// 	String temp = arr[i];
		// 	arr[i] = arr[j];
		// 	arr[j] = temp;
		// }

		// 遍历
		// for (int i = 0; i < arr.length; i++) {
		// 	System.out.print(arr[i] + " ");
		// }
		// System.out.println();

		// 3. 查找（搜索）
		// （1） 线性查找
		// String dest = "BB";
		// int index = -1;
		// for (int i = 0; i < arr.length; i++) {
		// 	if (dest.equals(arr[i])) {
		// 		index = i;
		// 		break;
		// 	}
		// }

		// if (index == -1) {
		// 	System.out.println("指定元素不存在");
		// } else {
		// 	System.out.println("指定元素存在，位置为：" + index);
		// }

		// （2）二分法查找
		int[] arr2 = new int[] { -56, -34, -1, 12, 23, 65 };

		int dest1 = 12;
		int index1 = -1;

		int start = 0, end = arr2.length - 1;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (dest1 == arr2[middle]) {
				index1 = middle;
				break;
			} else if (dest1 > arr2[middle]) {
				start = middle + 1;
			} else {
				end = middle - 1;
			}
		}
		
		if (index1 == -1) {
			System.out.println("指定元素不存在");
		} else {
			System.out.println("指定元素存在，位置为：" + index1);
		}

	}
}
