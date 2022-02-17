package com.wndexx.team.domain;

/**
 * @Description 员工类
 * @author wndexx
 * @version
 * @date 2022年2月16日上午11:32:07
 */
public class Employee {
	/**
	 * id
	 */
	private int id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 工资
	 */
	private double salary;

	public Employee() {
		super();
	}

	public Employee(int id, String name, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDetails() {
		return id + "\t" + name + "\t" + age + "\t" + salary;
	}

	@Override
	public String toString() {
		return getDetails();
	}

}
