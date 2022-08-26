package com.example.kafkatwitter.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    // @Value(value = "${tweet.topic.name}")
    // private String tweetTopic;

    // @Value(value = "${retweet.topic.name}")
    // private String retweetTopic;

    // @Value(value = "${reply.topic.name}")
    // private String replyTopic;

    // @Value(value = "${like.topic.name}")
    // private String likeTopic;

    // @Value(value = "${notif.topic.name}")
    // private String notifTopic;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic() {
        return new NewTopic("twitter", 5, (short) 1);
    }


    @Bean
    public NewTopic topic1() {
        return new NewTopic("follow", 5, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic("notif", 5, (short) 1);
    }

    // @Bean
    // public NewTopic topic3() {
    //     return new NewTopic(replyTopic, 1, (short) 1);
    // }

    // @Bean
    // public NewTopic topic4() {
    //     return new NewTopic(likeTopic, 1, (short) 1);
    // }

    // @Bean
    // public NewTopic topic5() {
    //     return new NewTopic(notifTopic, 1, (short) 1);
    // }

   
}
