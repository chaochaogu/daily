package com.chaochaogu.config4jta;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author chaochao gu
 * @date 2021/2/25
 */
@Configuration
@MapperScan(basePackages = {"com.chaochaogu.dao.db2"}, sqlSessionFactoryRef = "sqlSessionFactoryDb2")
public class Db2Datasource4jtaConfig {

    @Value("${spring.datasource.db2.jdbc-url}")
    private String url;
    @Value("${spring.datasource.db2.username}")
    private String username;
    @Value("${spring.datasource.db2.password}")
    private String password;

    /**
     * 配置一个数据源的bean
     *
     * @return
     */
    @Bean(name = "db2DataSource")
    public DataSource db2DataSource() {
        // 创建一个数据源
        MysqlXADataSource xaDataSource = new MysqlXADataSource();
        xaDataSource.setURL(url);
        xaDataSource.setUser(username);
        xaDataSource.setPassword(password);

        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(xaDataSource);
        atomikosDataSourceBean.setUniqueResourceName("db2DataSource");
        atomikosDataSourceBean.setMaxPoolSize(30);
        atomikosDataSourceBean.setMinPoolSize(5);
        return atomikosDataSourceBean;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactoryDb2(@Qualifier("db1DataSource") DataSource db2DataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(db2DataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/db1/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateDb2(@Qualifier("sqlSessionFactoryDb2") SqlSessionFactory sqlSessionFactoryDb2) {
        return new SqlSessionTemplate(sqlSessionFactoryDb2);
    }
}
