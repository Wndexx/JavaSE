package com.wndexx.exer2;

import java.util.Calendar;
import java.util.Scanner;

/*
	定义PayrollSystem类，创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
	利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday,以及该对象工资。
	当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
*/
public class PayrollSystem {
	public static void main(String[] args) {
		
		// 方式一：
		// Scanner scan = new Scanner(System.in);
		// System.out.print("请输入月份：");
		// int month = scan.nextInt();
		
		// 方式二：
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;// 获取当前月份
		// System.out.println(month); // 一月份：0

		Employee[] employees = new Employee[2];
		employees[0] = new SalariedEmployee("张三", 1001, new MyDate(1991, 1, 1), 5000);
		employees[1] = new HourlyEmployee("李四", 1002, new MyDate(1994, 4, 6), 100, 46);

		for (int i = 0; i < employees.length; i++) {
			Employee emp = employees[i];
			int salary = emp.earnings();
			if (month == emp.getBirthday().getMonth())
				salary += 100;
			System.out.println(emp + " 月工资：" + salary);
		}
	}
}
