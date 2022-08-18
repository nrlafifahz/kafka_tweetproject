package com.example.kafkatwitter.models;

public class RetweetModel {
    private int retweetId;
    private String userId;
    private String activityId;
    private String actyvityType;
    public int getRetweetId() {
        return retweetId;
    }
    public void setRetweetId(int retweetId) {
        this.retweetId = retweetId;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getActivityId() {
        return activityId;
    }
    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }
    public String getActyvityType() {
        return actyvityType;
    }
    public void setActyvityType(String actyvityType) {
        this.actyvityType = actyvityType;
    }
}
