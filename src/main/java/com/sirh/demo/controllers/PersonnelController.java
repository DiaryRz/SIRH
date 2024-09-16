package com.sirh.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.sirh.demo.services.PersonnelService;
import com.sirh.demo.models.Retour; 
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/sirh")
public class PersonnelController {
    @Autowired
    private PersonnelService personnelService;

    @GetMapping("/personnels/monteeParDefaut")
    public Retour getPersonnelsMonteeParDefaut() throws Exception {
        return new Retour(personnelService.MonteeParDefaut(1));
    }

    @GetMapping("/personnels/nonMonteeParDefaut")
    public Retour getPersonnelsNonMonteeParDefaut() throws Exception {
        return new Retour(personnelService.MonteeParDefaut(0));
    }

    @GetMapping("/personnels/TousLesMonteeParDefaut/Matin")
    public Retour getPersonnelsTousLesMonteeParDefautMatin(@RequestParam String dateCourse) throws Exception {
        return new Retour(personnelService.MonteeParDefautMoinsAbsence(dateCourse, 0));
    }

    @GetMapping("/personnels/TousLesMonteeParDefaut/Soir")
    public Retour getPersonnelsMonteeParDefautMoinsAbsenceSoir(@RequestParam String dateCourse) throws Exception {
        return new Retour(personnelService.MonteeParDefautMoinsAbsence(dateCourse, 1));
    }

    // Personnel qui prend le personnel sans prendre en compte les conges et les absences (matin et soir)
    @GetMapping("/personnels/personnelSansCongeEtTTMatin")
    public Retour getPersonnelsPersonnelSansCongeEtTTMatin(@RequestParam String dateCourse) throws Exception {
        return new Retour(personnelService.ListePersonnelARecupererSansCongeEtTTMatin(dateCourse));
    }

    @GetMapping("/personnels/personnelSansCongeEtTTSoir")
    public Retour getPersonnelsPersonnelSansCongeEtTTSoir(@RequestParam String dateCourse) throws Exception {
        return new Retour(personnelService.ListePersonnelARecupererSansCongeEtTTSoir(dateCourse));
    }

    // Conge + TT sur un jour donné
    @GetMapping("/personnels/getCongesEtTTMatin")
    public Retour getCongesEtTT(@RequestParam String dateCourse) throws Exception {
        return new Retour(personnelService.getCongesEtTT(dateCourse , 0));
    }

    @GetMapping("/personnels/getCongesEtTTSoir")
    public Retour getCongesEtTTSoir(@RequestParam String dateCourse) throws Exception {
        return new Retour(personnelService.getCongesEtTT(dateCourse , 1));
    }

}
