/*
	案例

	控制台输入成绩

	成绩 100  A

	(80,99]   B

	[60,80]	  C

	其它		  D
*/

import java.util.Scanner;
class IfTest2 {
	public static void main(String[] args) {
		
		// 控制台输入成绩
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入成绩：（0 ~ 100）");
		double score = scan.nextDouble();

		// 判断成绩
		if (score == 100) {
			System.out.println("A");
		} else if (score > 80) {
			System.out.println("B");
		} else if (score >= 60) {
			System.out.println("C");
		} else {
			System.out.println("D");
		}
	}
}