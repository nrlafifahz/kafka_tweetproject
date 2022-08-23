package com.example.kafkatwitter.repos;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkatwitter.entities.TweetEntity;

@Repository
public interface TweetRepo  extends MongoRepository<TweetEntity,String>  {
    
}
