package com.chaochaogu;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chaochao Gu
 * @date 2020/8/10
 */
public class BigDecimalAbout {

    public static void main(String[] args) {
        System.out.println(BigDecimal.valueOf(5842).
                divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP).
                multiply(BigDecimal.valueOf(100)).
                longValue());
        System.out.println(BigDecimal.valueOf(5863).
                divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP).
                multiply(BigDecimal.valueOf(100)).
                longValue());
    }
}
