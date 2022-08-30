package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.NotificationEntity;
import com.example.kafkatwitter.entities.TweetEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.TweetModel;
import com.example.kafkatwitter.repos.NotificationRepo;
import com.example.kafkatwitter.repos.TweetRepo;
import com.example.kafkatwitter.validators.TweetValidator;

@Service
public class TweetService implements Serializable{
    @Autowired
    private TweetRepo tweetRepo;
   
    @Autowired
    private NotificationRepo notifRepo;

    @Autowired
    private KafkaTemplate<String, NotificationEntity> kafkaTemplate;


    TweetValidator tweetValidator = new TweetValidator();
    
    public TweetEntity add(TweetModel tweetModel) throws ClientException{
      
        tweetValidator.nullChekcUserId(tweetModel.getUserId());
        tweetValidator.validateUserId(tweetModel.getUserId());
        tweetValidator.nullChekcMsg(tweetModel.getMsg());
    

        List<TweetEntity> id = new ArrayList<>();
        int tweetId;
        tweetRepo.findAll().forEach(id::add);
        if ( id.size() == 0  ){
            tweetId =1;
        }
        else{
            tweetId = (id.get(id.size()-1).getTweetId() ) + 1;
            for (int i = 0; i<id.size(); i++){
                if(tweetId == id.get(i).getTweetId()){
                    tweetId++;
                }
            }

        }
        TweetEntity tweet =new TweetEntity();
        tweet.setTweetId(tweetId);
        tweet.setUserId(tweetModel.getUserId());   
        tweet.setMsg(tweetModel.getMsg());   
        
        
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
        notif.setUserId(tweetModel.getUserId());
        notif.setActivityType("tweet");   
        notif.setActivityId(tweetId);     
        notifRepo.save(notif);
        kafkaTemplate.send("twitter", 4 , null, notif);

        return tweetRepo.save(tweet);
    } 
    
    public List<TweetEntity> findAll(){
        
        //tweetRepo.deleteAll();

        List<TweetEntity> tweets = new ArrayList<>();
        tweetRepo.findAll().forEach(tweets::add);
        return tweets;
    }
}
