package com.example.music_collection.controller;

import com.example.music_collection.dto.StylesCreationDTO;
import com.example.music_collection.model.Style;
import com.example.music_collection.services.ArtistService;
import com.example.music_collection.services.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/styles")
public class StyleController {
    @Autowired
    StyleService styleService;

    @Autowired
    ArtistService artistService;

    @GetMapping("/all")
    public String showAllStyles(Model model){
        model.addAttribute("styles", styleService.findAll());
        return "style/styles";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        StylesCreationDTO stylesForm = new StylesCreationDTO();
        stylesForm.addStyle(new Style());
        model.addAttribute("form", stylesForm);

        return "style/createStyleForm";
    }

    @GetMapping(value = "/edit")
    public String showEditForm(Model model) {
        model.addAttribute("form", new StylesCreationDTO(styleService.findAll()));

        return "style/editStylesForm";
    }

    @PostMapping(value = "/save")
    public String saveBooks(@ModelAttribute StylesCreationDTO form, Model model) {
        styleService.saveAll(form.getStyles());
        model.addAttribute("styles", styleService.findAll());

        return "redirect:/styles/all";
    }

    @GetMapping("/info/{name}")
    public String showStyleInfo(@PathVariable String name, Model model){
        Style style = styleService.findByName(name);
        model.addAttribute("style", style);
        model.addAttribute("artists", artistService.findByStyle(style));
        return "style/styleInfo";
    }
}
