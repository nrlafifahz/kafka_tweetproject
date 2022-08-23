package com.example.kafkatwitter.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkatwitter.entities.ReplyEntity;

@Repository
public interface ReplyRepo  extends MongoRepository<ReplyEntity,String> {
    
}
