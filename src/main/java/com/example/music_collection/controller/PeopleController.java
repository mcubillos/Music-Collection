package com.example.music_collection.controller;

import com.example.music_collection.dto.PeopleCreationDTO;
import com.example.music_collection.model.Person;
import com.example.music_collection.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @GetMapping("/all")
    public String showAllPeople(Model model) {
        model.addAttribute("people", peopleService.findAll());
        return "person/people";
    }

    @GetMapping(value = "/create")
    public String showCreateForm(Model model) {
        PeopleCreationDTO peopleForm = new PeopleCreationDTO();
        peopleForm.addPerson(new Person());
        model.addAttribute("form", peopleForm);

        return "person/createPersonForm";
    }

    @GetMapping(value = "/edit")
    public String showEditForm(Model model) {
        model.addAttribute("form", new PeopleCreationDTO(peopleService.findAll()));

        return "person/editPersonForm";
    }

    @PostMapping(value = "/save")
    public String savePeople(@ModelAttribute PeopleCreationDTO form, Model model) {
        peopleService.saveAll(form.getPeople());
        model.addAttribute("people", peopleService.findAll());

        return "redirect:/people/all";
    }

    @GetMapping("/info/{name}")
    public String showPersonInfo(@PathVariable String name, Model model) {
        model.addAttribute("person", peopleService.findByName(name));
        return "person/personInfo";
    }
}