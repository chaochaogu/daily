package com.chaochaogu.daily.about;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author chaochao Gu
 * @date 2020/12/28
 */
public class MapAbout {
    public static void main(String[] args) {
        Map<Long, String> map = Maps.newHashMap();
        System.out.println(map.containsKey(null));
        map.put(null, "fool");
    }
}
