package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.TweetEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.TweetModel;
import com.example.kafkatwitter.repos.TweetRepo;

@Service
public class TweetService implements Serializable{
    @Autowired
    private TweetRepo tweetRepo;
   

    public TweetEntity add(TweetModel tweetModel) throws ClientException{
        
      

        TweetEntity tweet =new TweetEntity();
        tweet.setUserId(tweetModel.getUserId());   
        tweet.setMsg(tweetModel.getMsg());     

        return tweetRepo.save(tweet);
    } 
    
    public List<TweetEntity> findAll(){
        List<TweetEntity> tweets = new ArrayList<>();
        tweetRepo.findAll().forEach(tweets::add);
        return tweets;
    }
}
