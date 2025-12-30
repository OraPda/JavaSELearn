package com.NetProjectAndPracticeDemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeDemo {
    public static void main(String[] args) {
//        掌握java提供的获取时间的方式
        Date date = new Date();
        System.out.println(date);

//        格式化：SimpleDateFormat
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);

//        jdk8 新特性：LocalDate、LocalTime、LocalDateTime
        LocalDateTime localTime = LocalDateTime.now();
        System.out.println(localTime);
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(localTime.getYear());
        System.out.println(localTime.getMonthValue());
        System.out.println(localTime.getDayOfMonth());

//        格式化：
        System.out.println(localTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss EEE a")));

    }
}
