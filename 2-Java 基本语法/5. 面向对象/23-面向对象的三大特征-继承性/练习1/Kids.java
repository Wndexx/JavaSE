package com.wndexx.exer;

public class Kids extends Mankind {
	
	int yeasOld;
	
	public Kids() {
		
	}

	public Kids(int yeasOld) {
		this.yeasOld = yeasOld;
	}

	public int getYeasOld() {
		return yeasOld;
	}

	public void setYeasOld(int yeasOld) {
		this.yeasOld = yeasOld;
	}

	public void printAge() {
		System.out.println("年龄：" + yeasOld);
	}
	
	// 在Kids中重新定义 employeed() 方法，覆盖父类ManKind中定义的 employeed()方法，输出“Kid should study and no job.”
	public void employeed() {
		System.out.println("Kid should study and no job.");
	}
}
