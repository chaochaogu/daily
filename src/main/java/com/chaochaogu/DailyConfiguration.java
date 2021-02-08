package com.chaochaogu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @author chaochao Gu
 * @date 2021/2/2
 */
@Configuration
public class DailyConfiguration {

    /**
     * 配置spring schedule的线程池
     *
     * @return
     */
    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("daily-scheduler");
        scheduler.setPoolSize(10);
        return scheduler;
    }
}
