package com.example.music_collection.repository;

import com.example.music_collection.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByName(String name);
}
