package com.chaochaogu.daily;

import java.util.concurrent.Semaphore;

/**
 * @author chaochao gu
 * @date 2019/12/29
 */
public class SemaphoreAbout {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0);
        semaphore.release();
        System.out.println(semaphore.availablePermits());
    }
}
