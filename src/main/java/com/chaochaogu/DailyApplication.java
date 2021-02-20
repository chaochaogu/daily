package com.chaochaogu;

import com.chaochaogu.config.DailyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author chaochao Gu
 * @date 2020/8/25
 */
@EnableScheduling
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Import({DailyConfiguration.class})
public class DailyApplication {
    public static void main(String[] args) {
        SpringApplication.run(DailyApplication.class, args);
    }
}
