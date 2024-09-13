package com.sirh.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.sirh.demo.services.PersonnelService;
import com.sirh.demo.models.Retour; 

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
}
