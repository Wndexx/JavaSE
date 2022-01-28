// 3

/*
	数据类型

		基本数据类型 primitive type

			数值型

				整型 	byte short int long

				浮点型 	float double

			字符型 char

			布尔型 boolean

		引用数据类型 reference type

			数组 []

			类 	 class 		String 是一个类

			接口 interface


	整型			

		byte	1字节	-128 ~ 127

		short	2字节

		int  	4字节	默认

		long 	8字节	以 "l" 或 "L" 结尾


	
*/

class VariableType {
	public static void main(String[] args) {
		// 1. 整型
		// (1) byte 1字节 = 8bit		 -128 ~ 127
		byte b1 = 12;
		byte b2 = -128;
		System.out.println(b1);
		System.out.println(b2);
		// 编译不通过
		// b2 = 128;
		// System.out.println(b2);

		short s1 = 128;
		int i1 = 1234;

		// (2) long型变量以 "l" 或 "L" 结尾 字面量
		long l1 = 3432243L;
		// 输出结果不带 "l" 或 "L"
		System.out.println(l1);

		// (3) 一般使用 int

	}
}