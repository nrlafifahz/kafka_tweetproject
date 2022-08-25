package com.example.kafkatwitter.repos;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkatwitter.entities.UserEntity;

@Repository
public interface UserRepo  extends MongoRepository<UserEntity,String>  {
    
}
