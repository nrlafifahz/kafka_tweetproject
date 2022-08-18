package com.example.kafkatwitter.models;

public class TweetModel {
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
