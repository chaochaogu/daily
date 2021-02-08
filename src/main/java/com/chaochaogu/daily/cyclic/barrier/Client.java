package com.chaochaogu.daily.cyclic.barrier;

import java.util.concurrent.CyclicBarrier;

/**
 * 场景类
 *
 * @author chaochao Gu
 * @date 2020/11/18
 */
public class Client {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5,
                () -> System.out.println("发令枪响，开跑！"));
        for (int i = 1; i <= 5; i++) {
            new MyThread(barrier, i).start();
        }
    }
}
