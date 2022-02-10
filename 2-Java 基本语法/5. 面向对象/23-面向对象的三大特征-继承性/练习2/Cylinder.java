package com.wndexx.exer1;

public class Cylinder extends Circle {

	private double length;

	public Cylinder() {
		length = 1.0;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	@Override
	public double findArea() { // 返回圆柱的表面积
		return Math.PI * getRadius() * getRadius() * 2 + Math.PI * getRadius() * 2 * getLength();
	}
	
	// 体积
	public double findVolume() {
		// return findArea() * length;
		return super.findArea() * getLength();
	}
}
