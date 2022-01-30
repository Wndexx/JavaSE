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


	浮点型

		float 	单精度	4字节	7位有效数字		以 "f" 或 "F" 结尾

		double 	双精度	8字节	float 两倍		默认		常用


	字符型

		char 	2字节	Unicode 编码

		转义字符

			\b 		退格符
	
			\n  	换行符
	
			\r  	回车符
	
			\t  	制表符
	
			\"  	双引号
	
			\'  	单引号
	
			\\  	反斜线

		可以使用 Unicode 值表示字符

		有且只有一个字符


	boolean 型	

		只能取 true 或 false 

	
*/
class VariableTest2 {
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


		// 2. 浮点型
		// (1) 浮点型，表示带小数点的数值
		// (2) float 表示数值的范围比 long 还大
		double d1 = 123.3;
		System.out.println(d1 + 1);

		// (3) float 类型变量以 "f" 或 "F" 结尾
		float f1 = 12.3f;
		// 输出结果不带 "f" 或 "F"
		System.out.println(f1);

		// (4) 一般使用 double


		// 3. 字符型：char
		// (1) 字面量 ''
		char c1 = 'a';
		System.out.println(c1);

		c1 = 'A';
		System.out.println(c1);

		// 编译不通过 只能放一个字符
		// c1 = 'AB';
		// System.out.println(c1);

		char c2 = '1';
		char c3 = '中';

		// (2) 表示方式：1. '' 声明字符 2. 转义字符 3. Unicode 值
		// 换行符
		char c5 = '\n';
		c5 = '\t';
		System.out.print("hello" + c5);
		System.out.println("world");
		// C
		char c6 = '\u0043';
		System.out.println(c6);


		// 4. 布尔型：boolean
		// 取值：true 或 false
		boolean bb1 = true;
		System.out.println(bb1);

		boolean isMarried = true;
		if (isMarried) {
			System.out.println("呵呵");
		}else {
			System.out.println("哈哈");
		}

		// 补充：\n 换行  \\n "\n" 不转义
 

	}
}