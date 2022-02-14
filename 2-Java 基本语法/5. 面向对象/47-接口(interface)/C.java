package com.wndexx.java1;
// 面试题1
interface A {
	int x = 0; // public static abstract
	int x1 = 0;
}

class B {
	int x = 1;
	int x2 = 1;
}

class C extends B implements A {
	public void pX() {
		// 编译不通过，因为 x 是不明确的
		// System.out.println(x); // x 模棱两可 ambiguous
		
		// System.out.println(A.x); // 0
		// System.out.println(super.x); // 1
		
		System.out.println(x1); // 0
		System.out.println(x2); // 1
	}

	public static void main(String[] args) {
		new C().pX(); //
	}
}
