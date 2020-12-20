package com.example.demo.aop;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.aop.PersonRepo;

@Component
public class StartupBean {

    @Autowired
    public PersonRepo personRepo;

    @PostConstruct
    public void startup() {
        personRepo.findAll();
    }
}
