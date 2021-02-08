package com.chaochaogu.daily.about;

import com.google.common.collect.Lists;

import java.text.SimpleDateFormat;
import java.util.*;

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
        List<Integer> numList = Lists.newArrayListWithCapacity(5);
        for (int i = 0; i < 5; i++) {
            numList.add(i + 1);
        }
        Collections.sort(numList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(numList);
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
