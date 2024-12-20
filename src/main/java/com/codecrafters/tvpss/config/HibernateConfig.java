package com.codecrafters.tvpss.config;

import com.codecrafters.tvpss.model.ResourceRequestModel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@org.springframework.context.annotation.Configuration
public class HibernateConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Bean
    public SessionFactory sessionFactory() {
        Configuration configuration = new Configuration();

        Properties settings = new Properties();
        settings.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        settings.put("hibernate.connection.url", dbUrl);
        settings.put("hibernate.connection.username", dbUsername);
        settings.put("hibernate.connection.password", dbPassword);
        settings.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        settings.put("hibernate.show_sql", "true");
        settings.put("hibernate.current_session_context_class", "thread");
        settings.put("hibernate.hbm2ddl.auto", "update");
        settings.put("hibernate.physical_naming_strategy", "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");

        configuration.setProperties(settings);
        configuration.addAnnotatedClass(ResourceRequestModel.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }
} 