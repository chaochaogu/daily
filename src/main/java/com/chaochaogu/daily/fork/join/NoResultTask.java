package com.chaochaogu.daily.fork.join;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * 无返回值任务Demo
 *
 * @author chaochao Gu
 * @date 2020/11/16
 */
public class NoResultTask extends RecursiveAction {
    private List<Integer> list;
    private int start;
    private int end;
    static final int THRESHOLD = 100;

    public NoResultTask(List<Integer> list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if ((end - start) < THRESHOLD) {
            doBusiness(list);
        } else {
            System.out.println("无结果任务分解");
            int middle = (start + end) / 2;
            NoResultTask left = new NoResultTask(list, start, middle);
            NoResultTask right = new NoResultTask(list, middle, end);
            left.fork();
            right.fork();
        }
    }

    private void doBusiness(List<Integer> list) {
        for (Integer value : list) {
            System.out.println(Thread.currentThread().getName() + "###" + value);
        }
    }
}
