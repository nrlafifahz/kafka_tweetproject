package com.example.kafkatwitter.validators;

import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.exceptions.NotFoundException;

public class LikeValidator {
    public void nullChekcUserId(Integer id) throws ClientException{
        if(id==null){
            throw new ClientException( "User id is required");

        }
    }
   
    public void notnullChekcUserId(Integer id ) throws ClientException {
        if(id!=null){
            throw new ClientException( "User id is auto generated, do not input id");

        }
    }
    
    public void nullChekcFullname(String fullName ) throws ClientException {
        if(fullName==null){
            throw new ClientException( "User name is required");

        }
    }

    public void nullChekcObject( Object o) throws NotFoundException{
        if(o ==null){
            throw new NotFoundException( "User id is not found");

        }
    }
    
    public void validateUserId (Integer id) throws ClientException{
        if (id <= 0){
            throw new ClientException("User id input is invalid");
        }
    }
    
    public void validateFullname (String fullName) throws ClientException{
        if (fullName.trim().equalsIgnoreCase(" ")){
            throw new ClientException("User name is required");
        }
    }
}
