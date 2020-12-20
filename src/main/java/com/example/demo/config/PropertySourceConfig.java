package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/db/test-ds.properties")
public class PropertySourceConfig {
    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }
}
