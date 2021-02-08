package com.chaochaogu.daily.fork.join;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * ForkJoinPool场景类
 *
 * @author chaochao Gu
 * @date 2020/9/23
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < 10000000; i++) {
            list.add(i + 1);
        }

        list.parallelStream().forEach(System.out::println);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(list, 0, list.size());
        Integer count = forkJoinPool.invoke(countTask);
        System.out.println("计算总和：" + count);
        forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
        forkJoinPool.shutdown();

        NoResultTask noResultTask = new NoResultTask(list, 0, list.size());
        forkJoinPool.invoke(noResultTask);
        forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
    }
}
