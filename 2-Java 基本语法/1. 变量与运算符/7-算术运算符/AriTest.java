// 9

/*
	运算符

		1. 算术运算符

			 +(正)  -(负)  +  -  *  /  %  (前)++  (后)++  (前)--  (后)--  +(连接)

*/
class ArithmeticOperatorTest {
	public static void main(String[] args) {
		
		// 除号: /
		int num1 = 12;
		int num2 = 5;
		int result = num1 / num2; 			  				// 2
		System.out.println(result);

		int result2 = num1 / num2 * num2;
		System.out.println(result2); 		  				// 10

		double result3 = num1 / num2;
		System.out.println(result3); 		  				// 2.0

		double resul4 = num1 / num2 + 0.0; 	 				//2.0

		double result5 = num1 / (num2 + 0.0); 				// 2.4 
		System.out.println(result5);

		double result6 = (double)num1 / num2;
		System.out.println(result6);		  				// 2.4

		double result7 = (double)(num1 + num2); 			// 2.0


		System.out.println("---------------------------------------------------");


		// 取模：%
		// 结果符号与被模数符号相同
		// 结果0 除尽
		int m1 = 12;
		int n1 = 5;
		System.out.println("m1 % n1 = " + m1 % n1); // 2

		int m2 = -12;
		int n2 = 5;
		System.out.println("m2 % n2 = " + m2 % n2); // -2

		int m3 = 12;
		int n3 = -5;
		System.out.println("m3 % n3 = " + m3 % n3); // 2

		int m4 = -12;
		int n4 = -5;
		System.out.println("m4 % n4 = " + m4 % n4); // -2


		System.out.println("-------------------------------------------------");


		// 前置自增 ++num 自增1
		// 先自增 后运算
		int a1 = 10;
		int b1 = ++a1;
		System.out.println("a1 = " + a1 + ",b1 = " + b1); // 11 11

		// 后置自增 num++
		// 先运算 后自增
		int a2 = 10;
		int b2 = a2++; 
		System.out.println("a2 = " + a2 + ",b2 = " + b2); // 11 10

		int a3 = 10;
		// a3++;
		++a3;
		int b3 = a3; // 11

		// 自增1不改变数据类型!!!!! 
		short s1 = 10;
		// s1 = s1 + 1; // 编译失败
		// s1 = (short)(s1 + 1); // 正确
		s1++; // 正确
		System.out.println(s1);

		// 原理 二进制数直接加1 效率高
		byte bb1 = 127;
		bb1++;
		System.out.println("bb1 = " + bb1); // -128


		System.out.println("-------------------------------------------------");


		// 前置递减 --num 自减1 先自减 后运算

		// 后置递减 num-- 自减1 先运算 后自减

		int a4 = 10;
		int b4 = --a4;
		System.out.println("a4= " + a4 + ",b4 = " + b4);

		int a5 = 10;
		int b5 = a5--;
		System.out.println("a5= " + a5 + ",b5 = " + b5);
	}

}