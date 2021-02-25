package com.chaochaogu.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author chaochao Gu
 * @date 2021/2/20
 */
//@Configuration
public class DatasourceConfig {

    @Bean(name = "db1")
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource businessDbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "db2")
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource newhomeDbDataSource() {
        return DataSourceBuilder.create().build();
    }
}
