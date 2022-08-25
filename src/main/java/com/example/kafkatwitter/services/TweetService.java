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

        List<TweetEntity> id = new ArrayList<>();
        int tweetId = 0 ;
        tweetRepo.findAll().forEach(id::add);
        if ( id.size() == 0  ){
            tweetId =1;
        }
        else{
            tweetId = (id.get(id.size()-1).getUserId() ) + 1;
            for (int i = 0; i<id.size(); i++){
                if(tweetId == id.get(i).getUserId()){
                    tweetId++;
                }
            }

        }
        TweetEntity tweet =new TweetEntity();
        tweet.setTweetId(tweetId);
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
