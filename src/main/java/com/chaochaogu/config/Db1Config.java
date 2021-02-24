package com.chaochaogu.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @author chaochao Gu
 * @date 2021/2/20
 */
@Configuration
@MapperScan(basePackages = {"com.chaochaogu.dao.db1"}, sqlSessionFactoryRef = "sqlSessionFactoryDb1")
public class Db1Config {

    @Autowired
    @Qualifier("db1")
    private DataSource dataSourceDb1;

    @Bean
    public SqlSessionFactory sqlSessionFactoryDb1() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceDb1);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db1/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateDb1() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryDb1());
    }

    /**
     * 如果需要对此数据源进行事务管理，那么需要配置该事务管理器
     *
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManagerDb1() {
        return new DataSourceTransactionManager(dataSourceDb1);
    }
}
