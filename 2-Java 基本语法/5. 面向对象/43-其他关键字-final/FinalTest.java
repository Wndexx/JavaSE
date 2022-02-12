package com.wndexx.java3;

/*
	final:最终的
	
	1. final 可用来修饰的结构：类、方法、变量
	
	2. final 用来修饰一个类:此类不能被其他类所继承
	
		比如：String 类、 System 类、 StringBuffer 类
	
	3. final 用来修饰一个方法：表明此方法不可以被重写
	
		比如：Object 类中 getClass()
		
	4. final 用来修饰变量：此时的 "变量" 就称为是一个常量
	
		(1) final 修饰属性：可以考虑赋值的位置有：显式初始化、 代码块中初始化、 构造器中初始化(所有构造器都得赋值)
		
		(2) final 修饰局部变量：
		
			尤其是 final 修饰形参时，表明此形参是一个常量。当我们调用此方法时，给常量形参赋一个实参，一旦赋值以后，就只能在方法体内使用此形参，但不能进行重新赋值
			
	static final 用来修饰 属性 ：全局常量
	
	static final 用来修饰 方法 ：随着类的加载而加载，不能被重写
	
	面试题：
	
	(1):
		public class Something {
			public int addOne(final int x) {
				// return ++x; // 编译不通过
				return x + 1; // 可以
			}
		}
		
	(2):
		public class Something {
			public static void main(String[] args) {
				Other o = new Other();
				new Something().addOne(o);
			}
			public void addOne(final Other o) {
				// o = new Other(); // 编译不通过
				o.i++; // 可以
			}
		}
		class Other {
			public int i;
		}
	
*/
public class FinalTest {
	
	final int WIDTH = 0;
	final int LEFT;
	{
		LEFT = 1;
	}
	final int RIGHT;
	// final int DOWN;
	public FinalTest() {
		RIGHT = 2;
	}
	
	// The blank final field RIGHT may not have been initialized
	public FinalTest(int n) {
		RIGHT = n;
	}
	
	// The final field FinalTest.DOWN cannot be assigned
	// public void setDown(int down) {
	//	this.DOWN = down;
	// }
	
	
	public void doWidth() {
		// The final field FinalTest.width cannot be assigned
		// width = 20;
	}
	
	public void show() {
		final int NUM = 10; // 常量
	}
	
	public void show(final int num) {
		// num = 20; // 编译不通过
		System.out.println(num);
	}
	
	public static void main(String[] args) {
		int num = 10;
		num += 5;
		
		FinalTest test = new FinalTest();
		// test.setDown(3);
		
		test.show(10); // 10
	}
}

final class FinalA {

}

// The type B cannot subclass the final class FinalA
// class B extends FinalA{
//	
// }

//The type C cannot subclass the final class String
// class C extends String{
//	
// }

class AA {
	public final void show() {

	}
}

class BB extends AA {
	// Cannot override the final method from AA
	// public void show() {
	//
	// }
}
