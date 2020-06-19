package com.chaochaogu;

import java.util.Arrays;

/**
 * @author chaochao Gu
 * @date 2020/6/19
 */
public class SystemAbout {

    public static void main(String[] args) {
        String[] strArr = {"富强", "民主", "爱国", "文明", "和谐", "友善", "敬业", "诚信"};
        String[] copy = new String[8];
        System.arraycopy(strArr, 0, copy, 2, 6);
        System.out.println(Arrays.toString(copy));
        System.gc();
    }

}
