package com.example.kafkatwitter.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkatwitter.entities.RetweetEntity;

@Repository
public interface RetweetRepo  extends JpaRepository<RetweetEntity,String> {
    
}
