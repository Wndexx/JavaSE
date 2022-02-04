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
public class ArrayDemo3 {
	public static void main(String[] args) {

		// 1. 声明 array1 和 array2两个变量，它们是 int[] 类型的数组
		int[] array1, array2;

		// 2. array1 初始化为 8 个素数：2 3 5 7 11 13 17 19
		// 每 new 一次，堆空间中多一个数组
		array1 = new int[] { 2, 3, 5, 7, 11, 13, 17, 19 };

		// 3. 显示 array1 的内容
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + "\t");
		}
		System.out.println();

		// 4. 赋值 array2 变量等于 array1
		// 不能称作数组的复制
		// 这里只是把 array1 的地址值赋值给 array2，array1 和 array2 指向同一个数组
		array2 = array1;

		// 5. 修改 array2 中的偶数索引元素，使其值等于索引值
		for (int i = 0; i < array2.length; i++) {
			if (i % 2 == 0) {
				array2[i] = i;
			}
		}

		// 6. 打印 array1
		// array1 的元素也发生了改变
		for (int i = 0; i < array1.length; i++) {
			System.out.print(array1[i] + "\t");
		}
		System.out.println();
		
	}

}
