/*
	1. 使用冒泡排序，实现如下的数组从小到大排序

	   int[] arr = new int[]{34, 5, 22, -98, 6, -76, 0, -3};
	   
	   for(int i = 0; i < arr.length - 1; i++){
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]){
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = arr[j];
				}
			}
	   }


	2. 如何反转上面的数组。请用代码实现

	 	for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
	 	}

	
	3. 复制上述数组，得到一个新数组

		int[] arr1 = new int[arr.length];
		for(int i = 0; i < arr1.length; i++){
			arr1[i] = arr[i];
		}
	

	4. 使用线性查找，从上述数组中查找 22 是否存在。存在，返回所在位置的索引。不存在，输出提示信息。

		int index = -1;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 22) {
				index = i;
				break;
			}if
		}
		if(index == -1) {
			System.out.println("指定数值不存在");
		}else {
			System.out.println("指定数值的元素存在，位置为：" + index);
		}


	5. 数组中常见的异常有哪些？请举例说明

		(1) 数组角标越界异常  ArrayIndexOutOfBoundsException

			int[] arr = new int[3];
			System.out.println(arr[-1]);

		(2) 空指针异常 NullPointerException

			int[][] arr = new int[3][];
			System.out.println(arr[0][0]);


*/