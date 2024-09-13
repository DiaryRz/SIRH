package com.sirh.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sirh.demo.services.ExceptionPresenceService;
import com.sirh.demo.models.Retour;

@RestController
@RequestMapping("/sirh/presenceExceptionnel")
public class ExceptionPresenceController {
    @Autowired
    private ExceptionPresenceService exceptionPresenceService;

    @GetMapping("/present/Matin")
    public Retour getExceptionPresencesMatin(@RequestParam String dateCourse) throws Exception {
        return new Retour(exceptionPresenceService.ExceptionPresences(dateCourse, 1 , 0));
    }

    @GetMapping("/present/Soir")
    public Retour getExceptionPresencesSoir(@RequestParam String dateCourse) throws Exception {
        return new Retour(exceptionPresenceService.ExceptionPresences(dateCourse, 1 , 1));
    }

    @GetMapping("/absent/Matin")
    public Retour getExceptionPresencesAbsentMatin(@RequestParam String dateCourse) throws Exception {
        return new Retour(exceptionPresenceService.ExceptionPresences(dateCourse, 0 , 0));
    }

    @GetMapping("/absent/Soir")
    public Retour getExceptionPresencesAbsentSoir(@RequestParam String dateCourse) throws Exception {
        return new Retour(exceptionPresenceService.ExceptionPresences(dateCourse, 0 , 1));
    }

}
