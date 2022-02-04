/*
	do-while 循环

		初始化条件;

		do {
		
			循环体;

			迭代条件;

		} while (循环条件);

	至少执行一次循环体

*/
import java.util.Scanner;
class DoWhileTest {
	public static void main(String[] args) {
		
		// 遍历 100 以内的偶数 计算总和 个数
		/*
			int sum = 0;
			int count = 0;

			int num = 1;
			do {
				if (num % 2 == 0) {
					System.out.println(num);
					sum += num;
					count++;
				}
				num++;
			} while (num <= 100);

			System.out.println(sum + " " + count);
		*/


		System.out.println("----------------------------------------");


		int number1 = 10;
		while (number1 > 10) {
			System.out.println("hello:while");
			number1--;
		}

		int number2 = 10;
		do {
			System.out.println("hello:do-while");
			number2--;
		} while (number2 > 10);


	}
}