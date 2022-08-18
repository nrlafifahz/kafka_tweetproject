package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.ReplyEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.ReplyModel;
import com.example.kafkatwitter.repos.ReplyRepo;

@Service
public class ReplyService implements Serializable{
    @Autowired
    private ReplyRepo replyRepo;
   

    public ReplyEntity add(ReplyModel retweetModel) throws ClientException{
        
        ReplyEntity reply =new ReplyEntity();
        reply.setUserId(retweetModel.getUserId());   
        reply.setActivityId(retweetModel.getActivityId());     
        reply.setActivityId(retweetModel.getActivityId());  
        reply.setActyvityType(retweetModel.getActyvityType());  

        return replyRepo.save(reply);
    } 
    
    public List<ReplyEntity> findAll(){
        List<ReplyEntity> reply = new ArrayList<>();
        replyRepo.findAll().forEach(reply::add);
        return reply;
    }
}
