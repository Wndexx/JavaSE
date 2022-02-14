package com.wndexx.java2;

public interface CompareB {
	// 这里只是省略了 public ，但权限还是 public
	default void method3() {
		System.out.println("CompareB:上海");
	}
}
