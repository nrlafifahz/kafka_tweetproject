package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.NotificationEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.NotificationModel;
import com.example.kafkatwitter.repos.NotificationRepo;

@Service
public class NotificationService implements Serializable{
    @Autowired
    private NotificationRepo notifRepo;
   
    
    public List<NotificationEntity> findAll(){
        List<NotificationEntity> notif = new ArrayList<>();
        notifRepo.findAll().forEach(notif::add);
        return notif;
    }
}
