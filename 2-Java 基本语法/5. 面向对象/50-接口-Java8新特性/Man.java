package com.wndexx.java2;

class Man extends Father implements Filial, Spoony {
	// public void help() {
	//	  System.out.println("我该怎么办呢？");
	//    Filial.super.help();
	//    Spoony.super.help();
	// }
}

class Father {
	public void help() {
		System.out.println("儿子，救我媳妇");
	}
}

interface Filial {// 孝顺的
	default void help() {
		System.out.println("老妈，我来救你了");
	}
}

interface Spoony {// 痴情的
	default void help() {
		System.out.println("媳妇，别怕，我来了");
	}
}