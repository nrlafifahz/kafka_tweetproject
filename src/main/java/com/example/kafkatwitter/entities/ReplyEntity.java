package com.example.kafkatwitter.entities;


import org.springframework.data.annotation.Id;


public class ReplyEntity  {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     private int replyId;
     private int userId;
     private String activityType;
     private int activityId;
     private String msg;
     public ReplyEntity() {}

	public ReplyEntity(int replyId, int userId, String activityType, int activityId,  String msg) {
        this.replyId = replyId;
		this.userId = userId;
        this.activityType = activityType;
        this.activityId = activityId;
        this.msg = msg;
	}

    
    @Override
	public String toString() {
		return String.format(
				"Reply[replyId=%s, userId='%s', activityType='%s', activityId='%s',  msg='%s']",
				replyId, userId, activityType, activityId,  msg);
	}

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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
