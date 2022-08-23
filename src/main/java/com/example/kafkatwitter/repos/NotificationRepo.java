package com.example.kafkatwitter.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkatwitter.entities.NotificationEntity;

@Repository
public interface NotificationRepo  extends MongoRepository<NotificationEntity,String> {
    
}
