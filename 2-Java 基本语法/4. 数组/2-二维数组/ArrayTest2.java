/*
	二维数组
	
		理解
	
			一个数组是另一个数组的元素   元素是一维数组的一维数组
			
			根据数组底部运行机制，没有多维数组
			
		使用
		
			1. 声明 初始化
	 		
	 		2. 调用指定位置元素
	 		
	 		3. 获取长度
	 		
	 		4. 遍历数组
	 		
	 		5. 数组元素默认初始化值 
	 		
			 		 	规定：外层数组的元素 内层数组的元素
			 		 	
				 		 	int[][] arr = new int[4][3];
				 		 	
				 		    外层元素：arr[0] arr[1] ...
				 		    
				 		    内层元素：arr[0][0] arr[0][1] ...
	 		
		 		初始化方式一 int[][] arr = new int[4][3]
		 		
			 		外层元素  内部数组首地址   
			 		
			 		内层元素
			 		
				 		基本数据类型
				 		
				 			整型   		0
				 			
				 			浮点型  		0.0
				 			
				 			char  		0 ASCII码 '\u0000'    非 '0'   非 ' '
				 			
				 			boolean		false
				 			
				 		引用数据类型	    null   非 "null"
				 
				初始化方式二 int[][] arr = new int[4][]
				
					外层元素 null
					
					内层元素 NullPointerException 空指针异常
				 		
	 		6. 内存解析
			
		
*/
public class ArrayTest2 {
	public static void main(String[] args) {

		// 1. 二维数组 声明 初始化
		// 静态初始化
		int[][] arr1 = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
		// 动态初始化1
		String[][] arr2 = new String[3][2];
		// 动态初始化2
		String[][] arr3 = new String[3][];

		// 错误
		// String[][] arr4 = new String[][4];
		// int[][] arr6 = new int[4][3] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };

		// 正确
		// int arr4[][] = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
		// int[] arr5[] = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
		// int[] arr6[] = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };

		// 2. 调用指定位置元素
		System.out.println(arr1[0][1]); // 2
		System.out.println(arr2[1][1]); // null

		// System.out.println(arr3[1][0]); // NullPointerException 空指针异常
		arr3[1] = new String[4];
		System.out.println(arr3[1][0]); // null
		
		System.out.println("************************************");

		// 3. 获取数组长度
		System.out.println(arr1.length); // 3
		System.out.println(arr1[0].length); // 3
		System.out.println(arr1[1].length); // 2
		
		System.out.println("************************************");

		// 4. 遍历
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.print(arr1[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println("************************************");

		// 5. 数组元素默认初始化值
		int[][] arr4 = new int[4][3];
		System.out.println(arr4);       // 地址值 [[I@15db9742
		System.out.println(arr4[0]);    // 地址值 [I@6d06d69c
		System.out.println(arr4[0][0]); // 0

		System.out.println("************************************");

		float[][] arr5 = new float[4][3];
		System.out.println(arr5);       // 地址值 [[F@7852e922
		System.out.println(arr5[0]);    // 地址值 [F@4e25154f
		System.out.println(arr5[0][0]); // 0.0

		System.out.println("************************************");

		String[][] arr6 = new String[4][2];
		System.out.println(arr6[1]);    // 地址值 [Ljava.lang.String;@70dea4e
		System.out.println(arr6[1][1]); // null

		System.out.println("************************************");
		
		double[][] arr7 = new double[4][];
		System.out.println(arr7[1]);       // null
		// System.out.println(arr7[1][1]); // NullPointerException 空指针异常
		
	}
}
