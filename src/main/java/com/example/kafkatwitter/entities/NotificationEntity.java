package com.example.kafkatwitter.entities;

import org.springframework.data.annotation.Id;

public class NotificationEntity {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     private int notifId;
     private int userId;
     private String activityType;
     private int activityId;
     
     
     public NotificationEntity() {}

     public NotificationEntity(int notifId, int userId,  String activityType, int activityId) {
         this.notifId = notifId;
         this.userId = userId;
         this.activityType = activityType;
         this.activityId = activityId;
         
     }

    @Override
	public String toString() {
		return String.format(
				"Notif[notifId=%s, userId='%s', activityType='%s' , activityId='%s']",
				notifId, userId, activityType, activityId);
	}

    public int getNotifId() {
        return notifId;
    }

    public void setNotifId(int notifId) {
        this.notifId = notifId;
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
    
}
