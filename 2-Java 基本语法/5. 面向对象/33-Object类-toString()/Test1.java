package com.wndexx.exer3;
// 字符串的拼接中如果有引用类型对象，会自动调用对象的 toString() 方法
public class Test1 {

	public static void main(String[] args) {
		
		C c = new C();
		c.b = new B();
		c.b.a = new A();
		c.b.a.a = 1;
		System.out.println(c);
	}
}

class A {
	int a;

	@Override
	public String toString() {
		return "A [a=" + a + "]";
	}
}

class B {
	A a;

	@Override
	public String toString() {
		return "B [a=" + a + "]";
	}
}

class C {
	B b;

	@Override
	public String toString() {
		return "C [b=" + b + "]";
	}
}