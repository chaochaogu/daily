package com.chaochaogu.daily.fork.join;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * @author chaochao Gu
 * @date 2020/9/23
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 10000; i++) {
            list.add(i + 1);
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        DemoTask demoTask = new DemoTask(list, 0, list.size());
        Integer count = forkJoinPool.invoke(demoTask);
        System.out.println("计算总和："+ count);
        forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
    }
}
