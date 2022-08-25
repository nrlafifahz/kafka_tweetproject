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

        List<RetweetEntity> id = new ArrayList<>();
        int retweetId = 0 ;
        retweetRepo.findAll().forEach(id::add);
        if ( id.size() == 0  ){
            retweetId =1;
        }
        else{
            retweetId = (id.get(id.size()-1).getUserId() ) + 1;
            for (int i = 0; i<id.size(); i++){
                if(retweetId == id.get(i).getUserId()){
                    retweetId++;
                }
            }

        }
        RetweetEntity retweet =new RetweetEntity();
        retweet.setRetweetId(retweetId);
        retweet.setUserId(retweetModel.getUserId()); 
        retweet.setActyvityType(retweetModel.getActyvityType());    
        retweet.setActivityId(retweetModel.getActivityId());
            

        return retweetRepo.save(retweet);
    } 
    
    public List<RetweetEntity> findAll(){
        List<RetweetEntity> retweets = new ArrayList<>();
        retweetRepo.findAll().forEach(retweets::add);
        return retweets;
    }
}
