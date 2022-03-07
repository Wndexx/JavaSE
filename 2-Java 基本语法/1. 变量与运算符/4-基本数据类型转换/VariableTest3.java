// 4

/*
	基本数据类型转换(排除 boolean)

		自动类型提升
		
			byte、 char、 short --> int --> long --> float --> double  表示数的范围依次增大
			
			向上自动提升

			byte、 char、 short 运算，结果为 int !!!


		强制类型转换

			自动类型提升 逆运算

			强转符 ()
		
			可能损失精度


		整型常量   默认 int    型

		浮点型常量 默认 double 型


*/
public class VariableTest3 {
	public static void main(String[] args) {

		// 自动类型提升

		byte b1 = 2;
		int i1 = 129;

		// 编译不通过
		// byte b2 = b1 + i1;

		int i2 = b1 + i1;
		System.out.println(i2);
		
		float f1 = b1 + i1;
		System.out.println(f1);

		short s1 = 123;
		double d1 = s1; 
		System.out.println(d1); // 123.0


		char c1 = 'a'; // 97
		int i3 = 10;
		// Unicode 值参与运算
		int i4 = c1 + i3;
		System.out.println(i4);


		//  char byte short 两两运算(包括与自身)，结果均为 int
		short s2 = 10;
		// (1) 编译不通过 char 与 short 运算 结果为 int
		// short s3 =c1 + s2;

		byte b2 = 10;
		// (2) 编译不通过 char 与 byte 运算 结果为 int
		// char c3 = c1 + b2;

		// (3) 编译不通过 short 与 byte 运算 结果为 int
		// short s3 = b1 + s1;

		// (4) 编译不通过 byte 与 byte 运算 结果为 int
		// byte b3 = b1 + b2;

		// (5) 编译不通过 short 与 short 运算 结果为 int
		// short s3 = s1 + s2;

		// (6) 编译不通过 char 与 char 运算 结果为 int
		// char c2 = 'b';
		// char c3 = c1 + c2;


		// --------------------------------------------------


		// 强制类型转换

		double d2 = 12.3;
		// 12
		int i5 = (int)d2; // 截断 取整 精度损失
		System.out.println(i5);

		d2 = 12.9;
		// 12
		i5 = (int)d2;
		System.out.println(i5);

		long l1 = 123;
		short s3 = (short)l1; // 不损失精度

		int i6 = 128;
		byte b3 = (byte)i6; // -128 精度损失
		System.out.println(b3);


		// ----------------------------------------------------


		// 1. 编码情况1
		// 自动变量提升 int --> long 不报错
		long l2 = 123123; 
		System.out.println(l2);

		// 编译失败 过大的整数
		long l3 = 231122222222222221L;

		// 编译失败 double --> float 没有变量提升
		float f2 = 12.3F;

		// 2. 编码情况2
		byte b4 = 12;
		// 编译失败 整型常量 默认 int
		// byte b5 = b4 + 1;

		// 编译失败 浮点型常量 默认 double
		// float f3 = b4 + 12.3;

	}

}