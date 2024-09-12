package com.sirh.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sirh.demo.models.Teletravail;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TeleTravailService {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Méthode pour trouver des documents où un timestamp donné est entre dateDebut et dateFin
    public List<Teletravail> teletravailsEntreDeuxDates(Timestamp timestampToCompare) {
        // Créer une requête pour vérifier si timestampToCompare est entre dateDebut et dateFin
        Query query = new Query();
        query.addCriteria(Criteria.where("date_debut").lte(timestampToCompare)) // dateDebut <= timestampToCompare
              .addCriteria(Criteria.where("date_fin").gte(timestampToCompare));  // dateFin >= timestampToCompare

        // Exécuter la requête et récupérer les documents correspondants
        return mongoTemplate.find(query, Teletravail.class);
    }
}
