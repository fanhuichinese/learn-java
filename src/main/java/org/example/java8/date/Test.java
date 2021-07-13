package org.example.java8.date;

import java.time.*;

public class Test {

    public static void main(String[] args) {
        // testLocalDateTime();
        testZonedDateTime();
    }

    public static void testLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间: " + now);

        LocalDate localDate = now.toLocalDate();
        System.out.println("当前日期：" + localDate);

        Month month = now.getMonth();
        int dayOfMonth = now.getDayOfMonth();
        int second = now.getSecond();
        System.out.println("月: " + month + ", 日: " + dayOfMonth + ", 秒: " + second);

        LocalDateTime localDateTime = now.withDayOfMonth(10).withYear(2012);
        System.out.println("设置了当前时间的年份和日：" + localDateTime);

        LocalDate of = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("设置了新时间的年月日：" + of);

        LocalTime of1 = LocalTime.of(22, 15);
        System.out.println("设置了新时间的时分：" + of1);

        LocalTime parse = LocalTime.parse("20:15:30");
        System.out.println("解析时间：" + parse);
    }

    public static void testZonedDateTime() {
        ZonedDateTime parse = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("解析后的时间：" + parse);

        ZoneId of = ZoneId.of("Europe/Paris");
        System.out.println("巴黎时区：" + of);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("当前时区：" + zoneId);
    }

}
