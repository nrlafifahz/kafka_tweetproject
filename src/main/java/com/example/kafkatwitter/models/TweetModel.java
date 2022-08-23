package com.example.kafkatwitter.models;

public class TweetModel {
    private int tweetId;
    private int userId;
    private String msg;
    public int getTweetId() {
        return tweetId;
    }
    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
   
}
