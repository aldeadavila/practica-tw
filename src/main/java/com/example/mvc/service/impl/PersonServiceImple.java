package com.example.mvc.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.Person;
import com.example.mvc.repository.PersonRepository;
import com.example.mvc.service.PersonService;

@Service
public class PersonServiceImple implements PersonService {
    @Inject
    protected PersonRepository personRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Person> findAll(int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC,
                "id"));
        Page<Person> persons = personRepository.findAll(pageable);
        return persons;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Person> findByNameLike(String name, int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(Direction.DESC,
                "id"));
        Page<Person> persons = personRepository.findByNameLike(name, pageable);
        return persons;
    }

    @Override
    @Transactional(readOnly = true)
    public Person findPersonById(Integer id) {
        Person person = personRepository.findOne(id);
        return person;
    }

    @Override
    @Transactional
    public void insert(Person person) {
        personRepository.save(person);
    }

    @Override
    @Transactional
    public void update(Person person) {
        personRepository.save(person);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        personRepository.delete(id);
    }

}