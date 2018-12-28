package com.example.music_collection.services.impl;

import com.example.music_collection.model.Person;
import com.example.music_collection.repository.PersonRepository;
import com.example.music_collection.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void saveAll(List<Person> people) {
        personRepository.saveAll(people);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public Person findByName(String name) {
        return personRepository.findByName(name);
    }
}
