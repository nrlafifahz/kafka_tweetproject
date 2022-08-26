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
   

    public NotificationEntity add(NotificationModel notifModel) throws ClientException{

        List<NotificationEntity> id = new ArrayList<>();
        int notifId ;
        notifRepo.findAll().forEach(id::add);
        if ( id.size() == 0  ){
            notifId =1;
        }
        else{
            notifId = (id.get(id.size()-1).getNotifId() ) + 1;
            for (int i = 0; i<id.size(); i++){
                if(notifId == id.get(i).getNotifId()){
                    notifId++;
                }
            }

        }
        NotificationEntity notif =new NotificationEntity();
        notif.setNotifId(notifId);
        notif.setActyvityType(notifModel.getActyvityType());   
        notif.setActivityId(notifModel.getActivityId());     

        return notifRepo.save(notif);
    } 
    
    public List<NotificationEntity> findAll(){
        List<NotificationEntity> notif = new ArrayList<>();
        notifRepo.findAll().forEach(notif::add);
        return notif;
    }
}
