package com.chaochaogu.daily.thread;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 简易线程监控类
 *
 * @author chaochao Gu
 * @date 2021/1/15
 */
public class ThreadPoolMonitor {
    private static Map<String, ExecutorService> executorServices = Maps.newHashMap();

    public static void putToMonitor(ExecutorService executorService, String threadPoolName) {
        executorServices.put(threadPoolName, executorService);
    }

    public static String getThreadPooolInfo() {
        StringBuilder result = new StringBuilder("THREAD-POOL-MONITOR \n");
        executorServices.forEach((name, es) -> {
            ThreadPoolExecutor tpe = (ThreadPoolExecutor) es;
            result.append(name);
            result.append(":");
            result.append("[queue size:" + tpe.getQueue().size());
            result.append("; ");
            result.append("queue remaiming capacity:" + tpe.getQueue().remainingCapacity());
            result.append("; ");
            result.append("task count:" + tpe.getTaskCount());
            result.append("; ");
            result.append("completed task count:" + tpe.getCompletedTaskCount());
            result.append("]\n");
        });
        return result.toString();
    }
}
