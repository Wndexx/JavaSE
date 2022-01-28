// 2

/*
	变量 

		程序最基本的存储单元

		内存中存储数据

	1. 格式

		数据类型 变量名 = 变量值;
	
	2. 注意

		(1) 声明 -> 赋值 -> 使用

		(2) 作用域内有效

		(3) 同一作用域内变量名不可重复

*/
class VariableTest {
	public static void main(String[] args) {

		// 变量的定义
		int myAge = 12;
		// 变量的使用
		System.out.print(myAge);


		// 编译错误：使用 myNumber 之前并未定义过 myNumber 变量
		// System.out.print(myNumber);

		// 变量的声明
		int myNumber;

		// 编译错误：使用 myNumber 之前并未赋值过 myNumber 变量
		// System.out.println(myNumber);

		// 变量的赋值
		// myNumber = 1001;
		System.out.println(myNumber);

		// 编译不通过
		System.out.println(myClass);


		// 不可以在同一作用域内定义同名的变量
		int myAge = 22;

	}

	public void method() {
		int myClass = 1;

	}
}