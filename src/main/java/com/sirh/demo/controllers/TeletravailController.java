package com.sirh.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.sirh.demo.models.Retour;
import com.sirh.demo.models.Teletravail;
import com.sirh.demo.services.TeleTravailService;

@RestController
@RequestMapping("/sirh/teletravails")
public class TeletravailController {
    @Autowired
    private TeleTravailService TeleTravailService;

    @GetMapping("/TTDuJour")
    public Retour listeDesPersonnesARecuperer(@RequestParam String date) throws Exception {
        List<Teletravail> teletravail = TeleTravailService.teletravailsEntreDeuxDates(date);
        return new Retour(teletravail);

    }
    
}
