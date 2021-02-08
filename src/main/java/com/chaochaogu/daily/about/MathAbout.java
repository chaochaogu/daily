package com.chaochaogu.daily.about;

/**
 * @author chaochao Gu
 * @date 2020/7/3
 */
public class MathAbout {
    public static void main(String[] args) {
        System.out.println(Math.round(10 / 4));
        // 短信验证码
        System.out.println(String.valueOf((int) ((Math.random() * 9 + 1) * 100000)));
    }
}
