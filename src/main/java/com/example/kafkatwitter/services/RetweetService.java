package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.NotificationEntity;
import com.example.kafkatwitter.entities.RetweetEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.RetweetModel;
import com.example.kafkatwitter.repos.NotificationRepo;
import com.example.kafkatwitter.repos.RetweetRepo;
import com.example.kafkatwitter.validators.RetweetValidator;

import org.springframework.kafka.annotation.TopicPartition;

@Service
public class RetweetService implements Serializable{
    @Autowired
    private RetweetRepo retweetRepo;
   
    @Autowired
    private NotificationRepo notifRepo;

    @Autowired
    private KafkaTemplate<String, NotificationEntity> kafkaTemplate;

    @Autowired
    private NotificationService notifService;

    RetweetValidator retweetValidator = new RetweetValidator();

    public RetweetEntity add(RetweetModel retweetModel) throws ClientException{
        retweetValidator.nullChekcUserId(retweetModel.getUserId());
        retweetValidator.validateUserId(retweetModel.getUserId());
        retweetValidator.nullChekcType(retweetModel.getActivityType());
        retweetValidator.validateType(retweetModel.getActivityType());
        retweetValidator.nullChekcActivityId(retweetModel.getActivityId());
        retweetValidator.validateActivityId(retweetModel.getActivityId());

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
        
        String temp = null;
        Integer tempId = 0;

        List<NotificationEntity> notifi = notifService.findAll();
        for (int i =0; i < notifi.size(); i++){
            
                
            if(notifi.get(i).getActivityType().trim().equalsIgnoreCase(retweetModel.getActivityType())){
                
                if(notifi.get(i).getActivityId() == retweetModel.getActivityId()){
                
                    temp = retweetModel.getActivityType();
                    tempId = retweetModel.getActivityId();

                }
            }
        }

        
        
        if(temp== null || tempId==0){
            throw new ClientException("the activity not found");
        }
        retweet.setActivityType(retweetModel.getActivityType());    
        retweet.setActivityId(retweetModel.getActivityId());
        retweet.setMsg(retweetModel.getMsg());
      
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
        notif.setActivityType("retweet");   
        notif.setActivityId(retweetId);     
        notifRepo.save(notif);
        kafkaTemplate.send("twitter", 4 , null, notif);

        return retweetRepo.save(retweet);
    } 

  
    
    public List<RetweetEntity> findAll(){

        //retweetRepo.deleteAll();
        List<RetweetEntity> retweets = new ArrayList<>();
        retweetRepo.findAll().forEach(retweets::add);
        return retweets;
    }
}
