package com.chaochaogu.daily.utils.responsibility.parse.time;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 解析不同格式时间 - 责任链模式
 *
 * @author chaochao Gu
 * @date 2021/2/25
 */
public class Client {
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("2021-02-05 14:38:26", "2017-11-30T10:41:44.651Z");
        NormalDateTimeHandler normal = new NormalDateTimeHandler();
        UTCDateTimeHandler utc = new UTCDateTimeHandler();
        normal.setNext(utc);
        for (String s : list) {
            System.out.println(normal.handleTime(s));
        }
    }
}
