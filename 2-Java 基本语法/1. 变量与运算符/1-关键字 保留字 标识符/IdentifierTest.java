// 1

/*
	关键字 keyword

		定义		特殊含义的字符串

		特点		小写

		分类

			数据类型 					class interface enum byte short int long float double char boolean void

			流程控制 					if else switch case break continue default while do for return

			访问权限修饰符 				private protected public

			类、函数、变量修饰符 			abstract final static synchronized

			类之间关系 					extends implements

			建立实例、引用实例、判断实例 	new this super instanceof

			异常处理 					try catch finally throw throws

			包 							package import

			其它 						native strictfp transient volatile assert

			数据类型值的字面量 			true false null


	保留字 reserved word

		未来可能会作为关键字的单词

		goto const 


	标识符 identifier

		1. 标识符：凡是自己可以起名字的地方都叫标识符。

   			比如：类名、变量名、方法名、接口名、包名...

		2. 标识符的命名规则：--> 如果不遵守如下的规则，编译不通过！需要大家严格遵守

			(1) 由26个英文字母大小写，0-9 ，_或 $ 组成  

			(2) 数字不可以开头。

			(3) 不可以使用关键字和保留字，但能包含关键字和保留字。

			(4) Java中严格区分大小写，长度无限制。

			(5) 标识符不能包含空格。

		3. Java中的名称命名规范： --->如果不遵守如下的规范，编译可以通过！建议大家遵守

			包名				所有单词小写								xxxyyyzzz

			类名、接口名		所有单词首字母大写						XxxYyyZzz

			变量名、方法名	第一个单词首字母小写，其余单词首字母大写	xxxYyyZzz

			常量名			所有单词大写，中间以 _ 连接				XXX_YYY_ZZZ

		4.注意1：在起名字时，为了提高阅读性，要尽量有意义，“见名知意”。
		
		  注意2：java采用unicode字符集，因此标识符也可以使用汉字声明，但是不建议使用。 

*/

public class IdentifierTest {
	public static void main(String[] args) {

		// 变量名 xxxYyyZzz
		// int myNumber = 1001;
		// System.out.print(myNumber);

		int mynumber = 1002;
		System.out.print(mynumber);

		// 可以使用中文，不推荐
		int 学号 = 1003;
		System.out.print(学号);


	}
}

class Hello1_$ {

}

// 不可以数字开头
// class 1Hello{

// }

// 不可使用关键字和保留字
// class static{

// }

// 可包含关键字和保留字
class static1 {

}

// 严格区分大小写 不是关键字 可以编译通过
class Static {

}



