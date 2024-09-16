package com.sirh.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sirh.demo.models.Personnel;
import com.sirh.demo.utilities.ConvertDate;
import com.sirh.demo.models.ExceptionPresence;
import java.util.*;
import java.util.stream.Collectors;
import com.sirh.demo.services.CongeService;
import com.sirh.demo.models.Conge;
import com.sirh.demo.models.Teletravail;
import com.sirh.demo.services.TeleTravailService;

@Service
public class PersonnelService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ExceptionPresenceService exceptionPresenceService;

    @Autowired
    private CongeService congeService;

    @Autowired
    private TeleTravailService teletravailService;

    public List<Personnel> MonteeParDefaut(int identifiant ) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("identifiant").is(identifiant)
                .and("profil.nom_profil").is("personnel"));

        return mongoTemplate.find(query, Personnel.class);
    }

    // Tonga par défaut - tsy tonga tampoka
    public List<Personnel> MonteeParDefautMoinsAbsence(String dateCourse , int matin_ou_soir) throws Exception {
        List<Personnel> personnel = MonteeParDefaut(1);
        List<ExceptionPresence> exceptionPresences = exceptionPresenceService.ExceptionPresences(dateCourse, 0, matin_ou_soir);
        List<Personnel> exceptionPersonnel = exceptionPresences.stream()
            .map(ExceptionPresence::getPersonnel)
            .collect(Collectors.toList());
        Set<String> exceptionIds = exceptionPersonnel.stream()
            .map(Personnel::getId_personnel)
            .collect(Collectors.toSet());
        personnel.removeIf(p -> exceptionIds.contains(p.getId_personnel()));
        return personnel;
    }

    public List<Personnel> ListePersonnelARecupererSansCongeEtTTMatin(String dateCourse) throws Exception {
        List<Personnel> personnel = MonteeParDefautMoinsAbsence(dateCourse, 0);
        //1 : ho avy tampoka , 0 : matin
        List<ExceptionPresence> exceptionPresences = exceptionPresenceService.ExceptionPresences(dateCourse, 1, 0);
        Set<Personnel> personnelSansConge = new HashSet<>(personnel);
        personnelSansConge.addAll(exceptionPresences.stream()
            .map(ExceptionPresence::getPersonnel)
            .collect(Collectors.toList()));

        List<Personnel> resultList = new ArrayList<>(personnelSansConge);
        return resultList;
    }

    public List<Personnel> ListePersonnelARecupererSansCongeEtTTSoir(String dateCourse) throws Exception {
        List<Personnel> personnel = MonteeParDefautMoinsAbsence(dateCourse, 1);
        //1 : ho avy tampoka , 0 : matin
        List<ExceptionPresence> exceptionPresences = exceptionPresenceService.ExceptionPresences(dateCourse, 1, 1);
        Set<Personnel> personnelSansConge = new HashSet<>(personnel);
        personnelSansConge.addAll(exceptionPresences.stream()
            .map(ExceptionPresence::getPersonnel)
            .collect(Collectors.toList()));

        List<Personnel> resultList = new ArrayList<>(personnelSansConge);
        return resultList;
    }

    //conge sy TT sur un jour donné
    public List<Personnel> CongesEtTTEntreDeuxDates(String dateCourse) throws Exception {
        List<Personnel> Personnelconges = congeService.CongesEntreDeuxDates(dateCourse).stream()
            .map(Conge::getPersonnel)
            .collect(Collectors.toList());
        List<Personnel> PersonnelTT = teletravailService.teletravailsEntreDeuxDates(dateCourse).stream()
            .map(Teletravail::getPersonnel)
            .collect(Collectors.toList());
        Set<Personnel> personnelSansConge = new HashSet<>(Personnelconges);
        personnelSansConge.addAll(PersonnelTT);

        List<Personnel> resultList = new ArrayList<>(personnelSansConge);  
        return resultList;       
    }

    public List<Personnel> getCongesEtTT(String date, int matin_ou_soir) throws Exception {
        String dateAvecHeure = date + (matin_ou_soir == 0 ? "T09:00:00" : "T17:55:00");
        return CongesEtTTEntreDeuxDates(dateAvecHeure);
    }
}
