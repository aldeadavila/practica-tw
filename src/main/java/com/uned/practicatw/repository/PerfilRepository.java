package com.uned.practicatw.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.uned.practicatw.entity.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
	//Page<Perfil> findByNameLike(String name, Pageable pageable);
}
