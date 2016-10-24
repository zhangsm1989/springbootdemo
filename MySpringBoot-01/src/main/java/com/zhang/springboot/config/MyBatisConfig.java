package com.zhang.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.sql.SQLException;

/**
* <p>Discription:[MyBatis基础配置]</p>
* Created on 2016/10/7 14:14
* @param
* @return
* @author:[张山明]
*/
@Configuration
@EnableTransactionManagement //开启事务
@MapperScan("com.zhang.springboot.dao") //注：@MapperScan(“com.zhang.springboot.dao”) 表示Mybatis的映射路径（package路径）
public class MyBatisConfig implements TransactionManagementConfigurer {
    private static Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);
//    private static final String ALIASE_SPACKAGE = "com.zhang.springboot.dao";
    private static final String MYBATIS_CLASSPATH = "classpath:/mybatis/*.xml";
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource());
        //Spring提供的一个强大resource loader，PathMatchingResourcePatternResolver能够处理jar包里的资源
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            sqlSessionFactoryBean.setMapperLocations(resolver.getResources(MYBATIS_CLASSPATH));
            return sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(druidDataSource());
    }
    @Bean
    @ConfigurationProperties(prefix = "spring.druid.datasource")
    public DruidDataSource druidDataSource() {
        logger.info("注入druid！！！");
        DruidDataSource druidDataSource=null;
        try {
            druidDataSource = new DruidDataSource();
            druidDataSource.setFilters("stat, wall");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return druidDataSource;
    }
    /*
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource  dataSource() {
        logger.debug("Configuring Datasource");
        DataSource dataSource =new DataSource();
        return dataSource;
    }
    */
}