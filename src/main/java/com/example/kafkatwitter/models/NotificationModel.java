package com.example.kafkatwitter.models;

public class NotificationModel {
    private int notifId;
    private String activityType;
     private int activityId;
     
    public int getNotifId() {
        return notifId;
    }
    public void setNotifId(int notifId) {
        this.notifId = notifId;
    }
    public String getActyvityType() {
        return activityType;
    }
    public void setActyvityType(String activityType) {
        this.activityType = activityType;
    }
    public int getActivityId() {
        return activityId;
    }
    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
     
  
    
}
