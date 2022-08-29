package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.NotificationEntity;
import com.example.kafkatwitter.entities.RetweetEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.RetweetModel;
import com.example.kafkatwitter.repos.NotificationRepo;
import com.example.kafkatwitter.repos.RetweetRepo;

@Service
public class RetweetService implements Serializable{
    @Autowired
    private RetweetRepo retweetRepo;
   
    @Autowired
    private NotificationRepo notifRepo;

    @Autowired
    private KafkaTemplate<String, NotificationEntity> kafkaTemplate;

    public RetweetEntity add(RetweetModel retweetModel) throws ClientException{

        List<RetweetEntity> id = new ArrayList<>();
        int retweetId ;
        retweetRepo.findAll().forEach(id::add);
        if ( id.size() == 0  ){
            retweetId =1;
        }
        else{
            retweetId = (id.get(id.size()-1).getRetweetId() ) + 1;
            for (int i = 0; i<id.size(); i++){
                if(retweetId == id.get(i).getRetweetId()){
                    retweetId++;
                }
            }

        }
        RetweetEntity retweet =new RetweetEntity();
        retweet.setRetweetId(retweetId);
        retweet.setUserId(retweetModel.getUserId()); 
        retweet.setActyvityType(retweetModel.getActyvityType());    
        retweet.setActivityId(retweetModel.getActivityId());
        
        List<NotificationEntity> idN = new ArrayList<>();
        int notifId ;
        notifRepo.findAll().forEach(idN::add);
        if ( idN.size() == 0  ){
            notifId =1;
        }
        else{
            notifId = (idN.get(idN.size()-1).getNotifId() ) + 1;
            for (int i = 0; i<idN.size(); i++){
                if(notifId == idN.get(i).getNotifId()){
                    notifId++;
                }
            }

        }
        NotificationEntity notif =new NotificationEntity();
        notif.setNotifId(notifId);
        notif.setUserId(retweetModel.getUserId());
        notif.setActyvityType("retweet");   
        notif.setActivityId(retweetId);     
        notifRepo.save(notif);
        kafkaTemplate.send("twitter", 4 , null, notif);

        return retweetRepo.save(retweet);
    } 
    
    public List<RetweetEntity> findAll(){
        List<RetweetEntity> retweets = new ArrayList<>();
        retweetRepo.findAll().forEach(retweets::add);
        return retweets;
    }
}
