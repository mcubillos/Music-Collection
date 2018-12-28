package com.example.music_collection.model;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int years;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}
