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

@Service
public class ReplyService implements Serializable{
    @Autowired
    private ReplyRepo replyRepo;
   
    @Autowired
    private NotificationRepo notifRepo;

    @Autowired
    private KafkaTemplate<String, NotificationEntity> kafkaTemplate;

    public ReplyEntity add(ReplyModel replyModel) throws ClientException{

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
        reply.setActyvityType(replyModel.getActyvityType());      
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
        notif.setActyvityType("replyId");   
        notif.setActivityId(replyId);     
        notifRepo.save(notif);
        kafkaTemplate.send("twitter", 4 , null, notif);

        return replyRepo.save(reply);
    } 
    
    public List<ReplyEntity> findAll(){
        List<ReplyEntity> replys = new ArrayList<>();
        replyRepo.findAll().forEach(replys::add);
        return replys;
    }
}
