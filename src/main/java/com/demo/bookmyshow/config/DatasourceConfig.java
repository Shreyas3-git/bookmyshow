//package com.demo.bookmyshow.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class DatasourceConfig
//{
//    @Primary
//    @Bean(name = "db1DataSource")
//    @ConfigurationProperties(prefix = "spring.db1.datasource")
//    public DataSource db1DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "db2DataSource")
//    @ConfigurationProperties(prefix = "spring.db2.datasource")
//    public DataSource db2DataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//}
