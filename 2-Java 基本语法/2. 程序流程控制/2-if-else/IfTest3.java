/*
	控制台输入三个整数，从小到大输出

*/
import java.util.Scanner;
class IfTest3 {
	public static void main(String[] args) {
		
		// 控制台获取输入值
		Scanner scan = new Scanner(System.in);

		System.out.println("请输入三个整数");
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();

		if (num1 <= num2) {
			if (num3 <= num1)      System.out.println(num3 + "," + num1 + "," + num2);
			else if (num3 >= num2) System.out.println(num1 + "," + num2 + "," + num3);
			else 				   System.out.println(num1 + "," + num3 + "," + num2);
		} else {
			if (num3 <= num2) 	   System.out.println(num3 + "," + num2 + "," + num1);
		    else if (num3 >= num1) System.out.println(num2 + "," + num1 + "," + num3);
		    else     			   System.out.println(num2 + "," + num3 + "," + num3);
		}

		if (num1 <= num2 && num1 <= num3) {
			if (num2 <= num3) {
				System.out.println(num1 + "," + num2 + "," + num3);
			} else {
				System.out.println(num1 + "," + num3 + "," + num2);
			}
		} else if (num2 <= num1 && num2 <=num3) {
			if (num1 <= num3) {
				System.out.println(num2 + "," + num1 + "," + num3);
			} else {
				System.out.println(num2 + "," + num3 + "," + num1);
			}
		} else {
			if (num1 <= num2) {
				System.out.println(num3 + "," + num1 + "," + num2);
			} else {
				System.out.println(num3 + "," + num2 + "," + num1);
			}
		}

	}
}