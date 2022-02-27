package com.wndexx.java;

import org.junit.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Set;

/**
 * jdk 8 中日期时间 API 的测试
 *
 * @author wndexx
 * @create 2022-02-26 14:31
 */
/*
	日期时间 API 的迭代：
	
		第一代：jdk 1.0 Date 类
		
		第二代：jdk 1.1 Calendar 类，一定程度上替换 Date 类
		
		第三代：jdk 1.8 提出了新的一套 API
	
	
    JDK 1.0中包含了一个java.util.Date类，但是它的大多数方法已经在JDK 1.1引入Calendar类之后被弃用了。而Calendar并不比Date好多少。

    它们面临的问题是：

        可变性：像日期和时间这样的类应该是不可变的。

        偏移性：Date中的年份是从1900开始的，而月份都从0开始
        
        格式化：格式化只对Date有用，Calendar则不行。

        此外，它们也不是线程安全的；不能处理闰秒等
*/

/*
    JDK 8 新时间日期API

        java.time – 包含值对象的基础包

        java.time.chrono – 提供对不同的日历系统的访问

        java.time.format – 格式化和解析时间和日期

        java.time.temporal – 包括底层框架和扩展特性

        java.time.zone – 包含时区支持的类

*/
public class JDK8DateTimeTest {

    @Test
    public void testDate() {
        // 偏移量
        Date date1 = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date1); // Tue Sep 08 00:00:00 CST 2020
    }

    /*
        LocalDate、LocalTime、LocalDateTime 的使用

        方法 描述
            now() / * now(ZoneId zone)                  静态方法，根据当前时间创建对象/指定时区的对象

            of()                                        静态方法，根据指定日期/时间创建对象

            getDayOfMonth() / getDayOfYear()            获得月份天数(1-31) /获得年份天数(1-366)

            getDayOfWeek()                              获得星期几(返回一个 DayOfWeek 枚举值)

            getMonth()                                  获得月份, 返回一个 Month 枚举值

            getMonthValue() / getYear()                 获得月份(1-12) /获得年份

            getHour() / getMinute() / getSecond()       获得当前对象对应的小时、分钟、秒

            withDayOfMonth() / withDayOfYear() /
            withMonth() / withYear()                    将月份天数、年份天数、月份、年份修改为指定的值并返回新的对象

            plusDays() / plusWeeks() /
            plusMonths() / plusYears() / plusHours()    向当前对象添加几天、几周、几个月、几年、几小时

            minusMonths() / minusWeeks() /
            minusDays() / minusYears() / minusHours()   从当前对象减去几月、几周、几天、几年、几小时


        说明：

            1. LocalDateTime 相较于 LocalDate、LocalTime，使用频率较高

            2. 类似于 Calendar
    */
    @Test
    public void test1() {
        // 1. 实例化
        // (1) now()：获取当前的日期、时间、日期 + 时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate); // 2022-02-26
        System.out.println(localTime); // 14:49:40.248
        System.out.println(localDateTime); // 2022-02-26T14:49:40.248

        // (2) of()：设定指定的年、月、日、时、分、秒，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 11, 2, 12, 22, 33);
        System.out.println(localDateTime1); // 2020-11-02T12:22:33

        // 2. getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth()); // 26
        System.out.println(localDateTime.getDayOfWeek()); // SATURDAY
        System.out.println(localDateTime.getMonth()); // FEBRUARY
        System.out.println(localDateTime.getMonthValue()); // 2
        System.out.println(localDateTime.getMinute()); // 14

        // 3. LocalDate、LocalTime、LocalDateTime，具有不可变性
        // withXxx：设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate); // 2022-02-26
        System.out.println(localDate1); // 2022-02-22

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime); // 2022-02-26T16:22:43.468
        System.out.println(localDateTime2); // 2022-02-26T04:22:43.468

        // 4. plusXxx        不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime); // 2022-02-26T16:24:54.271
        System.out.println(localDateTime3); // 2022-05-26T16:24:54.271

        // 5. minusXxx       不可变性
        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime); // 2022-02-26T16:34:12.053
        System.out.println(localDateTime4); // 2022-02-20T16:34:12.053

    }


    /*
        Instant 的使用

        类似于 java.util.Date 类

        Instant：时间线上的一个瞬时点。 这可能被用来记录应用程序中的事件时间戳
		
		表示自 1970 年 1 月 1 日 0 时 0 分 0 秒(UTC) 开始的秒数

    */
    @Test
    public void test2() {
        // 1. now()：静态方法，获取本初子午线对应的标准时间（中时区）
        Instant instant = Instant.now();
        System.out.println(instant); // 2022-02-26T08:41:10.669Z

        // 2. atOffset()：添加时间的偏移量(东八区)
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime); // 2022-02-26T16:44:57.847+08:00

        // 3. toEpochMilli(): 返回 1970-01-01 00:00:00（UTC） 到当前时间的毫秒数，即为时间戳  ---> Date 类的 getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli); // 1645865389175

        // 4. ofEpochMilli(long epochMilli)：静态方法，返回在1970-01-01 00:00:00基础上加上指定毫秒数之后的 Instant 类的对象 ---> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1645865389175L);
        System.out.println(instant1); // 2022-02-26T08:49:49.175Z
    }

    /*
        DateTimeFormatter：格式化或解析日期、时间

            类似于 SimpleDateFormat

        1. 实例化

            方式一：预定义的标准格式。如：SO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME

            方式二：本地化相关的格式。如：ofLocalizedDateTime(FormatStyle.LONG)

            方式三：自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)

    */
    @Test
    public void test3() {
        // 方式一：预定义的标准格式。如：SO_LOCAL_DATE_TIME;ISO_LOCAL_DATE;ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        // 格式化：日期 ---> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);

        System.out.println(localDateTime); // 2022-02-26T17:02:57.933
        System.out.println(str1); // 2022-02-26T17:02:57.933

        // 解析：字符串 ---> 日期
        TemporalAccessor parse = formatter.parse("2022-02-26T17:02:57.933");
        System.out.println(parse); // {},ISO resolved to 2022-02-26T17:02:57.933

        // 方式二：
        // 本地化相关的格式。如：ofLocalizedDateTime()
        // FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT：适用于 LocalDateTime
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2); // 22-2-26 下午5:16

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        String str3 = formatter2.format(localDateTime);
        System.out.println(str3); // 2022年2月26日 下午05时17分50秒

        // 本地化相关的格式。如：ofLocalizedDate()
        // FormatStyle.FULL / FormatStyle.LONG / FormatStyle.MEDIUM / FormatStyle.SHORT：适用于 LocalDate
        DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str4 = formatter3.format(LocalDate.now());
        System.out.println(str4); // 2022年2月26日 星期六

        // 重点：方式三：自定义的格式。如：ofPattern("yyyy-MM-dd hh:mm:ss")
        DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        // 格式化
        String str5 = formatter4.format(localDateTime);
        System.out.println(str5); // 2022-02-26 05:24:56

        // 解析
        LocalDateTime parse1 = LocalDateTime.parse("2022-02-26 05:24:56", formatter4);

        TemporalAccessor accessor = formatter4.parse("2022-02-26 05:24:56");
        System.out.println(accessor.getClass());
        System.out.println(accessor); // {MinuteOfHour=24, NanoOfSecond=0, HourOfAmPm=5, SecondOfMinute=56, MicroOfSecond=0, MilliOfSecond=0},ISO resolved to 2022-02-26
    }

    /*
       其它API

           ZoneId                   该类中包含了所有的时区信息，一个时区的ID，如 Europe/Paris

           ZonedDateTime            一个在ISO-8601日历系统时区的日期时间，如 2007-12-03T10:15:30+01:00 Europe/Paris。

               其中每个时区都对应着ID，地区ID都为“{区域}/{城市}”的格式，例如：Asia/Shanghai等

           Clock                    使用时区提供对当前即时、日期和时间的访问的时钟。

           持续时间：Duration        用于计算两个 "时间" 间隔

           日期间隔：Period          用于计算两个 "日期" 间隔

           TemporalAdjuster         时间校正器。有时我们可能需要获取例如：将日期调整到 "下一个工作日" 等操作。

           TemporalAdjusters        该类通过静态方法(firstDayOfXxx()/lastDayOfXxx()/nextXxx())提供了大量的常用 TemporalAdjuster 的实现

   */
    @Test
    public void test5() {
        /*

            //ZoneId:类中包含了所有的时区信息
            // ZoneId的getAvailableZoneIds():获取所有的ZoneId
            Set<String> zoneIds = ZoneId.getAvailableZoneIds();
            for (String s : zoneIds) {
                System.out.println(s);
            }

            // ZoneId的of():获取指定时区的时间
            LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Tokyo"));
            System.out.println(localDateTime);

            //ZonedDateTime:带时区的日期时间
            // ZonedDateTime的now():获取本时区的ZonedDateTime对象
            ZonedDateTime zonedDateTime = ZonedDateTime.now();
            System.out.println(zonedDateTime);

            // ZonedDateTime的now(ZoneId id):获取指定时区的ZonedDateTime对象
            ZonedDateTime zonedDateTime1 = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
            System.out.println(zonedDateTime1);

        */

        /*
            //Duration:用于计算两个“时间”间隔，以秒和纳秒为基准
            LocalTime localTime = LocalTime.now();
            LocalTime localTime1 = LocalTime.of(15, 23, 32);

            //between():静态方法，返回Duration对象，表示两个时间的间隔
            Duration duration = Duration.between(localTime1, localTime);
            System.out.println(duration);
            System.out.println(duration.getSeconds());
            System.out.println(duration.getNano());

            LocalDateTime localDateTime = LocalDateTime.of(2016, 6, 12, 15, 23, 32);
            LocalDateTime localDateTime1 = LocalDateTime.of(2017, 6, 12, 15, 23, 32);
            Duration duration1 = Duration.between(localDateTime1, localDateTime);
            System.out.println(duration1.toDays());
        */

        /*
            //Period:用于计算两个“日期”间隔，以年、月、日衡量
            LocalDate localDate = LocalDate.now();
            LocalDate localDate1 = LocalDate.of(2028, 3, 18);
            Period period = Period.between(localDate, localDate1);
            System.out.println(period);
            System.out.println(period.getYears());
            System.out.println(period.getMonths());
            System.out.println(period.getDays());
            Period period1 = period.withYears(2);
            System.out.println(period1);
        */

        /*
            // TemporalAdjuster:时间校正器
            // 获取当前日期的下一个周日是哪天？
            TemporalAdjuster temporalAdjuster = TemporalAdjusters.next(DayOfWeek.SUNDAY);
            LocalDateTime localDateTime = LocalDateTime.now().with(temporalAdjuster);
            System.out.println(localDateTime);

            // 获取下一个工作日是哪天？
            LocalDate localDate = LocalDate.now().with(new TemporalAdjuster() {
                @Override
                public Temporal adjustInto(Temporal temporal) {
                    LocalDate date = (LocalDate) temporal;
                    if (date.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                        return date.plusDays(3);
                    } else if (date.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                        return date.plusDays(2);
                    } else {
                        return date.plusDays(1);
                    }
                }
            });
            System.out.println("下一个工作日是：" + localDate);
        */
    }


    /*
        与传统日期处理的转换

            类                                       To 遗留类                                From 遗留类

            java.time.Instant与java.util.Date        Date.from(instant)                      date.toInstant()

            java.time.Instant与java.sql.Timestamp    Timestamp.from(instant)                 timestamp.toInstant()

            java.time.ZonedDateTime 与
            java.util.GregorianCalendar              GregorianCalendar.from(zonedDateTime)   cal.toZonedDateTime()

            java.time.LocalDate与java.sql.Date       Date.valueOf(localDate)                 date.toLocalDate()

            java.time.LocalTime与java.sql.Time       Date.valueOf(localDate)                 date.toLocalTime()

            java.time.LocalDateTime与
            java.sql.Timestamp                       Timestamp.valueOf(localDateTime)        timestamp.toLocalDateTime()

            java.time.ZoneId与java.util.TimeZone     Timezone.getTimeZone(id)                timeZone.toZoneId()

            java.time.format.DateTimeFormatter与
            java.text.DateFormat                     formatter.toFormat()                           无

    */

    @Test
    public void test6() {
        LocalDate now = LocalDate.now();
        java.sql.Date date = java.sql.Date.valueOf(now);

        LocalTime time = LocalTime.now();
        Time time1 = Time.valueOf(time);

        LocalDateTime now1 = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now1);

        long l = timestamp.getTime();
    }

}
