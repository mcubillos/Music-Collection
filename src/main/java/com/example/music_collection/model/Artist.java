package com.example.music_collection.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int years;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Style.class)
    private Set<Style> styles;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = Person.class)
    private Set<Person> members;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Artist.class)
    private Set<Artist> related;

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

    public Set<Style> getStyles() {
        return styles;
    }

    public void setStyles(Set<Style> styles) {
        this.styles = styles;
    }

    public Set<Person> getMembers() {
        return members;
    }

    public void setMembers(Set<Person> members) {
        this.members = members;
    }

    public Set<Artist> getRelated() {
        return related;
    }

    public void setRelated(Set<Artist> related) {
        this.related = related;
    }
}
