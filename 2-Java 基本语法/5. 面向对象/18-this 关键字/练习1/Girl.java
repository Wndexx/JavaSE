package com.wndexx.exer2;

/*
 	练习
 	添加必要的构造器，综合应用构造器的重载，this关键字。
  
	Boy
	-name:String
	-age:int
	+setName(i: String)
	+getName(): String
	+setAge(i: int)
	+getAge(): int
	+marry(girl:Girl)
	+shout():void
	
	Girl
	-name:String
	-age:int
	+setName(i: String)
	+getName(): String
	+marry(boy:Boy)
	+compare(girl:Girl)
 */
public class Girl {

	private String name;
	private int age;

	public Girl() {

	}

	public Girl(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void marry(Boy boy) {
		System.out.println("嫁给" + boy.getName());
		boy.marry(this);
	}

	/**
	 * 
	 * @Description 比较两个对象的大小
	 * @author wndexx
	 * @date 2022年2月7日下午8:01:33
	 * @param girl
	 * @return 正数：当前对象大；负数：当前对象小；0：当前对象与形参对象相等
	 *
	 */
	public int compare(Girl girl) {
		
		// if(this.age > girl.age) {
		//	return 1;
		// }else if(this.age < girl.age){
		//	return -1;
		// }else {
		//	return 0;
		// }
		
		return this.age - girl.age;
	}
}
