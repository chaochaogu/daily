package com.chaochaogu;


/**
 * @author chaochao Gu
 * @date 2019/12/6
 */
public class JVMAbout {
    public static void main(String[] args) {
        new Thread(() -> {
            while (true){}
        }, "testBusyThread").start();
    }
}
