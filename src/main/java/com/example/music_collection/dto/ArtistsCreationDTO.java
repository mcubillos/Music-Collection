package com.example.music_collection.dto;

import com.example.music_collection.model.Artist;

import java.util.ArrayList;
import java.util.List;

public class ArtistsCreationDTO {
    private List<Artist> artists;

    public ArtistsCreationDTO(){
        this.artists =  new ArrayList<>();
    }

    public  ArtistsCreationDTO(List<Artist> artists){
        this.artists = artists;
    }
    public List<Artist> getArtists() {
        return artists;
    }

    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    public void addArtists(Artist artist){
        this.artists.add(artist);
    }
}
