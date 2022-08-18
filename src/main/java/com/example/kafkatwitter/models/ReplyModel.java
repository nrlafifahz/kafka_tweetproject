package com.example.kafkatwitter.models;

public class ReplyModel {
    private int replyId;
    private int userId;
    private int activityId;
    private String actyvityType;
    private String msg;
    public int getReplyId() {
        return replyId;
    }
    public void setReplyId(int replyId) {
        this.replyId = replyId;
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
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
