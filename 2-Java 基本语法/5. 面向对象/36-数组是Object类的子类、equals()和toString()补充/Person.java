package com.wndexx.java;

import java.util.Objects;

public class Person {
	
	String name;
	int age;
	
	
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// @Override
	// public boolean equals(Object obj) {
	//	 if (this == obj)
	//		 return true;
	//	 if (obj == null)
	//		 return false;
	//	 if (getClass() != obj.getClass())
	//		 return false;
	//	 Person other = (Person) obj;
	//	 return age == other.age && Objects.equals(name, other.name);
	// }
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		// obj instanceof Person 有漏洞！！
		if(obj instanceof Person) {
			Person p = (Person) obj;
			return age == p.age && name.equals(p.name);
		}
		return false;
	}
}
