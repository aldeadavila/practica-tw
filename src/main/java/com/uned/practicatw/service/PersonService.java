package com.uned.practicatw.service;

import org.springframework.data.domain.Page;

import com.uned.practicatw.entity.Person;

public interface PersonService {
    Page<Person> findAll(int page, int size);

    Page<Person> findByNameLike(String name, int page, int size);

    Person findById(Integer id);

    Person insert(Person person);

    Person update(Person person);

    void deleteById(Integer id);

}
