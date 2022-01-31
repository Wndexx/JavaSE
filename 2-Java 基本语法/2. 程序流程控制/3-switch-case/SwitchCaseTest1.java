import java.util.Scanner;
class SwitchCaseTest1 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// 1. 小写 char 型转换为大写 只转换 a b c d e，其它输出 other
		/*
			System.out.println("输入小写字母");
			String letter = scan.next();

			char l = scan.charAt(0);
			switch (l) {
				case 'a':
					System.out.println('A');
					break;
				case 'b':
					System.out.println('B');
					break;
				case 'c':
					System.out.println('C');
					break;
				case 'd':
					System.out.println('D');
					break;
				case 'e':
					System.out.println('E');
					break;
				default:
					System.out.println("other");
					break;
			}
		*/

		// 2. 成绩大于60 合格 低于 60 不合格
		/*
			System.out.println("输入成绩");
			int score = scan.nextInt();

			int radio = score / 60;

			switch (radio) {
				case 1:
					System.out.println("合格");
					break;
				case 0:
					System.out.println("不合格");
					break;           
			}
		*/


		// 3. 根据 月份 打印 季节
		// 多个 case 执行语句相同，可以合并 ！！！
		/*
			System.out.println("输入月份");
			int month = scan.nextInt();

			switch (month) {
				case 3:
				case 4:
				case 5:
					System.out.println("春");
					break;
				case 6:
				case 7:
				case 8:
					System.out.println("夏");
					break;
				case 9:
				case 10:
				case 11:
					System.out.println("秋");
					break;
				case 12:
				case 1:
				case 2:
					System.out.println("冬");
					break;
			}
		*/

		// 4. 输入 2019 年 month 和 day  输出 是 2019 年的第几天
		/*
			System.out.println("输入月");
			int month1 = scan.nextInt();
			System.out.println("输入日");
			int day = scan.nextInt();
			
			// (1)
			int sumDays = 365;

			switch (month1) {
				case 1:
					sumDays -= 31;
				case 2:
					sumDays -= 28;
				case 3:
					sumDays -= 31;
				case 4:
					sumDays -= 30;
				case 5:
					sumDays -= 31;
				case 6:
					sumDays -= 30;
				case 7:
					sumDays-= 31;
				case 8:
					sumDays -= 31;
				case 9:
					sumDays -= 30;
				case 10:
					sumDays -= 31;
				case 11:
					sumDays -= 30;
				case 12:
					sumDays -= 31;
			}
			sumDays += day;

			// (2)
			int sumDays = 0;

			switch (month1) {
				case 12:
					sumDays += 30;
				case 11:
					sumDays += 31;
				case 10:
					sumDays += 30;
				case 9:
					sumDays += 31;
				case 8:
					sumDays += 31;
				case 7:
					sumDays += 30;
				case 6:
					sumDays += 31;
				case 5:
					sumDays += 30;;
				case 4:
					sumDays += 31;
				case 3:
					sumDays += 28;
				case 2:
					sumDays += 31;
				case 1:
					sumDays += day;
			}

			System.out.println(sumDays);
		*/


		// 5. 输入 年 月 日 ，判断当年第几天

		/*
			System.out.println("年");
			int year = scan.nextInt();

			System.out.println("月");
			int month = scan.nextInt();

			System.out.println("日");
			int day = scan.nextInt();

			int sumDays = 0;
			switch (month) {
					case 12:
						sumDays += 30;
					case 11:
						sumDays += 31;
					case 10:
						sumDays += 30;
					case 9:
						sumDays += 31;
					case 8:
						sumDays += 31;
					case 7:
						sumDays += 30;
					case 6:
						sumDays += 31;
					case 5:
						sumDays += 30;;
					case 4:
						sumDays += 31;
					case 3:
						sumDays += year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ? 29 : 28;
					case 2:
						sumDays += 31;
					case 1:
						sumDays += day;
				}

			System.out.println(year + "年" + month + "月" + day + "日对应的天数: "+ sumDays);
		*/

		// 6. if-else -> switch-case
		/*
			int a = 3;
			int x = 100;

			if (a == 1) {
			 	x += 5;
			 } else if (a == 2) {
			 	x += 10;
			 } else if (a == 3) {
			 	x += 16;
			 } else {
			 	x += 34;
			 }

			 switch (a) {
			 	case 1:
			 		x += 5;
			 		break;
			 	case 2:
			 		x += 10;
			 		break;
			 	case 3:
			 		x += 16;
			 		break;
			 	default:
			 		x += 34;
			 		break;
			 }
		*/


	}
}