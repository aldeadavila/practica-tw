package com.uned.practicatw.service.impl;

import javax.inject.Inject;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uned.practicatw.entity.Persona;
import com.uned.practicatw.repository.PersonaRepository;
import com.uned.practicatw.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Inject
    protected PersonaRepository personRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Persona> findAll(int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(
                Direction.DESC, "id"));
        Page<Persona> persons = personRepository.findAll(pageable);
        return persons;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Persona> findByNombreLike(String name, int page, int size) {
        Pageable pageable = new PageRequest(page, size, new Sort(
                Direction.DESC, "id"));
        String q = "%" + name + "%";
        Page<Persona> persons = personRepository.findByNombreLike(q, pageable);
        return persons;
    }

    @Override
    @Transactional(readOnly = true)
    public Persona findById(Integer id) {
        Persona person = personRepository.findOne(id);
        return person;
    }

    @Override
    @Transactional
    public Persona insert(Persona person) {
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public Persona update(Persona person) {
        return personRepository.save(person);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        personRepository.delete(id);
    }

}
