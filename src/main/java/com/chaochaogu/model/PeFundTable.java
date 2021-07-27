package com.chaochaogu.model;

import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author chaochao Gu
 * @date 2021/7/23
 */
@Data
public class PeFundTable {

    private String code;

    private String status;

//    private BigInteger minDemon;
    private BigDecimal minDemon;
}
