/*
	Scanner 类	从控制台获取值

	步骤

		1. 导包   import java.util.Scanner;

		2. 实例化 Scanner scan = new Scanner(System.in);

		3. 调用方法获取变量值  

			String    scan.next()

			int       scan.nextInt()

			double    scan.nextDouble()

			boolean   scan.nextBoolean()

	注意

		方法 与 值的类型 匹配 

	    否则 异常 InputMismatchException 程序终止


*/
import java.util.Scanner;
class ScannerTest {
	public static void main(String[] args) {
		
		// Scanner scan = new Scanner(System.in);
		// int num = scan.nextInt();
		// System.out.println(num);

		Scanner scan = new Scanner(System.in);

		System.out.print("请输入你的姓名：");
		String name = scan.next();
		System.out.println(name);

		System.out.print("请输入你的年龄：");
		int age = scan.nextInt();
		System.out.println(age);

		System.out.print("请输入你的体重：");
		double weight = scan.nextDouble();
		System.out.println(weight);

		System.out.print("是否单身？（true/false）");
		boolean isSingle = scan.nextBoolean();
		System.out.println(isSingle);

		// char 型获取，Scanner 没有相关方法
		System.out.print("请输入你的性别：(男/女)");
		String gender = scan.next();
		char genderChar = gender.charAt(0); // 获取索引为0位置的字符
		System.out.println(genderChar);

	}
}