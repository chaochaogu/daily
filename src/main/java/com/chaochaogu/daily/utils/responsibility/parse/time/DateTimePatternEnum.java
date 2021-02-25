package com.chaochaogu.daily.utils.responsibility.parse.time;

/**
 * 时间格式枚举
 *
 * @author chaochao Gu
 * @date 2021/2/25
 */
public enum DateTimePatternEnum {

    /**
     * 普通时间格式
     */
    NORMAL("yyyy-MM-dd HH:ss:mm"),
    UTC("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    private String pattern;

    DateTimePatternEnum(String pattern) {
        this.pattern = pattern;
    }

    public String pattern() {
        return this.pattern;
    }
}
