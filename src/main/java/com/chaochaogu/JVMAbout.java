package com.chaochaogu;


import java.lang.ref.SoftReference;
import java.util.Date;

/**
 * @author chaochao Gu
 * @date 2019/12/6
 */
public class JVMAbout {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
            }
        }, "testBusyThread").start();
        System.out.println(Date.class.getClassLoader());
        System.out.println(JVMAbout.class.getClassLoader().getParent());
        SoftReference<JVMAbout> softReference;
    }
}
