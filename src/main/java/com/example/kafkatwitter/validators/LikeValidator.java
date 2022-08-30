package com.example.kafkatwitter.validators;

import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.exceptions.NotFoundException;

public class LikeValidator {
    public void nullChekcLikeId(Integer id) throws ClientException{
        if(id==null){
            throw new ClientException( "Like id is required");

        }
    }
   
    public void notnullChekcLikeId(Integer id ) throws ClientException {
        if(id!=null){
            throw new ClientException( "Like id is auto generated, do not input id");

        }
    }

    public void nullChekcUserId(Integer id) throws ClientException{
        if(id==null){
            throw new ClientException( "User id is required");

        }
    }

    public void nullChekcType (String type ) throws ClientException {
        if(type==null){
            throw new ClientException( "actvity type  is required");

        }
    }
    public void nullChekcActivityId(Integer id) throws ClientException{
        if(id==null){
            throw new ClientException( "activity id is required");

        }
    }
    

    public void nullChekcObject( Object o) throws NotFoundException{
        if(o ==null){
            throw new NotFoundException( "Like id is not found");

        }
    }
    public void validateLikeId (Integer id) throws ClientException{
        if (id <= 0){
            throw new ClientException("Like id input is invalid");
        }
    }
    public void validateUserId (Integer id) throws ClientException{
        if (id <= 0){
            throw new ClientException("User id input is invalid");
        }
    }
    public void validateType (String type) throws ClientException{
        if (!type.trim().equalsIgnoreCase("like") && !type.trim().equalsIgnoreCase("tweet") && !type.trim().equalsIgnoreCase("retweet") && !type.trim().equalsIgnoreCase("reply")){
            throw new ClientException("Activity type is invalid! please input tweet, retweet, reply, or like");
        }
    }
    public void validateActivityId (Integer id) throws ClientException{
        if (id <= 0){
            throw new ClientException("Activity id input is invalid");
        }
    }



    
    
}
