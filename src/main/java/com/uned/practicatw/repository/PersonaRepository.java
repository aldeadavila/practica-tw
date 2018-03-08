package com.uned.practicatw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uned.practicatw.entity.Persona;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
   Page<Persona> findByNombreLike(String name, Pageable pageable);
}
