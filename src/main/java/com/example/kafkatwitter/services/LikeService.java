package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.LikeEntity;
import com.example.kafkatwitter.entities.NotificationEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.LikeModel;
import com.example.kafkatwitter.repos.LikeRepo;
import com.example.kafkatwitter.repos.NotificationRepo;
import com.example.kafkatwitter.validators.LikeValidator;

@Service
public class LikeService implements Serializable{
    @Autowired
    private LikeRepo likeRepo;
   
    @Autowired
    private NotificationRepo notifRepo;

    @Autowired
    private KafkaTemplate<String, NotificationEntity> kafkaTemplate;

    @Autowired
    private NotificationService notifService;

    LikeValidator likeValidator = new LikeValidator();
    public LikeEntity add(LikeModel likeModel) throws ClientException{

        likeValidator.nullChekcUserId(likeModel.getUserId());
        likeValidator.validateUserId(likeModel.getUserId());
        likeValidator.nullChekcType(likeModel.getActivityType());
        likeValidator.validateType(likeModel.getActivityType());
        likeValidator.nullChekcActivityId(likeModel.getActivityId());
        likeValidator.validateActivityId(likeModel.getActivityId());

        List<LikeEntity> id = new ArrayList<>();
        int likeId;
        likeRepo.findAll().forEach(id::add);
        if ( id.size() == 0  ){
            likeId =1;
        }
        else{
            likeId = (id.get(id.size()-1).getLikeId() ) + 1;
            for (int i = 0; i<id.size(); i++){
                if(likeId == id.get(i).getLikeId()){
                    likeId++;
                }
            }

        }
        LikeEntity like =new LikeEntity();
        like.setLikeId(likeId);
        like.setUserId(likeModel.getUserId());   

        String temp = null;
        Integer tempId = 0;
        List<NotificationEntity> notifi = notifService.findAll();
        for (int i =0; i < notifi.size(); i++){
            if(notifi.get(i).getActivityType().trim().equalsIgnoreCase(likeModel.getActivityType())){
                if(notifi.get(i).getActivityId() == likeModel.getActivityId()){
                    temp=likeModel.getActivityType();  
                    tempId=likeModel.getActivityId();

                }
            }
        }
        if(temp== null || tempId==0){
            throw new ClientException("the activity not found");
        }

        like.setActivityType(likeModel.getActivityType());    
        like.setActivityId(likeModel.getActivityId());
       

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
        notif.setUserId(likeModel.getUserId());
        notif.setActivityType("like");   
        notif.setActivityId(likeId);     
        notifRepo.save(notif);
        
        kafkaTemplate.send("twitter", 4 , null, notif);

        return likeRepo.save(like);
    } 
    
    public List<LikeEntity> findAll(){
       // likeRepo.deleteAll();
        List<LikeEntity> likes = new ArrayList<>();
        likeRepo.findAll().forEach(likes::add);
        return likes;
    }
}
