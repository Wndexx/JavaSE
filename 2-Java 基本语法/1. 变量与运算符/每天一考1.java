// 8
/*
	1. 标识符的命名规则

		a-z A-Z 0-9 _ $

		不以数字开头

		不使用关键字、保留字

		区分大小写


	2. 标识符的命名规范

		包 			xxxyyyzzz

		类、接口	 	XxxYxxZzz

		变量、方法 	xxxYxxZzz

		常量			XXX_YYY_ZZZ


	3. 数据类型分类，基本数据类型，所占内存空间

		基本数据类型

			整型 		byte 1字节  short 2字节  int 4字节  long 8字节

			浮点型  		float 4字节  double 8字节

			字符型		char  1字符 = 2字节

			布尔型		boolean  true false

		引用数据类型

			数组		[]

			类  		class

			接口 	interface


	4. 基本数据类型变量自动提升规则

		byte、char、short --> int --> long --> float --> double

		byte、char、short 两两运算，结果 int

		其余遵循 范围小 + 范围大 = 范围大


	5. 基本数据类型变量强制类型转换规则和问题

		强转符 ()

		可能精度损失


*/