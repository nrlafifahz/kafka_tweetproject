package com.example.kafkatwitter.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkatwitter.entities.TweetEntity;

@Repository
public interface TweetRepo  extends JpaRepository<TweetEntity,String>  {
    
}
