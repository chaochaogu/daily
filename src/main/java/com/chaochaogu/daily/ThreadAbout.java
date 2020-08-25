package com.chaochaogu.daily;

import java.util.concurrent.Executor;

/**
 * @author chaochao Gu
 * @date 2019/12/25
 */
public class ThreadAbout {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("run...");
        Executor executor = Runnable::run;
        Executor executor1 = (t) -> new Thread(t).start();
        executor.execute(task);
        executor1.execute(task);
    }
}
