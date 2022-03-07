// 14 

/*
	5. 位运算符

		对 整型 二进制进行运算

		<<	左移   		高位丢弃 空位补0						乘以 2 的位数次幂		范围限制

		>>	右移   		高位为0  空位补0  高位为1 空位补1		除以 2 的位数次幂		范围限制

		>>>	无符号右移   空位补0

		&	与			二进制位 1&1为1 其余为0

		|	或			二进制位 0&0为0 其余为1

		^	异或			相同二进制位 0 不同二进制位 1      m = m ^ n ^ n

		~	取反			二进制位取反						该数的负数的反码

*/
class BitTest {
	public static void main(String[] args) {

		int i = 21;
		System.out.println("i << 2 : " + (i << 2));
		System.out.println("i << 3 : " + (i << 3));
		System.out.println("i << 26 : " + (i << 26));
		System.out.println("i << 27 : " + (i << 27));

		int m = 12;
		int n = 5;
		System.out.println("m & n : " + (m & n));  // 4
		System.out.println("m | n : " + (m | n));  // 13
		System.out.println("m ^ n : " + (m ^ n));  // 9


		System.out.println("-------------------------");


		// 面试题：最高效的计算 2 * 8  	2 <<< 3		8 << 1 


		// 练习1：交换两个变量的值
		int num1 = 10;
		int num2 = 20;

		// (1) 临时变量
		int temp = num1;
		num1 = num2;
		num2 = temp;

		// (2) 不用定义临时变量；只适用于数值型；可能超出存储范围
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;

		// (3) 位运算符  只适用于数值型
		num1 = num1 ^ num2;
		num2 = num1 ^ num2;
		num1 = num1 ^ num2;


		// 练习2：实现 60 的二进制到十六进制的转换 ★
		int i1 = 60; 												// 0011 1100
		int i2 = i1 & 15;											// 0000 1100			15  0000 1111
		String j = i2 > 9 ? (char)(i2 - 10 + 'A') + "" : i2 + "";   // "C"
		int temp = i1 >>> 4;  										// 0000 0011
		i2 = temp & 15;												// 0000 0011
		String k = i2 > 8 ? (char)(i2 - 10 + 'A') + "" : i2 + "";	// "3"
		System.out.println(k + "" + j);								// "3C"
	}
}