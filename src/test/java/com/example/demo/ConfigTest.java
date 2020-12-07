package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.demo.beans.DependentBean;
import com.example.demo.beans.SimpleBean;
import com.example.demo.config.SimpleConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}
