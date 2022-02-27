package com.wndexx.java;

/**
 * @author wndexx
 * @create 2022-02-27 15:45
 */
/*
    一、枚举类的使用

        1. 枚举类的理解：类的对象只有有限个、确定个，我们称此类为枚举类

        2. 当需要定义一组常量时，强烈建议使用枚举类

        3. 如果枚举类中只有一个对象，则可以作为单例模式的一种实现方式

    二、如何定义枚举类

        方式一：jdk 5.0 之前，自定义枚举类

        方式二：jdk5.0，可以使用 enum 关键字定义枚举类

    三、Enum 类中的常用方法

        values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有的枚举值。

        valueOf(String str)：可以把一个字符串转为对应的枚举类对象。要求字符串必须是枚举类对象的“名字”。如不是，会有运行时异常：IllegalArgumentException。

        toString()：返回当前枚举类对象常量的名称



        valueOf             传递枚举类型的 Class 对象和枚举常量名称给静态方法　valueOf，会得到与参数匹配的枚举常量

        toString            得到当前枚举常量的名称，你可以通过重写这个方法来使得到的结果更易读

        equals              在枚举类型中可以直接使用 "==" 来比较两个枚举常量是否相等。

                            Enum 提供的这个 equals() 方法，也是直接使用 "==" 实现的，它的存在是为了 Set、List和 Map 中使用

                            注意，equals() 是不可变的

        hashCode            Enum 实现了 hashCode() 来和 equals 保持一致，它也是不可变的

        getDeclaringClass   得到枚举常量所属枚举类型的 Class 对象，可以用它来判断两个枚举常量是否属于同一个枚举类型

        name                得到当前枚举常量的名称，建议优先使用 toString()

        ordinal             得到当前枚举常量的次序

        compareTo           枚举类型实现了 Comparable 接口，这样可以比较两个枚举常量的大小（按照声明的顺序排列）

        clone               枚举类型不能被 clone，为了防止子类实现克隆方法，Enum 实现了一个仅抛出 CloneNotSupportedException 异常的不变 clone()


    四、使用 enum 关键字定义的枚举类实现接口的情况

        情况一：实现接口，在 enum 类中实现抽象方法

        情况二：让枚举类的对象分别实现接口中的抽象方法

*/


public class SeasonTest {
    public static void main(String[] args) {

        Season spring = Season.SPRING;
        System.out.println(spring);

    }
}

// 自定义枚举类
class Season {
    // 1. 声明 Season 对象的属性：private final 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化类的构造器，并给对象属性赋值
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3. 提供当前枚举类的多个对象：public static final 修饰
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    // 4. 其他诉求:
    // (1) 获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // (2) 提供 toString()
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}