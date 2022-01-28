// 3

/*
	总结

	1. java 程序 编写-编译-运行 过程

		编写		java 代码保存在 .java 后缀的源文件中
			
		编译		命令：javac 源文件名.java 	生成字节码文件

		运行 	命令：java 类名


	2. 一个 java 源文件中可以包含 多个 class

		最多有一个类声明为 public

		public 声明的类名和 源文件名 相同

	
	3. 程序的入口：main() 方法

		main() 格式固定	public static void main(String[] args) {}


	4. 输出语句

		换行   System.out.println()	先输出 后换行

		不换行 System.out.print()	只输出 不换行


	5. 每一行执行语句都以 ";" 结尾
	

	6. java 源文件中的多个类会编译生成 多个字节码文件

		字节码文件名和类名相同

 */

public class Hello{

	// public static void main(String[] args) { 
	// 	System.out.println("Hello World");
	// }

	// 1. arguments 参数  args 可以更改为其它的变量名
	// public static void main(String[] a) {
	// 	System.out.println(" Hello World");
	// }

	// 2. [] 可放在变量后
	// public static void main(String a[]) {
	// 	System.out.println(" Hello World");
	// }

	// 3. 换行   
	// public static void main(String a[]) {
	// 	System.out.println(" Hello World");
	// 	System.out.println(" Hello World");
	// }

	// 4. 不换行
	// public static void main(String a[]) {
	// 	System.out.println(" Hello World");
	// 	System.out.print(" Hello World");
	// }

	// 5. System.out.println(); 只换行 不输出
	public static void main(String a[]) {
		System.out.print(" Hello World");
		System.out.println();
		System.out.print(" Hello World");
	}

}

class Person{

}

class Animal{

}