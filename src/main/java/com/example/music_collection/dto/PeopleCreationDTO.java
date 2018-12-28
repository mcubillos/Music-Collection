package com.example.music_collection.dto;

import com.example.music_collection.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PeopleCreationDTO {
    private List<Person> people;

    public PeopleCreationDTO(){
        this.people =  new ArrayList<>();
    }

    public  PeopleCreationDTO(List<Person> people){
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public void addPerson(Person person){
        this.people.add(person);
    }
}
