package com.wndexx.exer;

/**
 * @Description 几何图形
 * @author wndexx
 * @version
 * @date 2022年2月11日上午11:50:51
 */
public abstract class GeometricObject { // 几何图形

	protected String color;
	protected double weight;

	protected GeometricObject(String color, double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public abstract double findArea();
}