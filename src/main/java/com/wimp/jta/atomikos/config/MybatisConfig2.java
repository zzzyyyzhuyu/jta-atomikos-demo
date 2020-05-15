package com.wimp.jta.atomikos.config;

import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author zy
 * @date 2020/5/14
 * <p>
 *  
 */
@Configuration
@MapperScan(basePackages = "com.wimp.jta.atomikos.mapper.test02", sqlSessionTemplateRef = "testSqlSessionTemplate2")
public class MybatisConfig2 {
    @Bean(name = "testDataSource2")
    public DataSource testDataSource(DBConfig2 testConfig) throws SQLException{
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(testConfig.getUrl());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);
        mysqlXADataSource.setPassword(testConfig.getPassword());
        mysqlXADataSource.setUser(testConfig.getUsername());

        AtomikosDataSourceBean xaDataSource = new AtomikosDataSourceBean();
        xaDataSource.setXaDataSource(mysqlXADataSource);
        xaDataSource.setUniqueResourceName("testDataSource2");

        xaDataSource.setMinPoolSize(testConfig.getMinPoolSize());
        xaDataSource.setMaxPoolSize(testConfig.getMaxPoolSize());
        xaDataSource.setMaxLifetime(testConfig.getMaxLifetime());
        xaDataSource.setBorrowConnectionTimeout(testConfig.getBorrowConnectionTimeout());
        xaDataSource.setLoginTimeout(testConfig.getLoginTimeout());
        xaDataSource.setMaintenanceInterval(testConfig.getMaintenanceInterval());
        xaDataSource.setMaxIdleTime(testConfig.getMaxIdleTime());
        xaDataSource.setTestQuery(testConfig.getTestQuery());

        return xaDataSource;
    }

    @Bean(name = "testSqlSessionFactory2")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource2") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }


    @Bean(name = "testSqlSessionTemplate2")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("testSqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
