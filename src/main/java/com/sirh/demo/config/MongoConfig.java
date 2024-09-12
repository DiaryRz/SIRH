package com.sirh.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.sirh.demo.models.Personnel;

@Configuration
public class MongoConfig {

    @Bean
    public CommandLineRunner createIndexes(MongoTemplate mongoTemplate, MongoMappingContext mongoMappingContext) {
        return args -> {
            IndexOperations indexOps = mongoTemplate.indexOps(Personnel.class);
            // Assure que les emails soient uniques
            //indexOps.ensureIndex(new Index().on("email", Direction.ASC).unique());
            // Assure que les id soient uniques
            //indexOps.ensureIndex(new Index().on("id_personnel", Direction.ASC).unique());
        };
    }
}

