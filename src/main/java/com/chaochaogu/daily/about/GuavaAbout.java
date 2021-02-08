package com.chaochaogu.daily.about;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author chaochao Gu
 * @date 2019/12/5
 */
public class GuavaAbout {
    public static void main(String[] args) {
        System.out.println(Maps.newHashMap().isEmpty());
        Map<Long/*shipmentId*/, Map<Long/*skuOrderId*/, Integer/*refundNum*/>> shipmentRefundMap = Maps.newHashMap();
        System.out.println(shipmentRefundMap.size());
        String brandIdsStr = "1,3,,230";
        List<String> collect = Splitter.on(",").splitToList(brandIdsStr).stream().distinct().collect(Collectors.toList());
        System.out.println(Arrays.toString(brandIdsStr.split(",")));
    }
}
