package com.chaochaogu.daily.fork.join;

import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * 计算列表中数字总和，任务分解
 *
 * @author chaochao Gu
 * @date 2020/9/23
 */
public class DemoTask extends RecursiveTask<Integer> {
    private List<Integer> list;
    private int start;
    private int end;
    public static final int THRESHOLD = 100;

    public DemoTask(List<Integer> list, int start, int end) {
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
            int middle = (start + end) / 2;
            DemoTask left = new DemoTask(list, start, middle);
            DemoTask right = new DemoTask(list, middle, end);
            left.fork();
            right.fork();
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
