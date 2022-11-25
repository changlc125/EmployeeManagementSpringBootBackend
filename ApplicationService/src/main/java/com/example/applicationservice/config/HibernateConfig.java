package com.example.applicationservice.config;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = {"com.example.applicationservice"}) // Make sure this is correct
@EnableTransactionManagement
public class HibernateConfig {

    @Value("${spring.jpa.show-sql}")
    private String showsql;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Value("${spring.jpa.properties.hibernate.connection.driver_class}")
    private String driver;

    @Value("${spring.jpa.username}")
    private String username;

    @Value("${spring.jpa.password}")
    private String password;

    @Bean
    protected LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                "com.example.applicationservice.domain");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/ApplicationDB");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

//    @Bean
//    public PlatformTransactionManager hibernateTransactionManager() {
//        HibernateTransactionManager transactionManager
//                = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory().getObject());
//        return transactionManager;
//    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.show_sql", showsql);
        hibernateProperties.setProperty(
                "hibernate.dialect", dialect);

        return hibernateProperties;
    }


}
