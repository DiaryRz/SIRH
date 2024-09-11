package com.sirh.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;


@Configuration
public class MongoConfig {

    @Bean
    public CommandLineRunner createIndexes(MongoTemplate mongoTemplate, MongoMappingContext mongoMappingContext) {
        // Assure que les immatricules soient unique
        return args -> {
            //IndexOperations indexOps = mongoTemplate.indexOps(Voiture.class);
            //indexOps.ensureIndex(new Index().on("immatricule", Direction.ASC).unique());
        };
    }
}

