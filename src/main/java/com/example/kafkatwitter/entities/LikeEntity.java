package com.example.kafkatwitter.entities;


import org.springframework.data.annotation.Id;


public class LikeEntity {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     private int likeId;
     private int userId;
     private String activityType;
     private int activityId;
    

    public LikeEntity() {}

	public LikeEntity(int likeId, int userId,  String activityType, int activityId) {
		this.likeId = likeId;
		this.userId = userId;
        this.activityType = activityType;
        this.activityId = activityId;
		
	}



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


    
    @Override
	public String toString() {
		return String.format(
				"Like[likeId=%s, userId='%s', activityType='%s' , activityId='%s']",
				likeId, userId,activityType, activityId );
	}
   
}
