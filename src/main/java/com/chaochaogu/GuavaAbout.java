package com.chaochaogu;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author chaochao Gu
 * @date 2019/12/5
 */
public class GuavaAbout {
    public static void main(String[] args) {
        System.out.println(Maps.newHashMap().isEmpty());
        Map<Long/*shipmentId*/, Map<Long/*skuOrderId*/, Integer/*refundNum*/>> shipmentRefundMap = Maps.newHashMap();
        System.out.println(shipmentRefundMap.size());
    }
}
