package com.sirh.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.sirh.demo.models.Teletravail;
import com.sirh.demo.utilities.ConvertDate;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.util.TimeZone;
import java.util.Calendar;

@Service
public class TeleTravailService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Teletravail> teletravailsEntreDeuxDates(String timestampToCompareStr) throws ParseException {
        ConvertDate appelConvertDate = new ConvertDate();
        Date timestampToCompare = appelConvertDate.convertStringToDateTime(timestampToCompareStr);

        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(utcTimeZone);
        calendar.setTime(timestampToCompare);
        Date utcTimestamp = calendar.getTime();

        Query query = new Query();
        System.out.println("Comparaison avec la date UTC : " + utcTimestamp);
        query.addCriteria(Criteria.where("date_debut").lte(utcTimestamp))  // dateDebut <= timestampToCompare
             .addCriteria(Criteria.where("date_fin").gte(utcTimestamp));  // dateFin >= timestampToCompare

        List<Teletravail> results =  mongoTemplate.find(query, Teletravail.class);
        return results;
    }
}
