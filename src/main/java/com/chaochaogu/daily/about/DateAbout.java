package com.chaochaogu.daily.about;

import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @author chaochao Gu
 * @date 2019/12/30
 */
public class DateAbout {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("2019-12-30");
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(date));
        System.out.println(DateTimeFormatter.ofPattern("YYYY-MM-dd").format(date));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
        LocalDateTime localDateTime = LocalDateTime.from(formatter.parse("201912311420"));
        Date fromDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        DateTime now = DateTime.now();
        System.out.println(now.plusMonths(3).monthOfYear().get());
        // jodaTime与java date转换
        DateTime jodaTime = new DateTime(new Date());
        // 指定特定日期
        jodaTime.withDayOfMonth(4);
        jodaTime.isAfterNow();
        jodaTime.isBeforeNow();
        jodaTime.plusHours(3);
        org.joda.time.format.DateTimeFormatter jodaFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime time1 = jodaFormatter.parseDateTime("2020-09-23 11:23:34");
        DateTime time2 = jodaFormatter.parseDateTime("2020-09-23 11:24:34");
        DateTime time3 = jodaFormatter.parseDateTime("2020-09-23 11:26:34");
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<String> times = Lists.newArrayList();
        times.add("2020-09-23 11:24:34");
        times.add("2020-09-23 11:26:34");
        times.add("2020-09-23 11:23:34");
        times.sort((v1, v2) -> LocalDateTime.from(pattern.parse(v2)).compareTo(LocalDateTime.from(pattern.parse(v1))));
        System.out.println(times);
        System.out.println(new DateTime(
                new Date()).withTimeAtStartOfDay().plusHours(12).toDate().getTime());

        System.out.println("test before now");
        String createdStr = "2021-02-05 14:38:26";
        String nowStr = "2021-02-05 15:08:59";
        System.out.println(jodaFormatter.parseDateTime(createdStr).plusMinutes(30).isBefore(jodaFormatter.parseDateTime(nowStr)));
        String fakeCreatedStr = "2021-02-05 15:25:23";
        System.out.println(jodaFormatter.parseDateTime(fakeCreatedStr));

        org.joda.time.format.DateTimeFormatter UTCFT = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        String UTCTime = "2017-11-30T10:41:44.651Z";
        System.out.println(UTCFT.parseDateTime(UTCTime));
    }
}
