package com.sirh.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sirh.demo.models.Profil;


public interface ProfilRepository  extends MongoRepository<Profil, String> {
   long count();
}
