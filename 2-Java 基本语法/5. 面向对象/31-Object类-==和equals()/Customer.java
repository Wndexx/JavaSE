package com.wndexx.java1;

import java.util.Objects;

public class Customer {

	private String name;
	private int age;

	public Customer() {
		super();
	}

	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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

	// 重写的原则：比较两个对象的实体内容(即：name 和 age)是否相同
	// 手动实现 equals() 的重写
	// public boolean equals(Object obj) {
	// 	 if (this == obj)
	//		 return true;
	//	 if (obj instanceof Customer) {
	//		 Customer cust = (Customer) obj;
	//		 // 比较两个对象的每个属性是否都相同
	//		 return this.name.equals(cust.name) && this.age == cust.age;
	//	 }
	//	 return false;
	// }
	
	// 自动生成的
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	// 手动实现
	// @Override
	// public String toString() {
	// 	 return "Customer[name = " + name + ", age = " + age + "]";
	// }
	
	// 自动实现
	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + "]";
	}
	
	
}
