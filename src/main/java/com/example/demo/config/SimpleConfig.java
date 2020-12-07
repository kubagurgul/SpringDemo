package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.beans.DependentBean;
import com.example.demo.beans.DependentBeanImpl;
import com.example.demo.beans.SimpleBean;
import com.example.demo.beans.SimpleBeanImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class SimpleConfig {

    private Logger logger = LoggerFactory.getLogger(SimpleConfig.class);

    @Bean
    public SimpleBean simpleBean() {
        logger.info("---> Creating 'simpleBean' ");
        return new SimpleBeanImpl();
    }

    @Bean
    public DependentBean dependentBean() {
        return new DependentBeanImpl(simpleBean());
    }
}
