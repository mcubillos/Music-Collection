package com.example.music_collection.services.impl;

import com.example.music_collection.model.Artist;
import com.example.music_collection.model.Style;
import com.example.music_collection.services.ArtistService;
import com.example.music_collection.services.StyleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class ArtistServiceImplTest {

    @Autowired
    ArtistService artistService;

    @Autowired
    StyleService styleService;

    @Test
    public void findAll() {
        List<Artist> artists = new ArrayList<>();
        for(int i= 0; i < 5; i++){
            artists.add(new Artist());
        }
        artistService.saveAll(artists);

        artists = artistService.findAll();

        Assert.assertEquals(5, artists.size());
        artistService.deleteAll();
    }

    @Test
    public void saveAll() {
        List<Artist> artists = new ArrayList<>();
        for(int i= 0; i < 5; i++){
            artists.add(new Artist());
        }
        artistService.saveAll(artists);

        List<Artist> saveArtists = artistService.findAll();
        Assert.assertEquals(5, saveArtists.size());
        artistService.deleteAll();
    }

    @Test
    public void save() {
        artistService.save(new Artist());
        Assert.assertEquals(1, artistService.findAll().size());
        artistService.deleteAll();
    }

    @Test
    public void findByName() {
        Artist artist = new Artist();
        artist.setName("Prueba");
        artistService.save(artist);

        Assert.assertEquals(artist.getId(), artistService.findByName("Prueba").getId());
        artistService.deleteAll();
    }

    @Test
    public void findByStyle() {
        Artist artist = new Artist();
        artist.setName("Prueba");
        Set<Style> styles = new HashSet<>();
        Style style = new Style();
        style.setName("Prueba");
        styleService.save(style);
        styles.add(style);
        artist.setStyles(styles);
        artistService.save(artist);

        Assert.assertEquals(1, artistService.findByStyle(style).size());
        artistService.deleteAll();
    }
}