package com.example.kafkatwitter.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.kafkatwitter.entities.UserEntity;

public interface UserRepo  extends MongoRepository<UserEntity,String> {
    
}
