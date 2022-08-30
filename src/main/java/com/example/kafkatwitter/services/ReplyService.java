package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.NotificationEntity;
import com.example.kafkatwitter.entities.ReplyEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.ReplyModel;
import com.example.kafkatwitter.repos.NotificationRepo;
import com.example.kafkatwitter.repos.ReplyRepo;
import com.example.kafkatwitter.validators.ReplyValidator;

@Service
public class ReplyService implements Serializable{
    @Autowired
    private ReplyRepo replyRepo;
   
    @Autowired
    private NotificationRepo notifRepo;

    @Autowired
    private KafkaTemplate<String, NotificationEntity> kafkaTemplate;

    @Autowired
    private NotificationService notifService;

    ReplyValidator replyValidator = new ReplyValidator();

    public ReplyEntity add(ReplyModel replyModel) throws ClientException{
        replyValidator.nullChekcUserId(replyModel.getUserId());
        replyValidator.validateUserId(replyModel.getUserId());
        replyValidator.nullChekcType(replyModel.getActivityType());
        replyValidator.validateType(replyModel.getActivityType());
        replyValidator.nullChekcActivityId(replyModel.getActivityId());
        replyValidator.validateActivityId(replyModel.getActivityId());
        List<ReplyEntity> id = new ArrayList<>();
        int replyId ;
        replyRepo.findAll().forEach(id::add);
        if ( id.size() == 0  ){
            replyId =1;
        }
        else{
            replyId = (id.get(id.size()-1).getReplyId() ) + 1;
            for (int i = 0; i<id.size(); i++){
                if(replyId == id.get(i).getReplyId()){
                    replyId++;
                }
            }

        }
        ReplyEntity reply =new ReplyEntity();
        reply.setReplyId(replyId);
        reply.setUserId(replyModel.getUserId());

        String temp = null;
        Integer tempId = 0;
        List<NotificationEntity> notifi = notifService.findAll();
        for (int i =0; i < notifi.size(); i++){
            if(notifi.get(i).getActivityType().trim().equalsIgnoreCase(replyModel.getActivityType())){
                if(notifi.get(i).getActivityId() == replyModel.getActivityId()){
                    temp=replyModel.getActivityType();      
                    tempId=replyModel.getActivityId();   
                }
            }
        }
        
        

        if(temp== null || tempId==0){
            throw new ClientException("the activity not found");
        }
        reply.setActivityType(replyModel.getActivityType());    
        reply.setActivityId(replyModel.getActivityId());

        reply.setMsg(replyModel.getMsg());     


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
        notif.setUserId(replyModel.getUserId());
        notif.setActivityType("replyId");   
        notif.setActivityId(replyId);     
        notifRepo.save(notif);
        kafkaTemplate.send("twitter", 4 , null, notif);

        return replyRepo.save(reply);
    } 
    
    public List<ReplyEntity> findAll(){
        //replyRepo.deleteAll();
        List<ReplyEntity> replys = new ArrayList<>();
        replyRepo.findAll().forEach(replys::add);
        return replys;
    }
}
