package com.wndexx.team.service;
/**
 * @Description 表示员工的状态
 * @author wndexx
 * @version
 * @date 2022年2月17日下午12:29:52
 */
public class Status {
	private final String NAME;

	private Status(String name) {
		this.NAME = name;
	}

	public static final Status FREE = new Status("FREE");
	public static final Status VOCATION = new Status("VOCATION");
	public static final Status BUSY = new Status("BUSY");

	public String getNAME() {
		return NAME;
	}

	@Override
	public String toString() {
		return NAME;
	}
}
