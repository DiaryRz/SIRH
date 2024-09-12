package com.sirh.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sirh.demo.models.Personnel;
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
    

    // @Autowired
    // public VoitureController(KeycloakService keycloakService) {
    //     this.keycloakService = keycloakService;
    // }

    // @Autowired
    // private VoitureService voitureService;

    // @PostMapping("/voitures/create")
    // public Retour creerVoiture(@RequestBody Voiture voiture,@RequestParam String chauffeur) throws Exception {
    //     return voitureService.creerVoitureAvecChauffeur(voiture,chauffeur);
    // }

    // @PostMapping("/voitures/update")
    // public Retour modifierVoiture(@RequestParam String idVoiture,@RequestParam String chauffeur) throws Exception {
    //     return voitureService.ModifierVoiture(idVoiture, chauffeur);
    // }

    // @GetMapping("/voitures/byid")
    // public Retour findVoitureById(@RequestParam String idVoiture) throws Exception {
    //     return voitureService.trouverParId(idVoiture);
    // }
    // @GetMapping("/voitures")
    // public Retour selectVoiture() throws Exception {
    //     return voitureService.selectVoiture();
    // }


    // @GetMapping("/voitures/delete")
    // public void supprimerVoiture(@RequestParam String idVoiture) throws Exception {
    //     voitureService.SupprimerVoiture(idVoiture);
    // }
}