package com.wndexx.java2;

/*
	main() 方法的使用说明
	
	1. main() 方法作为程序的入口
	
	2. main() 方法也是一个普通的静态方法
	
	3. main() 方法也可以作为我们与控制台交互的方式。(之前：使用Scanner)

	如何将控制台获取的数据传给形参：String[] args

		运行时： java 类名 "Tom" Jerry "123" "true"
		
		sysout(args[0]);  // "Tom"

		sysout(args[3]); // "true" --> Boolean.parseBoolean(args[3]);

		sysout(args[4]); // 异常

	小结：
	public static void main(String[] args){// 方法体}

		权限修饰符：private 缺省 protected public ---> 封装性

		修饰符：static \ final \ abstract \ native 可以用来修饰方法

		返回值类型：无返回值 / 有返回值  ---> return 

		方法名：需要满足标识符命名放入规则、规范："见名知意"

		形参列表：重载 vs 重写  参数的值传递机制  体现对象的多态性

		方法体：体现方法的功能

*/
public class MainTest {
	
	public static void main(String[] args) { // 入口
		
		Main.main(new String[100]);
		
		show();
	}
	
	public static void show() {
		
	}
}

class Main {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			args[i] = "args_" + i;
			System.out.println(args[i]);
		}
	}
}
