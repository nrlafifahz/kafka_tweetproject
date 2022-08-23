package com.example.kafkatwitter.entities;


import org.springframework.data.annotation.Id;


public class RetweetEntity  {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     private int retweetId;

     private int userId;
     private int activityId;
     private String actyvityType;


    public RetweetEntity() {}

	public RetweetEntity(int retweetId, int userId, int activityId, String actyvityType) {
		this.retweetId = retweetId;
		this.userId = userId;
        this.activityId = activityId;
		this.actyvityType = actyvityType;
	}

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

    @Override
	public String toString() {
		return String.format(
				"Reweet[retweetId=%s, userId='%s', activityId='%s', actyvityType='%s']",
				retweetId, userId, activityId, actyvityType);
	}

  
}
