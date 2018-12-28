package com.example.music_collection.controller;

import com.example.music_collection.dto.ArtistsCreationDTO;
import com.example.music_collection.model.Artist;
import com.example.music_collection.services.ArtistService;
import com.example.music_collection.services.PeopleService;
import com.example.music_collection.services.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    @Autowired
    ArtistService artistService;

    @Autowired
    StyleService styleService;

    @Autowired
    PeopleService peopleService;

    @GetMapping("/all")
    public String showAllStyles(Model model) {
        model.addAttribute("artists", artistService.findAll());
        return "artist/artists";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        ArtistsCreationDTO artistsForm = new ArtistsCreationDTO();
        artistsForm.addArtists(new Artist());
        model.addAttribute("form", artistsForm);
        model.addAttribute("styles", styleService.findAll());
        model.addAttribute("members", peopleService.findAll());
        model.addAttribute("related", artistService.findAll());
        return "artist/createArtistForm";
    }

    @GetMapping(value = "/edit")
    public String showEditForm(Model model) {
        model.addAttribute("form", new ArtistsCreationDTO(artistService.findAll()));
        model.addAttribute("styles", styleService.findAll());
        model.addAttribute("members", peopleService.findAll());
        List<Artist> related = artistService.findAll();
        model.addAttribute("related", artistService.findAll());
        return "artist/editArtistForm";
    }

    @PostMapping(value = "/save")
    public String saveBooks(@ModelAttribute ArtistsCreationDTO form, Model model) {
        artistService.saveAll(form.getArtists());
        model.addAttribute("artists", artistService.findAll());

        return "redirect:/artists/all";
    }

    @GetMapping("/info/{name}")
    public String showStyleInfo(@PathVariable String name, Model model) {
        model.addAttribute("artist", artistService.findByName(name));
        return "artist/artistInfo";
    }
}