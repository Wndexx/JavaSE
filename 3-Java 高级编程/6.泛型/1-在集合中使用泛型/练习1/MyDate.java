package com.wndexx.exer;

/**
 * MyDate 类包含:
 * private 成员变量 year,month,day；并为每一个属性定义 getter, setter方法
 *
 * @author wndexx
 * @create 2022-03-02 17:09
 */
public class MyDate implements Comparable<MyDate> {

    private int year;
    private int month;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int month, int day) {
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
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }


    // @Override
    // public int compareTo(Object o) {
    //     if (!(o instanceof MyDate))
    //         throw new RuntimeException("输入的数据类型不匹配");
    //
    //     MyDate m = (MyDate) o;
    //     // 比较年
    //     int compareYear = Integer.compare(this.getYear(), m.getYear());
    //     if (compareYear != 0)
    //         return compareYear;
    //
    //     // 比较月
    //     int compareMonth = Integer.compare(this.getMonth(), m.getMonth());
    //     if (compareMonth != 0)
    //         return compareMonth;
    //
    //     // 比较日
    //     return Integer.compare(this.getDay(), m.getDay());
    // }

    @Override
    public int compareTo(MyDate m) {
        // 比较年
        int compareYear = Integer.compare(this.getYear(), m.getYear());
        if (compareYear != 0)
            return compareYear;

        // 比较月
        int compareMonth = Integer.compare(this.getMonth(), m.getMonth());
        if (compareMonth != 0)
            return compareMonth;

        // 比较日
        return Integer.compare(this.getDay(), m.getDay());
    }
}
