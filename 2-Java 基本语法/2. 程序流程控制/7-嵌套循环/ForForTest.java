/*
	嵌套循环
	
		外层循环 行数

		内层循环 列数


	System.currentTimeMills()  获取 当前时间戳	当前时间距 1970-01-01 00:00:00 毫秒数

*/
class ForForTest {
	public static void main(String[] args) {
		
		// ******
		// for (int i = 1; i <= 6; i++) {
		// 	System.out.print('*');
		// }


		/*
			******
			******
			******
			******
		*/
		// for (int i = 1; i <= 4; i++) {
		// 	for (int j = 1; j <= 6; j++) {
		// 		System.out.print('*');
		// 	}
		// 	System.out.println();
		// }


		/*				
						i (行号)		j (*的个数)		规律  j = i
			*			1 			1		
			** 			2 			2
			***			3			3
			****		4			4
			*****		5			5
		*/
		// i 行数 j 列数
		// for (int i = 1; i <= 5; i++) {
		// 	for (int j = 1; j <= i; j++) {
		// 		System.out.print('*');
		// 	}
		// 	System.out.println();
		// }


		/*	
						i 			j 				规律 j = 5 - i
			****		1			4
			***			2			3
			**			3			2
			*			4			1
		*/
		// for (int i = 1; i <= 4; i++) {
		// 	for (int j = 1; j <= 5 - i; j++) {
		// 		System.out.print('*');
		// 	}
		// 	System.out.println();
		// }


		/*

			*	
			** 	
			***	
			****
			*****
			****
			***	
			**	
			*	
		*/
		// // 上部分
		// for (int i = 1; i <= 5; i++) {
		// 	for (int j = 1; j <= i; j++) {
		// 		System.out.print('*');
		// 	}
		// 	System.out.println();
		// }
		// // 下部分
		// for (int i = 1; i <= 4; i++) {
		// 	for (int j = 1; j <= 5 - i; j++) {
		// 		System.out.print('*');
		// 	}
		// 	System.out.println();
		// }



		/*

			    *
			   * *
			  * * *
			 * * * *
			* * * * *
			 * * * *
			  * * *
			   * *
			    *
		*/
		/*
			// 上部分
			for (int i = 1; i <= 5; i++) {
				for (int j = 1; j <= 5 - i; j++) {
					System.out.print(' ');
				}
				for (int j = 1; j <= i; j++) {
					System.out.print("* ");
				}
				System.out.println();
			}
			// 下部分
			for (int i = 1; i <= 4; i++) {
				for (int j = 1; j <= i; j++) {
					System.out.print(' ');
				}
				for (int j = 1; j <= 5 - i; j++) {
					System.out.print("* ");
				}
				System.out.println();
			}
		*/


		/*
			
		      ******       ******          
		    **********   **********         
		  ************* *************		
		 *****************************     
		 *****************************     
		 *****************************	   
		  ***************************       
		    ***********************         
		      *******************          
		        ***************             
		          ***********             
		            *******                
		              ***                  
		               * 

		*/
		/*
			// 部分1
			for (int i = 1; i <= 3; i++) {
				if (i == 3) {
					System.out.print(' ');
					for (int j = 1; j <= 13; j++) {
						System.out.print('*');
					}
					System.out.print(' ');
					for (int j = 1; j <= 13; j++) {
						System.out.print('*');
					}
				} else {
						for (int j = 1; j <= 7 - 2 * i; j++) {
						System.out.print(' ');
					}

					for (int j = 1; j <= 2 + 4 * i; j++) {
						System.out.print('*');
					}

					for (int j = 1; j <= 11 - 4 * i; j++) {
						System.out.print(' ');
					}

					for (int j = 1; j <= 2 + 4 * i; j++) {
						System.out.print('*');
					}
				}
				System.out.println();
			}

			// 部分2
			for (int i = 1; i <= 3; i++) {
				for (int j = 1; j <= 29; j++) {
					System.out.print('*');
				}
				System.out.println();
			}

			// 部分3
			for (int i = 1; i <= 8; i++) {
				if (i == 8) {
					for (int j = 1; j <= 14 ; j++) {
						System.out.print(' ');
					}

					System.out.print('*');
				} else {
					for (int j = 1; j <= 2 * i - 1; j++) {
						System.out.print(' ');
					}

					for (int j = 1; j <= 31 - 4 * i; j++) {
						System.out.print('*');
					}
				}
				System.out.println();
			}
		*/


		// 九九乘法表
		// for (int i = 1; i <= 9; i++) {
		// 	for (int j = 1; j <= i; j++) {
		// 		System.out.print(i + " * " + j + " = " + i * j + "\t");
		// 	}
		// 	System.out.println();
		// }


		// 1000000 以内的所有质数
		// 优化前
		/*
			boolean flag = true;

			// 获取 当前时间戳	当前时间距 1970-01-01 00:00:00 毫秒数
			long start = System.currentTimeMillis();

			int count = 0; // 质数个数

			for (int i = 2; i <= 100000; i++) {

				for (int j = 2; j < i; j++) {
					if ( i % j == 0) {
						flag = false;
					}
				}
				if (flag) {
					// System.out.print(i + " ");
					count++;
				}
				// 重置
				flag = true;
			}

			// 获取 当前时间戳	当前时间距 1970-01-01 00:00:00 毫秒数
			long end = System.currentTimeMillis();

			System.out.println("质数个数：" + count);
			System.out.println("花费时间: " + (end - start) + "ms"); // 14332ms
		*/

		// 优化1
		/*
			boolean flag = true;

			// 获取 当前时间戳	当前时间距 1970-01-01 00:00:00 毫秒数
			long start = System.currentTimeMillis();

			int count = 0; // 质数个数

			for (int i = 2; i <= 100000; i++) {

				// 优化二：对指数有效  Math.sqrt() 开方
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if ( i % j == 0) {
						flag = false;
						break; // 优化一：对非质数有效
					}
				}
				if (flag) {
					// System.out.print(i + " ");
					count++;
				}
				// 重置
				flag = true;
			}

			// 获取 当前时间戳	当前时间距 1970-01-01 00:00:00 毫秒数
			long end = System.currentTimeMillis();

			System.out.println("质数个数：" + count);
			System.out.println("花费时间: " + (end - start) + "ms"); // 优化前：14332ms 优化一：break 1150ms   优化一 + 优化二：12ms
		*/

		// 优化2
		long start = System.currentTimeMillis();
		
		int count = 0;
		label:for (int i = 2; i <= 100000; i++) {
					for (int j = 2; j <= Math.sqrt(i); j++) {
						if ( i % j == 0) {
							continue label;
						}
					}
					// 能执行到此步骤的，都是质数
					count++;
				}

		long end = System.currentTimeMillis();

		System.out.println("质数个数：" + count);
		System.out.println("花费时间: " + (end - start) + "ms"); // 优化前：14332ms 优化一：break 1150ms   优化一 + 优化二：12ms
		

	}
}