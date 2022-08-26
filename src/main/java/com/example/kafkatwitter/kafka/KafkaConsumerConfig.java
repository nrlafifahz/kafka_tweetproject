package com.example.kafkatwitter.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.kafkatwitter.entities.LikeEntity;
import com.example.kafkatwitter.entities.NotificationEntity;
import com.example.kafkatwitter.entities.ReplyEntity;
import com.example.kafkatwitter.entities.RetweetEntity;
import com.example.kafkatwitter.entities.TweetEntity;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;


    @Bean
    public ConsumerFactory<String, TweetEntity> tweetConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "tweet");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(TweetEntity.class));
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, TweetEntity> tweetKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, TweetEntity> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(tweetConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, RetweetEntity> retweetConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "retweet");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(RetweetEntity.class));
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, RetweetEntity> retweetKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, RetweetEntity> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(retweetConsumerFactory());
        return factory;
    }


    @Bean
    public ConsumerFactory<String, ReplyEntity> replyConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "reply");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(ReplyEntity.class));
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, ReplyEntity> replyKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, ReplyEntity> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(replyConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, LikeEntity> likeConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "like");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(LikeEntity.class));
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, LikeEntity> likeKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, LikeEntity> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(likeConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, NotificationEntity> notifConsumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "notif");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),
                new JsonDeserializer<>(NotificationEntity.class));
    }
    
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, NotificationEntity> notifKafkaListenerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, NotificationEntity> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(notifConsumerFactory());
        return factory;
    }


}
