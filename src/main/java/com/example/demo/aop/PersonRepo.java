package com.example.demo.aop;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
public class PersonRepo {

    public Optional<Person> findById(Long id) {
        return Optional.empty();
    }

    public Optional<Person> findByUsername(String username) {
        return Optional.empty();
    }

    public Optional<Person> findByCompleteName(String firstName, String lastName) {
        return Optional.empty();
    }

    public void save(Person person) {

    }

    public Set<Person> findAll() {
        return new HashSet<>();
    }
}
