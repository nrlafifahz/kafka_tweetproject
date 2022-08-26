package com.example.kafkatwitter.entities;


import org.springframework.data.annotation.Id;


public class ReplyEntity  {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     private int replyId;
     
     private int userId;
     private int activityId;
     private String actyvityType;
     private String msg;

     public ReplyEntity() {}

	public ReplyEntity(int replyId, int userId, int activityId, String actyvityType, String msg) {
        this.replyId = replyId;
		this.userId = userId;
        this.activityId = activityId;
		this.actyvityType = actyvityType;
        this.msg = msg;
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

   
    @Override
	public String toString() {
		return String.format(
				"Reply[replyId=%s, userId='%s', activityId='%s', actyvityType='%s', , msg='%s']",
				replyId, userId, activityId, actyvityType, msg);
	}
}
