package com.chaochaogu;

/**
 * @author chaochao gu
 * @date 2019/12/7
 */
public class ThreadLocalAbout {
    public static void main(String[] args) {
        ThreadLocal<Integer> local = ThreadLocal.withInitial(() -> 3);
        local = new ThreadLocal<Integer>();
        local.set(1);
        System.out.println(local.get());
    }
}
