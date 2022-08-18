package com.example.kafkatwitter.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kafkatwitter.entities.UserEntity;

public interface UserRepo  extends JpaRepository<UserEntity,String> {
    
}
