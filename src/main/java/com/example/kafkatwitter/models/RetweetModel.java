package com.example.kafkatwitter.models;

public class RetweetModel {
    private int retweetId;
    private int userId;
    private String activityType;
    private int activityId;
    private String msg;
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
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }

   

  
}
