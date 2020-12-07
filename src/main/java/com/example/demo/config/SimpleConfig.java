package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {
    @Bean
    public SimpleBean simpleBean() {
        return new SimpleBeanImpl();
    }
}
