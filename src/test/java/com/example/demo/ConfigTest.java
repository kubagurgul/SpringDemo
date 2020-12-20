package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.beans.DependentBean;
import com.example.demo.beans.SimpleBean;
import com.example.demo.config.EnvironmentPropertyConfig;
import com.example.demo.config.SimpleConfig;
import com.example.demo.config.PropertySourceConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConfigTest {

    private Logger logger = LoggerFactory.getLogger(SimpleConfig.class);

    @Test
    void testSimpleConfiguration() {
        ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SimpleConfig.class);
        for (String beanName : ctx.getBeanDefinitionNames()) {
            logger.info("Bean " + beanName);
        }
    }


    @Test
    void testSimpleConfigurationBeansAreEqual() {
        ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SimpleConfig.class);

        SimpleBean simpleBeanOne = ctx.getBean(SimpleBean.class);
        SimpleBean simpleBeanTwo = ctx.getBean(SimpleBean.class);
        Assertions.assertEquals(simpleBeanTwo, simpleBeanOne);


    }

    @Test
    void testSimpleConfigurationDependentBean() {
        ApplicationContext ctx =
            new AnnotationConfigApplicationContext(SimpleConfig.class);

        SimpleConfig simpleConfig =
            ctx.getBean(SimpleConfig.class);
        assertNotNull(simpleConfig);


        SimpleBean simpleBean = simpleConfig.simpleBean();
        assertNotNull(simpleBean);

        DependentBean dependentBean = simpleConfig.dependentBean();
        assertNotNull(dependentBean);

    }

    @Test
    void testPropertySourceConfig() {
        ApplicationContext ctx =
            new AnnotationConfigApplicationContext(PropertySourceConfig.class);

        PropertySourceConfig propertySourceConfig =
            ctx.getBean(PropertySourceConfig.class);

        assertEquals(propertySourceConfig.getUrl(), "89.123.42.23/db");
        assertEquals(propertySourceConfig.getDriverClassName(), "testDbDriver");
    }

    @Test
    void testEnvironmentPropertyConfig() {
        ApplicationContext ctx =
            new AnnotationConfigApplicationContext(EnvironmentPropertyConfig.class);

        EnvironmentPropertyConfig environmentPropertyConfig =
            ctx.getBean(EnvironmentPropertyConfig.class);

        assertEquals(environmentPropertyConfig.getUrl(), "89.123.42.23/db");
        assertEquals(environmentPropertyConfig.getDriverClassName(), "testDbDriver");
    }
}
