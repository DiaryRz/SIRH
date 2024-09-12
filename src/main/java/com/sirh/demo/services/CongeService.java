package com.sirh.demo.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.sirh.demo.models.Conge;
import com.sirh.demo.utilities.ConvertDate;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class CongeService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Conge> CongesEntreDeuxDates(String timestampToCompareStr) throws ParseException{
        ConvertDate appelConvertDate = new ConvertDate();
        Date timestampToCompare = appelConvertDate.convertStringToDateTime(timestampToCompareStr);
        
        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(utcTimeZone);
        calendar.setTime(timestampToCompare);
        Date utcTimestamp = calendar.getTime();

        Query query = new Query();
        System.out.println("Comparaison avec la date UTC : " + utcTimestamp);
        query.addCriteria(Criteria.where("date_debut").lte(utcTimestamp))
             .addCriteria(Criteria.where("date_fin").gte(utcTimestamp));

        List<Conge> results =  mongoTemplate.find(query, Conge.class);
        return results;
    }
}
