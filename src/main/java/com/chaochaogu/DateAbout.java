package com.chaochaogu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author chaochao Gu
 * @date 2019/12/30
 */
public class DateAbout {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2019-12-30");
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
        System.out.println(DateTimeFormatter.ofPattern("YYYY-MM-dd").format(date));
    }
}
