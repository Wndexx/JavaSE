package com.wndexx.exer2;

/*
	请根据以下代码自行定义能满足需要的MyDate类,在MyDate类中覆盖equals方法，
	使其判断当两个MyDate类型对象的年月日都相同时，结果为true，否则为false。
	public boolean equals(Object o)
 */
public class MyDateTest {

	public static void main(String[] args) {

		MyDate date1 = new MyDate(2022, 1, 1);
		MyDate date2 = new MyDate(2022, 1, 1);

		System.out.println(date1 == date2);
		System.out.println(date1.equals(date2));
	}

}

class MyDate {
	private int year;
	private int month;
	private int day;

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj instanceof MyDate) {
			MyDate date = (MyDate) obj;
			return this.year == date.year && this.month == date.month && this.day == date.day;
		}
		return false;
	}
}