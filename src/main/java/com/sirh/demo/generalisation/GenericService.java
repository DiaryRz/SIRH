package com.sirh.demo.generalisation;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.lang.reflect.Method;

public class GenericService {

    private final MongoTemplate mongoTemplate;

    public GenericService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public <T> String getDernierElementInsere(Class<T> clazz,String primaryKey) {
        try {
            Query query = new Query().with(Sort.by(Sort.Direction.DESC, "_id")).limit(1);
            T lastElement = mongoTemplate.findOne(query, clazz);

            if (lastElement != null) {
                Method getIdMethod = clazz.getMethod("get"+primaryKey);
                return (String) getIdMethod.invoke(lastElement);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
