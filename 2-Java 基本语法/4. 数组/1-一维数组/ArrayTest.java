/*
	数据结构

		数据之间的逻辑关系	集合	  一对一  一对多  多对多

		数据的存储结构

			线性表： 顺序表（数组）链表 栈 队列

			树形结构：二叉树

			图形结构

	算法

		排序算法

		搜索算法

		
	数组

 		1.数组的理解：

 			数组(Array)，是多个相同类型数据按一定顺序排列的集合，并使用一个名字命名，并通过编号的方式对这些数据进行统一管理。
 			
 
 		2.数组相关的概念：

	 		(1) 数组名

	 		(2) 元素

	 		(3) 角标、下标、索引

	 		(4) 数组的长度：元素的个数

 
 		3.数组的特点：

			(1) 数组是有序排列的

			(2) 数组属于引用数据类型的变量。数组的元素，既可以是基本数据类型，也可以是引用数据类型

			(3) 创建数组对象会在内存中开辟一整块连续的空间

			(4) 数组的长度一旦确定，就不能修改。
			
 
 		4. 数组的分类：

	   		(1) 按照维数：一维数组、二维数组、。。。

	   		(2) 按照数组元素的类型：基本数据类型元素的数组、引用数据类型元素的数组

 
 		5. 一维数组的使用

			(1) 一维数组的声明和初始化

			(2) 如何调用数组的指定位置的元素

			(3) 如何获取数组的长度

			(4) 如何遍历数组

			(5) 数组元素的默认初始化值：

				1) 数组元素是整型：0

				2) 数组元素是浮点型：0.0

				3) 数组元素是char型：0或'\u0000'，而非'0'

				4) 数组元素是boolean型：false

				5) 数组元素是引用数据类型：null


		6. 数组的内存解析

			(1) 栈 stack		存放 局部变量
			
 			(2) 堆 heap		存放 new出来的结构：对象 数组
 			
 			(3) 方法区 method area
 			
 				常量池	String
 				
 				静态域	static
 	
*/
public class ArrayTest {

	public static void main(String[] args) {

		// 1. 一维数组 声明 初始化
		int[] ids; // 声明
		// (1) 静态初始化 数组初始化 和 数组元素赋值 同时进行
		ids = new int[] { 1001, 1002, 1003, 1004, 1005 }; // 这里不能省略 new int[]

		// (2) 动态初始化 数组初始化 和 数组元素赋值 分开进行
		String[] names = new String[5];

		// 错误写法
		// int[] arr1 = new int[];
		// int[5] arr2 = new int[];
		// int[] arr3 = new int[3]{1,2,3};

		// 正确写法
		// int[] arr4 = { 1, 2, 3 }; // 类型推断 可省略 new int[]

		// 总结 数组一旦初始化完成 其长度确定

		// 2. 调用数组指定位置元素 索引调用
		// 索引从 0 开始 长度-1 结束
		// 编译 字节码文件 运行 加载至内存 执行
		names[0] = "张三";
		names[1] = "李四";
		names[2] = "王五";
		names[3] = "赵六";
		names[4] = "张三三"; // charAt(0)
		// names[5] = "张三四";

		// 3. 获取数组长度 属性: length
		System.out.println(names.length); // 5
		System.out.println(ids.length);

		// 4. 遍历数组
		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}

		// 5. 数组元素默认初始化值
		int[] arr = new int[4];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

		System.out.println("****************************");

		short[] arr1 = new short[4];
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}

		System.out.println("****************************");

		float[] arr2 = new float[5];
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		System.out.println("****************************");

		char[] arr3 = new char[5];
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("----" + arr3[i] + "----");
		}
		if (arr3[0] == 0) {
			System.out.println("你好");
		}

		System.out.println("****************************");

		boolean[] arr4 = new boolean[2];
		System.out.println(arr4[0]);

		System.out.println("****************************");

		String[] arr5 = new String[5];
		System.out.println(arr5[0]);
		if (arr5[0] == null) {
			System.out.println("哈哈");
		}
		if (arr5[0] == "null") {
			System.out.println("哈");
		}

		// 6. 内存解析

	}

}
