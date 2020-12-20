package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:db/test-ds.properties")
public class EnvironmentPropertyConfig {
    @Autowired
    Environment environment;

    public String getDriverClassName() {
        return environment.getProperty("db.driverClassName");
    }

    public String getUrl() {
        return environment.getProperty("db.url");
    }
}
