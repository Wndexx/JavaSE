package com.wndexx.exer;

/*
 
	 使用简单数组
	 (1) 创建名为 ArrayTest 的类，在 main() 方法中声明 array1 和 array2两个变量，它们是 int[] 类型的数组
	 (2) 使用大括号 {}，把 array1 初始化为 8 个 素数：2 3 5 7 11 13 17 19
	 (3) 显示 array1 的内容
	 (4) 赋值 array2 变量等于 array1，修改 array2 中的偶数索引元素，使其值等于索引值（如 array[0] = 0， array2 = 2）。打印 array1
	 
	 思考：array1 和 array2 是什么关系？ array1 和 array2 地址值相同，都指向了堆空间中的唯一的一个数组实体
	 
	 拓展：修改题目，实现 array2 对 array1 数组的复制
	 
 */
public class ArrayDemo4 {
	public static void main(String[] args) {

		// 1. 声明 array1 和 array2两个变量，它们是 int[] 类型的数组
		int[] array1, array2;

		// 2. array1 初始化为 8 个素数：2 3 5 7 11 13 17 19
		// array2 长度初始化为 array1 的长度
		array1 = new int[] { 2, 3, 5, 7, 11, 13, 17, 19 };
		array2 = new int[array1.length];

		// 3. 实现 array2 对 array1 数组的复制
		for (int i = 0; i < array2.length; i++) {
			array2[i] = array1[i];
		}

		// 4. 修改 array2 中的偶数索引元素，使其值等于索引值
		for (int i = 0; i < array2.length; i++) {
			if (i % 2 == 0) {
				array2[i] = i;
			}
		}

		// 5. 打印 array1
		// array1 的元素也发生了改变
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + "\t");
		}
		System.out.println();
		
		for (int i = 0; i < array2.length; i++) {
			System.out.print(array2[i] + "\t");
		}
		System.out.println();

	}

}
