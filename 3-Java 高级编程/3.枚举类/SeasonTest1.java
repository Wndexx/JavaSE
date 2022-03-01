package com.wndexx.java;

/**
 * @author wndexx
 * @create 2022-02-27 16:13
 */
/*
    使用 enum 关键字定义枚举类

    说明：定义的枚举类默认继承于 java.lang.Enum 类
*/
public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 autumn = Season1.AUTUMN;

        // 1. toString()：返回枚举类对象的名称
        System.out.println(autumn.toString()); // AUTUMN

        // System.out.println(Season1.class.getSuperclass()); // class java.lang.Enum

        System.out.println("***********************************************");

        // 2. values()：返回所有枚举类对象构成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            values[i].show();
        }

        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }

        // 3. valueOf(String objName)：返回枚举类中对象名是 objName 的对象
        // 如果没有 objName 的枚举类对象，则抛异常，java.lang.IllegalArgumentException
        // Season1 winter = Season1.valueOf("WINTER1"); // java.lang.IllegalArgumentException
        Season1 winter = Season1.valueOf("WINTER"); // WINTER
        System.out.println(winter);
        winter.show(); // 大约在冬季
    }
}

interface Info {
    void show();
}

// 使用 enum 关键字定义枚举类
enum Season1 implements Info{
    // 1. 提供当前枚举类的对象，多个对象之间用 "," 隔开，末尾对象 ";" 结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    // 2. 声明 Season 对象的属性：private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 3. 私有化类的构造器，并给对象属性赋值
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 4. 其他诉求:
    // (1) 获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    /*
        // (2) 提供 toString()
        @Override
        public String toString() {
            return "Season{" +
                    "seasonName='" + seasonName + '\'' +
                    ", seasonDesc='" + seasonDesc + '\'' +
                    '}';
        }
    */

    /*@Override
    public void show() {
        System.out.println("这是一个季节");
    }*/

}
