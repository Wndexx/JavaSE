// 3

/*
	对第一个 java 程序进行总结

	1. java 程序编写-编译-运行的过程

		编写：我们将编写的 java 代码保存在以 ".java" 结尾的源文件中

		编译：使用 javac.exe 命令编译我们的 java 源文件。   格式：javac 源文件名.java

		运行：使用 java.exe 命令解释运行我们的字节码文件。 格式：java 类名


	2.在一个java源文件中可以声明多个class。

	  但是，只能最多有一个类声明为 public 的。

	  而且要求声明为 public 的类的类名必须与源文件名相同。

	
	3. 程序的入口是main()方法。格式是固定的。

		public static void main(String[] args) {}


	4. 输出语句：

		System.out.println():先输出数据，然后换行

		System.out.print():只输出数据


	5. 每一行执行语句都以 ";" 结尾
	

	6.编译的过程：编译以后，会生成一个或多个字节码文件。

	  字节码文件的文件名与 java 源文件中的类名相同。

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