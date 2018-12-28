package com.example.music_collection.services;

import com.example.music_collection.model.Person;

import java.util.List;

public interface PeopleService {
    List<Person> findAll();
    void saveAll(List<Person> people);
    void save(Person person);
    Person findByName(String name);
}
