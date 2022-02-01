/*

						使用范围			不同点			 相同点

		break 			switch-case		结束当前循环		 
						循环结构							后面不能声明执行语句 编译不通过

		continue     	循环结构			结束当次循环


	
	break 		默认跳出最近一层循环  	跳出指定循环 添加标签 	

	continue 	默认跳出最近一层循环当次  跳出指定循环 添加标签 


*/
class BreakContinueTest {
	public static void main(String[] args) {

		/* 1. 单层循环 */
		
		for (int i = 1; i <= 10; i++) {
			if (i % 4 == 0) {
				break;
				// System.out.println("哈哈哈哈哈"); // 编译不通过
			}
			System.out.print(i); // 123       			编译通过
		}
		System.out.println();


		System.out.println("-----------------------------");


		for (int i = 1; i <= 10; i++) {
			if (i % 4 == 0) {
				continue;
				// System.out.println("哈哈哈哈哈"); // 	编译不通过
			}
			System.out.print(i); // 123567910  			编译通过
		}
		System.out.println();


		System.out.println("-----------------------------");


		/* 2. 嵌套循环 */

		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 10; j++) {
				if (j % 4 == 0) {
					break; // 默认跳出包裹此关键字最近一层循环
				}
				System.out.print(j);
			}
			System.out.println();
		}
		

		System.out.println("-----------------------------");


		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 10; j++) {
				if (j % 4 == 0) {
					continue;  // 默认跳出包裹此关键字最近一层循环的当次循环
				}
				System.out.print(j);
			}
			System.out.println();

		}


		System.out.println("-----------------------------");


		/* 3. 结束指定循环 */

		label:for (int i = 1; i <= 4; i++) {
					for (int j = 1; j <= 10; j++) {
						if (j % 4 == 0) {
							break label;  // 结束指定标识循环
						}
						System.out.print(j);
					}
					System.out.println();
				}
		System.out.println();


		System.out.println("-----------------------------");


		label:for (int i = 1; i <= 4; i++) {
					for (int j = 1; j <= 10; j++) {
						if (j % 4 == 0) {
							continue label;  // 结束指定标识循环的当此循环
						}
						System.out.print(j);
					}
					System.out.println();
				}
		System.out.println();


		System.out.println("-----------------------------");



	}
}