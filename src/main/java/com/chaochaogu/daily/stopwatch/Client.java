package com.chaochaogu.daily.stopwatch;


import org.springframework.util.StopWatch;

/**
 * spring计时器
 *
 * @author chaochao Gu
 * @date 2020/9/28
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch("新人拼团订单StopWatch");

        stopWatch.start("调用风控系统接口");
        // 调用风控系统接口
        Thread.sleep(100);
        stopWatch.stop();

        stopWatch.start("获取拼团活动信息");
        // 获取拼团活动信息
        Thread.sleep(200);
        stopWatch.stop();

        stopWatch.start("获取用户基本信息");
        // 获取用户基本信息，http调用用户服务
        Thread.sleep(300);
        stopWatch.stop();

        stopWatch.start("判断是否是新用户");
        // 判断是否是新用户，查询订单数据库
        Thread.sleep(400);
        stopWatch.stop();

        stopWatch.start("生成订单并入库");
        Thread.sleep(500);
        // 生成订单并入库
        stopWatch.stop();

        System.out.println(stopWatch.getId() + " 任务运行总耗时：" + stopWatch.getTotalTimeSeconds() + "秒");
        for (StopWatch.TaskInfo taskInfo : stopWatch.getTaskInfo()) {
            System.out.println(taskInfo.getTaskName() + " 运行秒数：" + taskInfo.getTimeSeconds());
        }
        System.out.println("\n");
        System.out.println(stopWatch.prettyPrint());
    }
}
