package com.sirh.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sirh.demo.models.Retour;
import com.sirh.demo.services.CongeService;
import com.sirh.demo.models.Conge;
import java.util.*;

@RestController
@RequestMapping("/sirh/conges")
public class CongeConroller {
    @Autowired
    private CongeService CongeService;

    @GetMapping("/CongeDuJour")
    public Retour listeDesPersonnesARecuperer(@RequestParam String date) throws Exception {
        List<Conge> conge = CongeService.CongesEntreDeuxDates(date);
        return new Retour(conge);

    }
}
