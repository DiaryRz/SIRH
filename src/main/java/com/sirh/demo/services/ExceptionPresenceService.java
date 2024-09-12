package com.sirh.demo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import org.apache.commons.lang3.tuple.Pair;

import com.sirh.demo.models.ExceptionPresence;
import com.sirh.demo.utilities.MongoDate;

@Service
public class ExceptionPresenceService {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<ExceptionPresence> ExceptionPresences(String inputDate , int identifiant , int matin_ou_soir) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date givenDate = dateFormat.parse(inputDate);

        MongoDate mongoDate = new MongoDate();
        Pair<Date, Date> result = mongoDate.getStartAndEndOfDay(givenDate);
        Date startDate = result.getLeft();
        Date endDate = result.getRight();

        Query query = new Query();
        query.addCriteria(Criteria.where("date").gte(startDate).lt(endDate)
                .and("matin_ou_soir").is(matin_ou_soir)
                .and("identifiant").is(identifiant) );

        return mongoTemplate.find(query, ExceptionPresence.class);
    }

}
