/*
	1. 一维数组初始化

		静态初始化  int[] arr = new int[]{1, 2, 3};

		动态初始化  int[] arr = new int[3];

	2. 二维数组初始化

		静态初始化  int[][] arr = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8, 9}}; 

		动态初始化  int[][] arr = new int[3][2];

				   int[][] arr = new int[3][];

	3. 遍历二维数组 int[][] arr = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}}; 

		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	4. 一维数组默认初始化值

		基本类型

			整型 	0

			浮点型  	0

			字符型 	'\u0000'

			boolean false

		引用类型  null

	5. 一维数组内存解析

		String[] strs = new String[5];
		strs[2] = “Tom”;
		strs = new String[3];

		(1) 栈内存存放 strs   堆内存存放数组    strs 存放 数组首地址

		(2) 数组第三个元素赋值 "Tom"

		(3) 堆内存创建新数组   strs 存放新数组首地址

*/