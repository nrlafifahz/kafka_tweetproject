package com.example.kafkatwitter.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kafkatwitter.entities.NotificationEntity;

@Repository
public interface NotificationRepo  extends JpaRepository<NotificationEntity,String> {
    
}
