package com.chaochaogu.daily.fork.join;

import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * 计算列表中数字总和，任务分解
 *
 * @author chaochao Gu
 * @date 2020/9/23
 */
public class CountTask extends RecursiveTask<Integer> {
    private List<Integer> list;
    private int start;
    private int end;
    public static final int THRESHOLD = 100;

    public CountTask(List<Integer> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start < THRESHOLD) {
            return count(list);
        } else {
            System.out.println("任务分解");
            // 如果任务大于阈值，就分裂成两个子任务计算
            int middle = (start + end) / 2;
            CountTask left = new CountTask(list, start, middle);
            CountTask right = new CountTask(list, middle, end);
            // 执行子任务
            left.fork();
            right.fork();
            // 等待子任务执行完，并得到结果
            return left.join() + right.join();
        }
    }

    private Integer count(List<Integer> list) {
        int count = 0;
        for (Integer i : list) {
            count += i;
        }
        return count;
    }
}
