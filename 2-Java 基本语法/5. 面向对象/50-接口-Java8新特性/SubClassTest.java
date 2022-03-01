package com.wndexx.java2;
/*
 * JDK8: 除了定义全局常量和抽象方法，还可以定义静态方法、默认方法
 */
public class SubClassTest {
	public static void main(String[] args) {

		SubClass s = new SubClass();

		// 知识点1：接口中定义的静态方法，只能通过接口来调用
		// s.method1(); // The method method1() is undefined for the type SubClass
		// SubClass.method1(); // The method method1() is undefined for the type
		CompareA.method1(); // CompareA: 北京

		// 知识点2：通过实现类的对象可以调用接口中的默认方法
		// 如果实现类重写了接口中的默认方法，调用时，调用的是重写以后的方法
		s.method2();

		// 知识点3：如果子类(或实现类)继承的父类和实现的接口中，声明了同名同参数的方法，那么子类在没有重写此方法的情况下，默认调用的是父类中的同名同参数的方法
		// ----> 类优先原则
		// 但是属性没有类优先原则，如果继承的父类和实现的接口中声明了同名的属性，那么子类在调用该属性时如果不显式指定则会出现编译错误，无法确定调用哪一个属性。
		s.method3();
		// SubClass.method2(); // Cannot make a static reference to the non-static method method2() from the type CompareA

		// 知识点4：如果实现类实现了多个接口，而这多个接口中定义了同名同参数的默认方法，那么在实现类没有重写此方法的情况下，报错 -----> 接口冲突
		// 这就需要我们必须在实现类中重写此方法
		
	}
}

class SubClass extends SuperClass implements CompareA, CompareB {
	public void method2() {
		System.out.println("SubClass:上海");
	}

	public void method3() {
		System.out.println("SubClass:深圳");
	}
	
	// 知识点5：如何在子类(或实现类)的方法中调用父类、接口中被重写的方法
	public void myMethod() {
		method3(); // 调用的是自己定义的重写的方法
		super.method3(); // 调用的是父类中声明的
		CompareA.super.method3(); // 调用接口中的默认方法
		CompareB.super.method3();
	}
}
