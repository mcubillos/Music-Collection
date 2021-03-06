package com.example.music_collection.repository;

import com.example.music_collection.model.Style;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StyleRepository extends JpaRepository<Style, Long> {
    Style findByName(String name);
}
