package com.example.kafkatwitter.entities;

import org.springframework.data.annotation.Id;

public class UserEntity   {
   // private static final long serialVersionUID = -4551953276601557391L;
    @Id
    
    private int userId;
    private String name;

    public UserEntity() {}

	public UserEntity(int userId,  String name) {
		this.userId = userId;
		this.name = name;
        
	}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
	public String toString() {
		return String.format(
				"User[userId='%s', name='%s']",
				userId, name);
	}
 

}
