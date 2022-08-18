package com.example.kafkatwitter.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ms_reply")
public class ReplyEntity implements Serializable {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
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
