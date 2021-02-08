package com.chaochaogu.daily.cyclic.barrier;

import lombok.SneakyThrows;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * 模拟短跑运动员
 *
 * @author chaochao Gu
 * @date 2020/11/18
 */
public class MyThread extends Thread {
    private final CyclicBarrier barrier;
    private int num;
    private final Random random = new Random();

    public MyThread(CyclicBarrier barrier, int num) {
        this.barrier = barrier;
        this.num = num;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println("运动员" + num + "号开始准备");
        int prepare = random.nextInt(10) + 1;
        System.out.println("运动员" + num + "号需要准备" + prepare + "秒");
        SECONDS.sleep(prepare);
        System.out.println("运动员" + num + "号准备完毕，等待发令枪");
        barrier.await(5, SECONDS);
    }
}
