package com.example.kafkatwitter.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ms_retweet")
public class RetweetEntity implements Serializable {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
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
