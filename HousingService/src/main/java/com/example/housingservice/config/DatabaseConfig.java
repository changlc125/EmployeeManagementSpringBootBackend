package com.example.housingservice.config;

import com.example.housingservice.domain.AwsSecrets;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


import javax.sql.DataSource;
import java.security.InvalidParameterException;
import java.util.Base64;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.yml")
@ComponentScan(basePackages = {"com.example.housingservice"}) // Make sure this is correct
public class DatabaseConfig {

    @Value("${spring.jpa.show-sql}")
    private String showsql;

    @Value("${spring.jpa.username}")
    private String username;

    @Value("${spring.jpa.password}")
    private String password;
    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;
    @Value("${spring.jpa.properties.hibernate.connection.driver_class}")
    private String driver;

    @Bean
    protected LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(
                "com.example.housingservice.domain");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                "hibernate.show_sql", showsql);
        hibernateProperties.setProperty(
                "hibernate.dialect", dialect);

        return hibernateProperties;
    }

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/HousingDB");
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }


}
