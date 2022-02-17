package com.wndexx.team.service;
/**
 * @Description TeamException 异常类
 * @author wndexx
 * @version
 * @date 2022年2月16日下午3:05:08
 */
public class TeamException extends Exception{

	static final long serialVersionUID = -703485766939L;

	public TeamException() {

	}

	public TeamException(String msg) {
		super(msg);
	}
}
