package com.chaochaogu.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

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

    /**
     * 单独启动项目无问题但部署到tomcat或webLogic等服务器时，application配置如果不生效，可以采用此Bean配置
     *
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize(DataSize.ofMegabytes(5L));
        factory.setMaxRequestSize(DataSize.ofMegabytes(5L));
        return factory.createMultipartConfig();
    }
}
