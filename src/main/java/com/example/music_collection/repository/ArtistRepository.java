package com.example.music_collection.repository;

import com.example.music_collection.model.Artist;
import com.example.music_collection.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    Artist findByName(String name);
    List<Artist> findArtistsByStylesContains(Style style);
}
