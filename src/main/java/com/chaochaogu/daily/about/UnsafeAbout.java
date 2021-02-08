package com.chaochaogu.daily.about;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author chaochao Gu
 * @date 2021/1/6
 */
public class UnsafeAbout {

    public static void main(String[] args) {
        // 反射获取Unsafe
        Unsafe unsafe = reflectionGetUnsafe();
        System.out.println("111");
        Thread main = Thread.currentThread();
        // 异步线程5秒后唤醒主线程
        new Thread(() -> {
            try {
                SECONDS.sleep(5);
                unsafe.unpark(main);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        // 主线程阻塞
        unsafe.park(false, 0L);
        System.out.println("222");
        // 返回系统指针的大小，返回值为4（32位系统）或8（64位系统）
        System.out.println(unsafe.addressSize());
        // 返回分配的堆外内存基地址
        long base = unsafe.allocateMemory(300L);
        // 内存屏障
        unsafe.loadFence();
    }

    private static Unsafe reflectionGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
