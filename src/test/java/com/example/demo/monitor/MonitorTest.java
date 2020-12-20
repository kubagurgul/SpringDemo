package com.example.demo.monitor;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.aop.PersonRepo;
import com.example.demo.aop.MonitorConfig;
import com.example.demo.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MonitorConfig.class})
public class MonitorTest {
    @Autowired
    PersonRepo personRepo;

    @Test
    public void testFindAll() {
        Set<Person> all = personRepo.findAll();
        assertEquals(Collections.emptySet(), all);
    }
}
