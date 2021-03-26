package com.chaochaogu.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author chaochao Gu
 * @date 2021/2/3
 */
@Component
public class Job1 {

//    @Scheduled(cron = "0/5 * * * * ?")
    public void doJob1() {
        System.out.println(Thread.currentThread().getName() + " do job1 ...");
    }
}
