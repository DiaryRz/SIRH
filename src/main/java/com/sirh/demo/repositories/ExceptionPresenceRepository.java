package com.sirh.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.sirh.demo.models.ExceptionPresence;
import java.util.Date;
import java.util.List;

public interface ExceptionPresenceRepository extends MongoRepository<ExceptionPresence, String> {
    List<ExceptionPresence> findByDateBetween(Date startDate, Date endDate);
}
