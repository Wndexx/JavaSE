// 15

/*
	6. 三元运算符

		格式		

			(条件表达式) ? 表达式1 : 表达式2

		条件表达式 结果 boolean   true 表达式1  false 表达式2

		表达式1 和 表达式2 同种类型	int double 也行

		必须返回一个结果

		可嵌套

		可改写成 if-else

		简洁、执行效率高

*/

class TernaryTest {
	public static void main(String[] args) {
		
		// 获取两个整数的较大值
		int m = 12;
		int n = 5;
		int max = m > n ? m : n;

		System.out.println(max);

		double num = m > n ? 2 : 1.0; 			// 编译不报错
		// double num = m > n ? 2 : "n 大"; 		// 编译报错
		String maxStr = m > n ? "m 大" : "n 大";	// 编译不报错

		n = 12;
		// 嵌套
		maxStr = m > n ? "m 大" : (m == n ? "m 和 n 相等" : "n 大" );
		System.out.println(maxStr);


		// 获取三个数的最大值
		int n1 = 12;
		int n2 = 30;
		int n3 = -43;

		int max1 = n1 > n2 ? n1 : n2;
		max1 = max1 > n3 ? max1 : n3;

		System.out.println(max1);


		// 改写成 if-else
		if (m > n) {
			System.out.println(m);
		} else {
			System.out.println(n);
		}

	}
}