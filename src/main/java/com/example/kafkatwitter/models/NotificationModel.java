package com.example.kafkatwitter.models;

public class NotificationModel {
    private int id;
     private int activityId;
     private String actyvityType;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
