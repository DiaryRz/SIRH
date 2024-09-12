package com.sirh.demo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import com.sirh.demo.services.ExceptionPresenceService;
import com.sirh.demo.models.ExceptionPresence;

@RestController
@RequestMapping("/sirh/presenceExceptionnel")
public class ExceptionPresenceController {
    @Autowired
    private ExceptionPresenceService exceptionPresenceService;

    @GetMapping("/present/Matin")
    public List<ExceptionPresence> getExceptionPresencesMatin(@RequestParam String dateCourse) throws Exception {
        return exceptionPresenceService.ExceptionPresences(dateCourse, 1 , 0);
    }

    @GetMapping("/present/Soir")
    public List<ExceptionPresence> getExceptionPresencesSoir(@RequestParam String dateCourse) throws Exception {
        return exceptionPresenceService.ExceptionPresences(dateCourse, 1 , 1);
    }

    @GetMapping("/absent/Matin")
    public List<ExceptionPresence> getExceptionPresencesAbsentMatin(@RequestParam String dateCourse) throws Exception {
        return exceptionPresenceService.ExceptionPresences(dateCourse, 0 , 0);
    }

    @GetMapping("/absent/Soir")
    public List<ExceptionPresence> getExceptionPresencesAbsentSoir(@RequestParam String dateCourse) throws Exception {
        return exceptionPresenceService.ExceptionPresences(dateCourse, 0 , 1);
    }

}
