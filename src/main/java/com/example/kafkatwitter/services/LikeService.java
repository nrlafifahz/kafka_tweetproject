// package com.example.kafkatwitter.services;

// import java.io.Serializable;
// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.example.kafkatwitter.entities.LikeEntity;
// import com.example.kafkatwitter.exceptions.ClientException;
// import com.example.kafkatwitter.models.LikeModel;
// import com.example.kafkatwitter.repos.LikeRepo;

// @Service
// public class LikeService implements Serializable{
//     @Autowired
//     private LikeRepo likeRepo;
   

//     public LikeEntity add(LikeModel likeModel) throws ClientException{

//         List<LikeEntity> id = new ArrayList<>();
//         int likeId = 0 ;
//         likeRepo.findAll().forEach(id::add);
//         if ( id.size() == 0  ){
//             likeId =1;
//         }
//         else{
//             likeId = (id.get(id.size()-1).getUserId() ) + 1;
//             for (int i = 0; i<id.size(); i++){
//                 if(likeId == id.get(i).getUserId()){
//                     likeId++;
//                 }
//             }

//         }
//         LikeEntity like =new LikeEntity();
//         like.setLikeId(likeId);
//         like.setUserId(likeModel.getUserId());   
//         like.setActyvityType(likeModel.getActyvityType());  
//         like.setActivityId(likeModel.getActivityId());

//         return likeRepo.save(like);
//     } 
    
//     public List<LikeEntity> findAll(){
//         List<LikeEntity> likes = new ArrayList<>();
//         likeRepo.findAll().forEach(likes::add);
//         return likes;
//     }
// }
