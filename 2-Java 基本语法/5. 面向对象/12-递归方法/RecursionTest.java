package com.wndexx.java2;

/*
	递归方法的使用
	
		1. 递归方法：一个方法体内调用它本身
		
		2. 方法递归包含一种隐式的循环，它会重复执行某段代码，但这种重复执行无须循环控制
		
		3. 递归一定要向已知方向递归，否则这种递归就变成了无穷递归，类似于死循环。就是一定要有终止条件
		
*/
public class RecursionTest {

	public static void main(String[] args) {

		// 例1：计算 1 ~ 100 之内所有自然数的和
		// 方式一：
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

		// 方式二：
		RecursionTest test = new RecursionTest();
		sum = test.getSum(100);
		System.out.println(sum);

		System.out.println("******************************");
		int value = test.f(10);
		System.out.println(value);

		System.out.println("******************************");
		test.Hanoi(4, 'a', 'b', 'c');

	}

	/**
	 * 
	 * @Description 递归求和
	 * @author wndexx
	 * @date 2022年2月6日下午8:09:53
	 * @param n
	 * @return
	 *
	 */
	// 例1：计算 1 ~ n 之内所有自然数的和
	public int getSum(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n + getSum(n - 1);
		}
	}

	// 例2：计算 1 ~ n 之内所有自然数的乘积: n!
	public int getSum1(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * getSum1(n - 1);
		}
	}

	// 例3：已知一个数列：f(0) = 1，f(1) = 4，f(n + 2) = 2 * f(n + 1) + f(n)，其中 n 是大于 0 的整数，
	// 求 f(10) 的值
	public int f(int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return 4;
		} else {
			return 2 * f(n - 1) + f(n - 2);
		}
	}

	// 例4：已知一个数列：f(20) = 1，f(21) = 4，f(n + 2) = 2 * f(n + 1) + f(n)，其中 n 是大于 0 的整数，
	// 求 f(10) 的值
	public int getSum3(int n) {
		if (n == 20) {
			return 1;
		} else if (n == 21) {
			return 4;
		} else if (n < 20) {
			return getSum3(n + 2) - 2 * getSum3(n + 1);
		} else {
			return 2 * getSum3(n - 1) + getSum3(n - 2);
		}
	}

	// 例5：输入一个数据 n，计算斐波那契数列（Fibonacci）的第 n 个值
	// 1 1 2 3 5 8 13 21 34 55
	// 规律：一个数等于前面那两个数之和
	// 要求：计算斐波那契数列（Fibonacci）的第 n 个值，并将整个数列打印出来
	public int getSum4(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 1;
		} else {
			return getSum4(n - 1) + getSum4(n - 2);
		}
	}

	// 例6：汉诺塔问题
	// 把A杆上的金盘全部移到C杆上，并仍保持原有顺序叠好。
	// 操作规则：每次只能移动一个盘子，并且在移动过程中三根杆上都始终保持大盘在下，小盘在上，操作过程中盘子可以置于A、B、C任一杆上。
	public void Hanoi(int n, char a, char b, char c) { // a: 所处杆 b: 中间杆 c: 目标杆
		if (n == 1) {
			System.out.println("将金盘" + n + "从 " + a + " 杆移动到 " + c + " 杆");
		} else {
			Hanoi(n - 1, a, c, b);
			System.out.println("将金盘" + n + "从 " + a + " 杆移动到 " + c + " 杆");
			Hanoi(n - 1, b, a, c);
		}
	}

	// 例7：快速排序

}
