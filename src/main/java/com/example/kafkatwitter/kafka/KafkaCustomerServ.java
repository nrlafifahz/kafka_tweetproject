package com.example.kafkatwitter.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.kafkatwitter.entities.TweetEntity;

@Service
public class KafkaCustomerServ {
    // @KafkaListener(topics = "Kafka_Example", groupId  = "tweet")
    // public void consume(String message) {
    //     System.out.println("Consumed message: " + message);
    // }


    @KafkaListener(topics = "twitter", groupId = "tweet",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(TweetEntity tweet) {
        System.out.println("Consumed JSON Message: " + tweet);
    }
}
