/*
	循环结构
	
		四要素

			初始化条件

			循环条件   	boolean

			循环体

			迭代条件

	for 循环

		for(初始化条件; 循环条件; 迭代条件) {

				循环体；
		}
	


*/
import java.util.Scanner;
class ForTest {
	public static void main(String[] args) {

		for (int i = 0; i < 4; i++ ) {
			System.out.println("Hello World!");
		}

		// 练习
		int num = 1;
		for (System.out.println('a'); num <= 3; System.out.println('c'), num++) {
			System.out.println('b');
		} // abcbcbc


		// 例题 
		// 遍历 100 以内的偶数 
		// for (int i = 0; i <= 100; i+=2) {
		// 	System.out.println(i);
		// }

		// 输出偶数之和
		// 输出偶数个数
		int sum = 0;
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum += i;
				count++;
			}
		}
		System.out.println(sum);
		System.out.println(count);


		// 例题
		// 1. 1 ~ 150 换行打印每个值   
		// 3的倍数后加 "foo"	 
		// 5的倍数后加 "biz" 
		// 7的倍数后加 "baz"
		String str;
		for (int i = 1; i <= 150; i++) {
			str = "";
			str += i;
			str += i % 3 == 0 ? " foo" : "";
			str += i % 5 == 0 ? " biz" : "";
			str += i % 7 == 0 ? " baz" : "";
			System.out.println(str);
		}


		// 2. 正整数 m 和 n 的最大公约数 和 最小公倍数
		// m * n = gcd * lcm000000000000000000000000000000000000000000000000000000000000000000000
		/*
			Scanner scan = new Scanner(System.in);

			System.out.println("正整数m");
			int m = scan.nextInt();

			System.out.println("正整数n");
			int n = scan.nextInt();

			// 比较 m 和 n 的大小
			int max, min;
			max = m >= n ? m : n;
			min = m <= n ? m : n;

			int gcd = 1;
			int lcm = m * n;

			// 最大公约数
			// break 跳出循环
			for (int i = min; i >= 1; i--) {
				if (m % i == 0 && n % i == 0) {
					gcd = i;
					break;
				} 
			}

			// 最小公倍数
			for (int i = max; i <= m * n; i++) {
				if (i % m == 0 && i % n == 0 ) {
					lcm = i;
					break;
				}
			}

			System.out.println(m + "和" + n + "的最大公约数是 " + gcd + "，最小公倍数是 " + lcm);
		*/


		// 3. 1 ~ 100 奇数和
		// oddSum 需赋初值		不赋初值编译通过情况 使用前的分支结构在任意条件表达式下，该变量都会被赋值 ！！！
		int oddSum = 0;
		for (int i = 1; i <= 100; i++) {
			oddSum += i % 2 == 0 ? 0 : i;
		}
		System.out.println(oddSum);


		// 4. 1 ~ 100 7的倍数 个数 总和
		int sevenSum = 0;
		int sevenCount = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 7 == 0) {
				sevenSum += i;
				sevenCount++;
			}
		}
		System.out.println(sevenSum + " " + sevenCount);


		// 5. 输出水仙花数
		//  水仙花数 3位数 各个位数立方之和等于本身
		for (int i = 100; i<= 999; i++) {
			int h = i / 100;
			int t = i % 100 / 10;
			int o = i % 10; 
			if (i == h * h * h + t * t * t + o * o * o) {
				System.out.println(i);
			}
		}

	}
}

	