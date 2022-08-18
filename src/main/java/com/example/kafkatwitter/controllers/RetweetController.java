package com.example.kafkatwitter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkatwitter.entities.RetweetEntity;
import com.example.kafkatwitter.exceptions.ClientException;
import com.example.kafkatwitter.models.ResponseModel;
import com.example.kafkatwitter.models.RetweetModel;
import com.example.kafkatwitter.services.RetweetService;

@RestController
@RequestMapping("/reweet")
public class RetweetController {
    @Autowired
    private RetweetService retweetService;

    
    @PostMapping(value = "/add")
    public ResponseEntity<ResponseModel>postCategoryController(@RequestBody RetweetModel retweetModel){
        try {
            //request
            RetweetEntity retweet = retweetService.add(retweetModel);

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "New category is successfully added");
            response.setData(retweet);
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
            List<RetweetEntity> retweet = retweetService.findAll();

            //response
            ResponseModel response = new ResponseModel();
            response.setMsg( "request successfully");
            response.setData(retweet);
            return ResponseEntity.ok(response);

        
        }catch(Exception e){
            ResponseModel response =new ResponseModel();
            response.setMsg("Sorry, there is a failure on our server.");
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(response);
        }
    } 

}
