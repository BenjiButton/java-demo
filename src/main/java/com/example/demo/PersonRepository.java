package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Collection;
public interface PersonRepository extends JpaRepository<Person, Long> {
    Collection<Person> findByName(String name);
}

