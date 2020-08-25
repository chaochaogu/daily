package com.chaochaogu.daily;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author chaochao Gu
 * @date 2020/2/12
 */
public class ComparatorAbout {
    public static void main(String[] args) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = format.parse("2020-01-01 09:11:23");
        Date date2 = format.parse("2020-01-01 09:12:24");
        List<Date> dateList = new ArrayList<>();
        dateList.add(date2);
        dateList.add(date1);
        Response response = new Response();
        response.name = "chao";
        response.dateList = dateList;
        System.out.println("unsorted response" + "\n" + response);
        response.dateList.sort(Comparator.comparing(date -> date));
        System.out.println("sorted response" + "\n" + response);
    }

    public static class Response {
        String name;
        List<Date> dateList;

        @Override
        public String toString() {
            return "Response{" +
                    "name='" + name + '\'' +
                    ", dateList=" + dateList +
                    '}';
        }
    }
}
