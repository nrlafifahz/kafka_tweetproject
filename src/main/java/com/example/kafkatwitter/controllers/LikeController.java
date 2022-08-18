package com.example.kafkatwitter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkatwitter.entities.LikeEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.LikeModel;
import com.example.kafkatwitter.models.ResponseModel;
import com.example.kafkatwitter.services.LikeService;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    private LikeService likeService;

    
    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel>postCategoryController(@RequestBody LikeModel likeModel){
        try {
            //request
            LikeEntity like = likeService.add(likeModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "New category is successfully added");
            response.setData(like);
            return ResponseEntity.ok(response);

        } catch(ClientException e){
            ResponseModel response = new ResponseModel();
            response.setMsg(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 
 
    @GetMapping(value = "/get")
    public ResponseEntity<ResponseModel>getAllCategoryController(){
        try {
            //request
            List<LikeEntity> like = likeService.findAll();

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "request successfully");
            response.setData(like);
            return ResponseEntity.ok(response);

        
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 

}
