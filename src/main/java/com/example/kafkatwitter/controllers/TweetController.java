package com.example.kafkatwitter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkatwitter.models.TweetModel;
import com.example.kafkatwitter.services.TweetService;
import com.example.kafkatwitter.entities.TweetEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.ResponseModel;

@RestController
@RequestMapping("/tweet")
public class TweetController {
    @Autowired
    private TweetService tweetService;

    
    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel>postCategoryController(@RequestBody TweetModel tweetModel){
        try {
            //request
            TweetEntity Tweet = tweetService.add(tweetModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "New category is successfully added");
            response.setData(Tweet);
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
            List<TweetEntity> Tweet = tweetService.findAll();

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "request successfully");
            response.setData(Tweet);
            return ResponseEntity.ok(response);

        
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 

}
