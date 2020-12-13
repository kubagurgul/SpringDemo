package com.example.demo.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartupBean {

    @Autowired
    public PersonRepo personRepo;

    @PostConstruct
    public void startup() {
        personRepo.findAll();
    }
}
