package com.chaochaogu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author chaochao Gu
 * @date 2020/8/25
 */
@EnableScheduling
@SpringBootApplication
@Import({DailyConfiguration.class})
public class DailyApplication {
    public static void main(String[] args) {
        SpringApplication.run(DailyApplication.class, args);
    }
}
