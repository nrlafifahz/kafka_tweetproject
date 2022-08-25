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
   

    public ReplyEntity add(ReplyModel replyModel) throws ClientException{

        List<ReplyEntity> id = new ArrayList<>();
        int replyId = 0 ;
        replyRepo.findAll().forEach(id::add);
        if ( id.size() == 0  ){
            replyId =1;
        }
        else{
            replyId = (id.get(id.size()-1).getUserId() ) + 1;
            for (int i = 0; i<id.size(); i++){
                if(replyId == id.get(i).getUserId()){
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

        return replyRepo.save(reply);
    } 
    
    public List<ReplyEntity> findAll(){
        List<ReplyEntity> replys = new ArrayList<>();
        replyRepo.findAll().forEach(replys::add);
        return replys;
    }
}
