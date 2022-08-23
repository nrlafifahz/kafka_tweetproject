package com.example.kafkatwitter.models;

public class RetweetModel {
    private int retweetId;
    private int userId;
    private int activityId;
    private String actyvityType;
    public int getRetweetId() {
        return retweetId;
    }
    public void setRetweetId(int retweetId) {
        this.retweetId = retweetId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getActivityId() {
        return activityId;
    }
    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
    public String getActyvityType() {
        return actyvityType;
    }
    public void setActyvityType(String actyvityType) {
        this.actyvityType = actyvityType;
    }
  
}
