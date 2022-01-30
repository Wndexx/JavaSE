// 5

/*
	String 类型变量

		字符串

		引用数据类型

		字面量 ""

		只能与 8 种基本数据类型做连接运算 (+)  结果 String

*/
class StringTest {
	public static void main(String[] args) {

		String s1 = "Hello World";
		System.out.println(s1);
		String s2 = "a";
		String s3 = "";

		// 编译不通过 字符类型有且只有一个字符
		// char c = '';

		System.out.println(" -------------------------------------");

		int number = 1001;
		String numberStr = "学号";
		String info = numberStr + number; // + 连接运算
		boolean b1 = true;
		String info1 = info + b1;
		System.out.println(info1);


		System.out.println(" -------------------------------------");


		// 练习1
		char c = 'a'; // a 97  A 65
		int num = 10;
		String str = "hello";
		System.out.println(c + num + str);	 	// 107hello
		System.out.println(c + str + num);	 	// ahello10
		System.out.println(c + (num + str)); 	// a10hello
		System.out.println((c + num) + str); 	// 107hello
		System.out.println(str + num + c);   	// hello10a


		// 练习2
		// *	*
		System.out.println("*	*");			// *	*
		System.out.println('*' + '\t' + '*');	// 93
		System.out.println('*' + "\t" + '*');	// *	*
		System.out.println('*' + '\t' + "*");	// 51*
		System.out.println('*' + ('\t' + "*")); // *	*


		// String str1 = 4; 					// 错
		String str2 = 3.5f + "";				// 对
		System.out.println(str2);				// 3.5
		System.out.println(3 + 4 + "Hello!"); 	// 7Hello!
		System.out.println("Hello!" + 3 + 4); 	// Hello!34
		System.out.println('a' + 1 + "Hello!"); // 98Hello!
		System.out.println("Hello!" + 'a' + 1);	// Hello!a1

		/*
			// 判断是否能通过编译
			short s = 5;
			s = s -2;   				// 不能 int

			byte b = 3;
			b = b + 4;					// 不能 int
			b = (byte)(b + 4);			// 能  7

			char c = 'a';
			int i = 5;
			float d = .314F;
			double result = c + i + d; 	// 能	 102.314

			byte b = 5;
			short s = 3;
			short t = s + b; 			// 不能 int
		*/

		// String str1 = 123; 		// 编译不通过
		String str1 = 123 + "";
		System.out.println(str1); 	// 123

		// int num1 = str1; 		// 编译不通过
		// int num1 = (int)str1;	// 编译不通过

		int num1 = Integer.parseInt(str1);
		System.out.println(str1); 
	}
}