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
//@Configuration
//@MapperScan(basePackages = {"com.chaochaogu.dao.db2"}, sqlSessionFactoryRef = "sqlSessionFactoryDb2")
public class Db2Config {

    @Autowired
    @Qualifier("db2")
    private DataSource dataSourceDb2;

    @Bean
    public SqlSessionFactory sqlSessionFactoryDb2() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceDb2);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db2/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateDb2() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryDb2());
    }

    /**
     * 如果需要对此数据源进行事务管理，那么需要配置该事务管理器
     *
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManagerDb2() {
        return new DataSourceTransactionManager(dataSourceDb2);
    }
}
