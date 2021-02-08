package com.chaochaogu.daily.about;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author chaochao Gu
 * @date 2019/12/11
 */
public class Java8About {
    public static void main(String[] args) {
        LocalDateTime before = LocalDateTime.now().minusDays(10);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(ChronoUnit.DAYS.between(before, now));
    }
}
