package com.chaochaogu.daily.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.Objects.isNull;

/**
 * Description: to do something
 * User: lg
 * Date: 2018/09/04
 */
public class DateUtil {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * @param date
     * @return
     * @Description 日期转字符串
     * @Date 2018/8/9
     */
    public static String dateFormate(Date date) {

        return sdf.format(date);
    }

    /**
     * @param date
     * @return
     * @Description 字符串转日期
     * @Date 2018/8/9
     */
    public static Date dateParse(String date) {
        try {
            return sdf.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转换Epoch时间
     *
     * @param date
     * @return
     */
    public static Long toEpochSecond(Date date) {
        if (isNull(date)) {
            return null;
        }
        return date.toInstant().getEpochSecond();
    }

}
