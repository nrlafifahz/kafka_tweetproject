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

@Service
public class LikeService implements Serializable{
    @Autowired
    private LikeRepo likeRepo;
   
    @Autowired
    private NotificationRepo notifRepo;

    @Autowired
    private KafkaTemplate<String, NotificationEntity> kafkaTemplate;

    public LikeEntity add(LikeModel likeModel) throws ClientException{

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
        like.setActyvityType(likeModel.getActyvityType());  
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
        notif.setActyvityType("like");   
        notif.setActivityId(likeId);     
        notifRepo.save(notif);
        
        kafkaTemplate.send("twitter", 4 , null, notif);

        return likeRepo.save(like);
    } 
    
    public List<LikeEntity> findAll(){
        List<LikeEntity> likes = new ArrayList<>();
        likeRepo.findAll().forEach(likes::add);
        return likes;
    }
}
