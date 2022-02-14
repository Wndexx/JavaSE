package com.wndexx.exer1;

public class EmployeeTest {
	public static void main(String[] args) {

		// 多态
		Employee manager = new Manager("库克", 1001, 5000, 50000);
		manager.work();
		
		Employee employee = new CommonEmployee();
		employee.work();
	}
}
