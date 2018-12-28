package com.example.music_collection.services.impl;

import com.example.music_collection.model.Style;
import com.example.music_collection.repository.StyleRepository;
import com.example.music_collection.services.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyleServiceImpl implements StyleService {
    @Autowired
    StyleRepository styleRepository;

    @Override
    public List<Style> findAll() {
        return styleRepository.findAll();
    }

    @Override
    public void saveAll(List<Style> styles) {
        styleRepository.saveAll(styles);
    }

    @Override
    public void save(Style style){
        styleRepository.save(style);
    }

    @Override
    public Style findByName(String name) {
        return styleRepository.findByName(name);
    }
}
