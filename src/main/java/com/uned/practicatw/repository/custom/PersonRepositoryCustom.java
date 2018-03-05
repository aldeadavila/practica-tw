package com.uned.practicatw.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.uned.practicatw.entity.Person;

public interface PersonRepositoryCustom {
    Page<Person> findByNameLike(String name, Pageable pageable);
}
