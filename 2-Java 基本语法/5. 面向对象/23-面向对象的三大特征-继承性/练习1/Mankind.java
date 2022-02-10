package com.wndexx.exer;

/*
	 2. (1)定义一个ManKind类，包括
		成员变量int sex和int salary；
		方法void manOrWoman()：根据sex的值显示“man”(sex==1)或者“woman”(sex==0)；
		方法void employeed()：根据salary的值显示“no job”(salary==0)或者“ job”(salary!=0)。
		
		(2)定义类Kids继承ManKind，并包括
		成员变量int yearsOld；
		方法printAge()打印yearsOld的值。
		
		(3)定义类KidsTest，在类的main方法中实例化Kids的对象someKid，用该对象访问其父类的成员变量及方法。
 */
public class Mankind {

	private int sex; // 性别
	private int salary; // 薪资
	
	public Mankind() {
		
	}
	
	public Mankind(int sex, int salary) {
		this.sex = sex;
		this.salary = salary;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public void manOrWoman() {
		if (sex == 1) {
			System.out.println("man");
		} else if (sex == 0) {
			System.out.println("woman");
		}
	}

	public void employeed() {
		String jobInfo = salary == 0 ? "no job" : "job";
		System.out.println(jobInfo);
	}
}
