package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.LikeEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.LikeModel;
import com.example.kafkatwitter.repos.LikeRepo;

@Service
public class LikeService implements Serializable{
    @Autowired
    private LikeRepo likeRepo;
   

    public LikeEntity add(LikeModel likeModel) throws ClientException{
        
        LikeEntity like =new LikeEntity();
        like.setUserId(likeModel.getUserId());   
        like.setActivityId(likeModel.getActivityId());     
        like.setActivityId(likeModel.getActivityId());  
        like.setActyvityType(likeModel.getActyvityType());  

        return likeRepo.save(like);
    } 
    
    public List<LikeEntity> findAll(){
        List<LikeEntity> like = new ArrayList<>();
        likeRepo.findAll().forEach(like::add);
        return like;
    }
}
