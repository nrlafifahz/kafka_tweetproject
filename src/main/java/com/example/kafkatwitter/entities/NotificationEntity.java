package com.example.kafkatwitter.entities;

import org.springframework.data.annotation.Id;

public class NotificationEntity {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     private int notifId;
     private int userId;
     private int activityId;
     private String actyvityType;
     
     public NotificationEntity() {}

     public NotificationEntity(int notifId, int userId, int activityId, String actyvityType, String msg) {
         this.notifId = notifId;
         this.userId = userId;
         this.activityId = activityId;
         this.actyvityType = actyvityType;
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
				"Notif[notifId=%s, userId='%s', activityId='%s', actyvityType='%s']",
				notifId, userId, activityId, actyvityType);
	}
    
}
