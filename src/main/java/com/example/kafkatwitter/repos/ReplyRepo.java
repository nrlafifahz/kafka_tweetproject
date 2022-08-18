package com.example.kafkatwitter.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkatwitter.entities.ReplyEntity;

@Repository
public interface ReplyRepo  extends JpaRepository<ReplyEntity,String> {
    
}
