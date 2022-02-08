package com.wndexx.java2;

import java.lang.reflect.Field;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.HashMap;
import java.util.*;

import com.wndexx.exer4.Account;
import com.wndexx.exer4.Bank;
import com.wndexx.java2.java3.Dog;

import static java.lang.System.*;
import static java.lang.Math.*;

/*
	一、package 关键字的使用
	
		1. 为了更好的实现项目中类的管理，提出 包 的概念
		
		2. 使用 package 声明类或接口所属的包，声明在源文件的首行
		
		3. 包，属于标识符，遵循标识符的命名规则、规范(xxxyyyzzz)， "见名知意"
		
		4. 每 "." 一次，就代表一层文件目录
		
		补充：同一个包下，不能命名同名的接口、类
		
			不同的包下，可以命名同名的接口、类
			
		JDK 中主要的包介绍
		
		1. java.lang：包含一些 Java 语言的核心类，如 String 、Math、Integer、System 和 Thread，提供常用功能
		
		2. java.net：包含执行与网络相关的操作的类和接口
		
		3. java.io：包含能提供多种输入/输出功能的类
		
		4. java.util：包含一些使用工具类，如定义系统特性、接口的集合框架类、使用与日期日历相关的函数
		
		5. java.text:包含一些 Java 格式化相关的类
		
		6. java.sql：包含了 Java 进行 JDBC 数据库编程的相关类/接口
		
		7. java.swt：包含了构成抽象窗口工具集(abstract、window toolkits) 的多个类，这些类被用来构建和管理应用程序的图形用户界面(GUI)。
		
	二、import 关键字的使用
	
		import：导入
		
		1. 在源文件中显式的使用 import 结构导入指定包下的类、接口
		
		2. 声明在包的声明和类的声明之间
		
		3. 如果需要导入多个结构，则并列写出即可
		
		4. 可以使用 "xxx.*" 表示可以导入 xxx 包下的所有结构
		
		5. 如果使用的类或接口是 java.lang 包下定义的，则可以省略 import 结构
		
		6. 如果使用的类或接口是本包下定义的，则可以省略 import 结构
		
		7. 如果在源文件中，使用了不同包下的同名的类，则必须至少有一个类需要以全类名的方式显示
		
		8. 使用 "xxx.*" 方式表明可以调用 xxx 包下的所有结构。但是如果使用的是 xxx 子包下的结构，则仍需要显式导入 
		
		9. import static：导入指定类或接口中的静态结构(属性、方法)
		
*/
public class PackageImportTest {
	public static void main(String[] args) {

		String info = Arrays.toString(new int[] { 1, 2, 3 });

		Bank bank = new Bank();

		ArrayList list = new ArrayList();
		HashMap map = new HashMap();
		Scanner s = null;

		System.out.println();

		Person p = new Person();

		Account acct = new Account(1000);
		// 全类名的方式显示
		com.wndexx.exer3.Account acc1 = new com.wndexx.exer3.Account(1000, 2000, 0.0123);
		
		Date date = new Date();
		java.sql.Date date1 = new java.sql.Date(5454353543L);
		
		Dog dog = new Dog();
		
		Field field = null;
		
		out.println();
		
		long num = round(123.434);
	}
}
