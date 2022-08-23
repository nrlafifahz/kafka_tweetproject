package com.example.kafkatwitter.entities;

import org.springframework.data.annotation.Id;

public class TweetEntity   {
    // private static final long serialVersionUID = -4551953276601557391L;
     @Id
     private int tweetId;
     private int userId;
     private String msg;

    
     public TweetEntity() {}

     public TweetEntity(int tweetId, int userId,  String msg) {
         this.tweetId = tweetId;
         this.userId = userId;
         this.msg = msg;
        
     }

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
				"Tweet[tweetId=%s, userId='%s', msg='%s']",
				tweetId, userId, msg);
	}
 
}
