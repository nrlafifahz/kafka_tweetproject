package com.example.kafkatwitter.models;

public class NotificationModel {
    private int notifId;
     private int activityId;
     private String actyvityType;
    public int getNotifId() {
        return notifId;
    }
    public void setNotifId(int notifId) {
        this.notifId = notifId;
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
