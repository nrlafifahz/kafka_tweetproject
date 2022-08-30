package com.example.kafkatwitter.validators;

import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.exceptions.NotFoundException;

public class TweetValidator {
    public void nullChekcTweetId(Integer id) throws ClientException{
        if(id==null){
            throw new ClientException( "Tweet id is required");

        }
    }
   
    public void notnullChekcTweetId(Integer id ) throws ClientException {
        if(id!=null){
            throw new ClientException( "Tweet id is auto generated, do not input id");

        }
    }

    public void nullChekcUserId(Integer id) throws ClientException{
        if(id==null){
            throw new ClientException( "User id is required");

        }
    }
    
    public void nullChekcMsg (String msg ) throws ClientException {
        if(msg==null){
            throw new ClientException( "Massage  is required");

        }
    }

    public void nullChekcObject( Object o) throws NotFoundException{
        if(o ==null){
            throw new NotFoundException( "Tweet id is not found");

        }
    }
    public void validateTweetId (Integer id) throws ClientException{
        if (id <= 0){
            throw new ClientException("Tweet id input is invalid");
        }
    }
    public void validateUserId (Integer id) throws ClientException{
        if (id <= 0){
            throw new ClientException("User id input is invalid");
        }
    }
    
    
}
