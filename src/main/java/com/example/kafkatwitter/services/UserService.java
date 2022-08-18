package com.example.kafkatwitter.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.UserEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.UserModel;
import com.example.kafkatwitter.repos.UserRepo;
import com.example.kafkatwitter.validators.UserValidator;

@Service
public class UserService implements Serializable{
    @Autowired
    private UserRepo userRepo;

    UserValidator userValidator = new UserValidator();
   

    public UserEntity add(UserModel userModel) throws ClientException{
        userValidator.notnullChekcUserId(userModel.getUserId());
        userValidator.nullChekcFullname(userModel.getName());
        userValidator.validateFullname(userModel.getName());
      

        UserEntity user =new UserEntity();
        user.setName(userModel.getName());        

        return userRepo.save(user);
    } 
    
    public List<UserEntity> findAll(){
        List<UserEntity> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;
    }
}
