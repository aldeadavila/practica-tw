package com.uned.practicatw.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.uned.practicatw.entity.Persona;

public interface PersonaRepositoryCustom {
    Page<Persona> findByNameLike(String name, Pageable pageable);
}
