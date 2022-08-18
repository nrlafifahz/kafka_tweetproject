package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.RetweetEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.RetweetModel;
import com.example.kafkatwitter.repos.RetweetRepo;

@Service
public class RetweetService implements Serializable{
    @Autowired
    private RetweetRepo retweetRepo;
   

    public RetweetEntity add(RetweetModel retweetModel) throws ClientException{
        
        RetweetEntity retweet =new RetweetEntity();
        retweet.setUserId(retweetModel.getUserId());   
        retweet.setActivityId(retweetModel.getActivityId());     
        retweet.setActivityId(retweetModel.getActivityId());  
        retweet.setActyvityType(retweetModel.getActyvityType());  

        return retweetRepo.save(retweet);
    } 
    
    public List<RetweetEntity> findAll(){
        List<RetweetEntity> retweets = new ArrayList<>();
        retweetRepo.findAll().forEach(retweets::add);
        return retweets;
    }
}
