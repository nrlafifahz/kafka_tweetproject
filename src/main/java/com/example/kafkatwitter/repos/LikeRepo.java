package com.example.kafkatwitter.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkatwitter.entities.LikeEntity;

@Repository
public interface LikeRepo  extends JpaRepository<LikeEntity,String>  {
    
}
