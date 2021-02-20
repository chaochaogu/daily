package com.chaochaogu.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    private Long id;

    private Long pid;

    private String name;

    private Integer level;

    private String pinyin;

    private String englishName;

    private String unicodeCode;

    private String orderNo;

    private static final long serialVersionUID = 1L;
}