package com.example.kafkatwitter.models;

public class LikeModel {
    private int likeId;
     private int userId;
     private String activityType;
     private int activityId;
    public int getLikeId() {
        return likeId;
    }
    public void setLikeId(int likeId) {
        this.likeId = likeId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getActivityType() {
        return activityType;
    }
    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }
    public int getActivityId() {
        return activityId;
    }
    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
     
   
     
    
}
