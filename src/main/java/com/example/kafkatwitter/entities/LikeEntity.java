package com.example.kafkatwitter.entities;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ms_like")
public class LikeEntity implements Serializable {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int likeId;
     private int userId;
     private int activityId;
     private String actyvityType;
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
