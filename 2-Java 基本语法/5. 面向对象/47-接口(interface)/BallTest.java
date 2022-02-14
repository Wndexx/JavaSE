package com.wndexx.java1;
// 面试题2
public class BallTest {

}

interface Playable{
	void play();
}

interface Bounceable{
	void play();
}

interface Rollable extends Playable,Bounceable{
	Ball ball = new Ball("PingPang"); // public static abstract
}

class Ball implements Rollable{
	private String name;
	
	public Ball(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	// 这里 play() 既可以认为是对 Playable 的 play() 方法的实现，也可以认为是对 Bounceable 的 play() 方法的实现
	public void play(){
		// ball = new Ball("Football"); // ball 是一个全局常量 
		System.out.println(ball.getName());
	}
}