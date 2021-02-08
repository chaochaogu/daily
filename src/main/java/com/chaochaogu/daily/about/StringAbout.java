package com.chaochaogu.daily.about;

/**
 * @author chaochao Gu
 * @date 2019/12/13
 */
public class StringAbout {
    public static void main(String[] args) {

        String s = "1";
        String s1 = new String("1");
        s1 = s1.intern();
        System.out.println(s == s1);

        String s4 = new String("1");
        String s5 = new String("2");
        String s6 = s4 + s5;
        String str = "12";
        s6.intern();
        String s7 = "12";
        System.out.println(s6 == s7);

        String s2 = new String("2");
        String intern1 = s2.intern();
        String s3 = "2";
        System.out.println(intern1 == s3);

        Integer a = 250;
        Integer b = 250;
        System.out.println(a == b);
    }
}
