package com.example.music_collection.services;

import com.example.music_collection.model.Artist;
import com.example.music_collection.model.Style;

import java.util.List;

public interface ArtistService {
    List<Artist> findAll();
    void saveAll(List<Artist> styles);
    void save(Artist style);
    Artist findByName(String name);
    List<Artist> findByStyle(Style style);
    void deleteAll();
}