/*
	随机数生成  [a,b] 范围

		公式

			(int)(Math.random()*(b - a + 1) + a)

	
	str1.equals(str2) 字符串相等判断

*/

import java.util.Scanner;
class IfExer {
	public static void main(String[] args) {
		// 1. 控制台输入狗的年龄，输出相当于人类的年龄
		// 	前两年每年相当于人类的 10.5 岁  之后每年相当于 4 岁
		/*
			Scanner scan = new Scanner(System.in);
			System.out.println("请输入狗的年龄：");
			int dogAge = scan.nextInt();
			double humanAge;

			if (dogAge < 0) {
				System.out.println("请输入正确的年龄");
			} else if (dogAge <= 2) {
				humanAge = dogAge * 10.5;
			} else {
				humanAge = 2 * 10.5 + (dogAge - 2) * 4;
			}

			System.out.println("相当于人类的年龄： " + humanAge);
		*/


		// 2. 控制台输入一个两位数 和 程序随机生成的两位数比较
		// 	完全匹配 10000
		// 	数字一致 顺序不同 3000
		// 	仅有一个数字 完全匹配 1000
		// 	仅有一个数字值匹配 500
		// 	完全不匹配 作废
		// 	生成随机数 Math.random() [0,1) 	(int)Math.random()*90 + 10  [10,99]

		// 生成 随机两位数 [10,99]
		/*
			int randomNum = (int)(Math.random() * 90 + 10) ;

			Scanner scan = new Scanner(System.in);
			System.out.println("请输入随机两位数");
			int inputNum = scan.nextInt();

			int inputTen = inputNum / 10, inputSingle = inputNum % 10;
			int randomTen = randomNum / 10, randomSingle = randomNum % 10;

			int bonus;

			if(inputNum == randomNum) {
				bonus = 10000;
			} else if (inputTen == randomSingle && inputSingle == randomTen){
				bonus = 3000;
			} else if (inputTen == randomTen || inputSingle == randomSingle) {
				bonus = 1000;
			} else if (inputTen == randomSingle || inputSingle == randomTen){
				bonus = 500;
			} else {
				bonus = 0;
			}

			System.out.println("随机数： " + randomNum + "， 奖金： " + bonus);
		*/


		// 3. 条件 高 140cm 以上  财富 1千万 以上  帅 是
		// 	全部满足 "嫁"
		//  部分满足 "嫁吧"
		//  不满足	"不嫁"

		Scanner scan = new Scanner(System.in);

		System.out.println("身高: (cm)");
		int height = scan.nextInt();

		System.out.println("财富: (千万)");
		double money = scan.nextDouble();

		System.out.println("帅: (是/否)");
		boolean isHandsome = scan.next().equals("是");

		if (height >= 180 && money >= 1 && isHandsome) {
			System.out.println("嫁");
		} else if (height >= 180 || money >= 1 || isHandsome){
			System.out.println("嫁吧");
		} else {
			System.out.println("不嫁");
		}


	}
}