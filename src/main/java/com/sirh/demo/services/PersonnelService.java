package com.sirh.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sirh.demo.models.Personnel;

import java.util.*;

@Service
public class PersonnelService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Personnel> MonteeParDefaut(int identifiant ) throws Exception {
        Query query = new Query();
        query.addCriteria(Criteria.where("identifiant").is(identifiant)
                .and("profil.nom_profil").is("personnel"));

        return mongoTemplate.find(query, Personnel.class);
    }
}
