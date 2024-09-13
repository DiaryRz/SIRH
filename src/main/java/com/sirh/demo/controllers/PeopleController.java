package com.sirh.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sirh.demo.models.Retour;
import com.sirh.demo.services.PeopleService;


@RestController
@RequestMapping("/sirh")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("/people")
    public Retour selectPeople() throws Exception {
        return peopleService.selectPeople();
    }
    @GetMapping("/chauffeurs")
    public Retour getChauffeurs() {
        return peopleService.trouverTousLesChauffeurs();
    }
    @GetMapping("/personnels")
    public Retour getPersonnels() {
        return peopleService.trouverTousLesPersonnels();
    }
    @GetMapping("/personnel")
    public Retour trouverPersonnelParId(@RequestParam String id_personnel) {
        return peopleService.trouverPersonnelParId(id_personnel);
    }

    @GetMapping("/chauffeur")
    public Retour trouverChauffeurParId(@RequestParam String id_personnel) {
        return peopleService.trouverChauffeurParId(id_personnel);
    }
    
}