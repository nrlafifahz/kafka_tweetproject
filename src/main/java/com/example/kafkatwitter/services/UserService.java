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

@Service
public class UserService implements Serializable{
    @Autowired
    private UserRepo userRepo;
   
    

    public UserEntity add(UserModel userModel) throws ClientException{
        
        List<UserEntity> id = new ArrayList<>();
        int userId = 0 ;
        userRepo.findAll().forEach(id::add);
        if ( id.size() == 0  ){
            userId =1;
        }
        else{
            userId = (id.get(id.size()-1).getUserId() ) + 1;
            for (int i = 0; i<id.size(); i++){
                if(userId == id.get(i).getUserId()){
                    userId++;
                }
            }

        }
       
        UserEntity user =new UserEntity();
        user.setUserId(userId);
        user.setName(userModel.getName());   
           

        return userRepo.save(user);
    } 
    
    public List<UserEntity> findAll(){
        //userRepo.deleteAll();
        List<UserEntity> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;
    }
}
