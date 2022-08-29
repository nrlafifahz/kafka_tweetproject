package com.example.kafkatwitter.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.TopicPartition;

import com.example.kafkatwitter.entities.LikeEntity;
import com.example.kafkatwitter.entities.NotificationEntity;
import com.example.kafkatwitter.entities.ReplyEntity;
import com.example.kafkatwitter.entities.RetweetEntity;
import com.example.kafkatwitter.entities.TweetEntity;

@Service
public class KafkaConsumerServ {
    
    @KafkaListener(topicPartitions = @TopicPartition(topic = "twitter", partitions = { "0" }), groupId = "tweet",
    containerFactory = "tweetKafkaListenerFactory")
    public void listenTweet( TweetEntity tweet) {
        System.out.println("Consumed JSON Message: " + tweet);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "twitter", partitions = { "1" }), groupId = "retweet",
    containerFactory = "retweetKafkaListenerFactory")
    public void listenRetweet( RetweetEntity retweet) {
        System.out.println("Consumed JSON Message: " + retweet);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "twitter", partitions = { "2" }), groupId = "reply",
    containerFactory = "replyKafkaListenerFactory")
    public void listenReply( ReplyEntity reply) {
        System.out.println("Consumed JSON Message: " + reply);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "twitter", partitions = { "3" }), groupId = "like",
    containerFactory = "likeKafkaListenerFactory")
    public void listenLike( LikeEntity like) {
        System.out.println("Consumed JSON Message: " + like);
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "twitter", partitions = { "4" }), groupId = "notif",
    containerFactory = "notifKafkaListenerFactory")
    public void listenNotif( NotificationEntity notif) {
        System.out.println("Consumed JSON Message: " + notif);
    }

    
}
