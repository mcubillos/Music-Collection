package com.example.music_collection.dto;

import com.example.music_collection.model.Style;

import java.util.ArrayList;
import java.util.List;

public class StylesCreationDTO {
    private List<Style> styles;

    public StylesCreationDTO(){
        this.styles =  new ArrayList<>();
    }

    public  StylesCreationDTO(List<Style> styles){
        this.styles = styles;
    }
    public List<Style> getStyles() {
        return styles;
    }

    public void setStyles(List<Style> styles) {
        this.styles = styles;
    }

    public void addStyle(Style style){
        this.styles.add(style);
    }
}
