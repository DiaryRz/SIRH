package com.sirh.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sirh.demo.models.Personnel;

public interface PersonnelRepository extends MongoRepository<Personnel, String> {
   long count();
}

