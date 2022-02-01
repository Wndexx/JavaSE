/*
	死循环 

		while (true) {
	
		}

		for (;;) {
	
		}

	break 跳出循环

*/

import java.util.Scanner;
class ForWhileTest {
	public static void main(String[] args) {
		
		// 例题
		// 1
		// 输入个数不确定整数 判断 正数 负数个数  0 结束程序
		
			int positiveNumber = 0;
			int negativeNumber = 0;

			Scanner scan = new Scanner(System.in);

			// while (true) {
			// 	int num = scan.nextInt();

			// 	if (num > 0) {
			// 		positiveNumber++;				
			// 	} else if (num < 0) {
			// 		negativeNumber++;
			// 	} else {
			// 		break;
			// 	}
			// }

			for (;;) {
				int num = scan.nextInt();

				if (num > 0) {
					positiveNumber++;		
				} else if (num < 0) {
					negativeNumber++;
				} else {
					break;
				}
				
			}

			System.out.println("正数个数: " + positiveNumber + " 负数个数: " + negativeNumber);


		// 2



	}
}