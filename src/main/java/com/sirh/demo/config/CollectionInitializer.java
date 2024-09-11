package com.sirh.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CollectionInitializer implements CommandLineRunner {

    @Autowired
    private MongoTemplate mongoTemplate;

    // Créer tous les tables annoter @Document dans la base de données 
    @Override
    public void run(String... args) throws Exception {
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Document.class));

        Set<Class<?>> documentClasses = scanner.findCandidateComponents("com.example.Service_bus.models").stream()
                .map(beanDefinition -> {
                    try {
                        return Class.forName(beanDefinition.getBeanClassName());
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toSet());
                
        for (Class<?> documentClass : documentClasses) {
            if (!mongoTemplate.collectionExists(documentClass)) {
                mongoTemplate.createCollection(documentClass);
            }
        }
    }
}

