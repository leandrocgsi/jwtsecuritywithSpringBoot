package com.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
