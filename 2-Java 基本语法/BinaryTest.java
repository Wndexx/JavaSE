// 6

/*
	进制

		二进制 binary 	0 1 		满2进1 		0b或0B开头

		十进制 decimal   0-9			满10进1		

		八进制 octal		0-7			满8进1		0开头

		十六进制 hex 	0-9以及A-F 	满16进1 		0x或0X开头		A-F不区分大小写

	十进制 --> 二进制 除2取余的逆

	二进制 <---> 八进制   3位 <---> 1位

	二进制 <---> 十六进制 4位 <---> 1位
	
	
	正数

		原码、 补码、 反码相同

	负数

		原码		直接将数值转换为二进制 	最高位符号位 1

		反码		原码除符号位外按位取反	最高位符号位	1

		补码		反码 + 1 				最高位符号位	1


	计算机底层以 补码 的方式存储数据

*/

class BinaryTest {
	public static void main(String[] args) {

		int num1 = 0b110;
		int num2 = 110;
		int num3 = 0127;
		int num4 = 0x110A;

		System.out.println("num1=" + num1);
		System.out.println("num1=" + num2);
		System.out.println("num1=" + num3);
		System.out.println("num1=" + num4);
	}
}
