package com.example.music_collection.services.impl;

import com.example.music_collection.model.Artist;
import com.example.music_collection.model.Style;
import com.example.music_collection.repository.ArtistRepository;
import com.example.music_collection.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {
    @Autowired
    ArtistRepository artistRepository;

    @Override
    public List<Artist> findAll() {
        return artistRepository.findAll();
    }

    @Override
    public void saveAll(List<Artist> artists) {
        artistRepository.saveAll(artists);
    }

    @Override
    public void save(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public Artist findByName(String name) {
        return artistRepository.findByName(name);
    }

    @Override
    public List<Artist> findByStyle(Style style) {
        return artistRepository.findArtistsByStylesContains(style);
    }

    @Override
    public void deleteAll() {
        artistRepository.deleteAll();
    }


}
