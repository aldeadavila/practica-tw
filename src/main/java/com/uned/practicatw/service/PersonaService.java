package com.uned.practicatw.service;

import org.springframework.data.domain.Page;

import com.uned.practicatw.entity.Persona;

public interface PersonaService {
    Page<Persona> findAll(int page, int size);

    Page<Persona> findByNombreLike(String name, int page, int size);

    Persona findById(Integer id);

    Persona insert(Persona person);

    Persona update(Persona person);

    void deleteById(Integer id);

}
