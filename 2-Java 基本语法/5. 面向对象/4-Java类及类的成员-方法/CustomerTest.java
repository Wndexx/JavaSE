package com.wndexx.java;

/*
	类中方法的声明和使用
	
	方法：描述里应该具有的功能
	
		比如：Math 类：sqrt() random() ...
		
			Scanner 类： nextXxx() ...
			
			Arrays 类： sort() binarySearch() toString() fill() equals()
			
	1. 举例
	
		public void eat() {}
		
		public void sleep(int hour) {}
		
		public String getName() {}
		
		public String getNation(String nation) {}
		
		
	2. 方法的声明：
		
		权限修饰符 返回值类型 方法名(形参列表){
		
				方法体
		}
		
		注意：static、final、abstract 来修饰的方法，后面再讲
		
		
	3. 说明：
	
		(1) 权限修饰符：
		
			Java 规定的4种权限修饰符：private、 public、 缺省、 protected   ---> 封装性再细说
			
		(2) 返回值类型： 有返回值 vs 没有返回值
			
			- 如果方法有返回值，则必须在方法声明时，指定返回值的类型。 同时方法中，需要使用 return 关键字来返回指定类型的变量或常量
			  
			  如果方法没有返回值，则方法声明时，使用 void 来表示。 通常没有返回值的方法中，不需要使用 return。 但是，如果使用的话，只能 "return;" 表示结束此方法的意思
			  
			- 定义方法该不该有返回值？
			
				- 题目要求
				
				- 凭经验：具体问题具体分析
				
		(3) 方法名：属于标识符，遵循标识符的规则和规范，"见名知意"
		
		(4) 形参列表：方法可以声明0个，1个，或多个形参
		
			- 格式： 数据类型1 形参1, 数据类型2 形参2, ...
				
			- 定义方法时，该不该定义形参？
			
				- 题目要求
				
				- 凭经验：具体问题具体分析
				
		(5) 方法体：方法功能的体现
		
				
	4. return 关键字的使用：
	
		- 适用范围：使用在方法体中
		
		- 作用：
		
			- 结束方法
			
			- 针对于有返回值类型的方法，使用 "return  数据" 返回所要的数据
			
		- return 关键字后面不可以声明执行语句
		
		
	5. 方法的使用：可以调用当前类的属性或方法
	
			特殊的： 方法A 中又调用了方法A :递归方法
		
		方法中，不可以定义方法！！！！
		
*/
public class CustomerTest {
	public static void main(String[] args) {
		
		Customer cust1 = new Customer();
		cust1.eat();
		
		// 测试形参是否需要设置
		//int[] arr = new int[] {1,2,4,-9};
		//cust1.sort(arr);
		
		cust1.sleep(8);
	}
}

// 客户类
class Customer{
	
	// 属性
	String name;
	int age;
	boolean isMale;
	
	// 方法
	public void eat() {
		System.out.println("客户吃饭");
		return;
		// return 后不可以使用表达式
		// System.out.println("hello");
	}
	
	public void sleep(int hour) {
		System.out.println("休息了" + hour +"个小时");
		eat();
		
		// sleep(10); // StackOverFlowError 栈溢出
	}
	
	public String getName() {
		
		//if(age > 18) {
		//	return name;
		//}
		
		if(age > 18) {
			return name;
		}else {
			return "Tom";
		}
		
		// return name;
		
		// return "Tom";
	}
	
	public String getNation(String nation) {
		String info = "我的国籍是" + nation;
		return info;
	}
	
	// 体会形参是否需要设置
	//public void sort(int[] arr) {
	//
	//}
	
	//public void sort() {
	//	int[] arr = new int[] {1,2,4,-9};
	//}
	
	//public void info() {
	//	public void info() {
	//		
	//	}
	//}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}