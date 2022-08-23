package com.example.kafkatwitter.repos;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkatwitter.entities.RetweetEntity;

@Repository
public interface RetweetRepo  extends MongoRepository<RetweetEntity,String> {
    
}
