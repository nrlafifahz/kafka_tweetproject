package com.example.kafkatwitter.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ms_tweet")
public class TweetEntity implements Serializable {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int tweetId;
     private String userId;
     private String msg;

    public int getTweetId() {
        return tweetId;
    }
    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
