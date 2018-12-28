package com.example.music_collection.services;

import com.example.music_collection.model.Style;

import java.util.List;

public interface StyleService {
    List<Style> findAll();
    void saveAll(List<Style> styles);
    void save(Style style);
    Style findByName(String name);
}
