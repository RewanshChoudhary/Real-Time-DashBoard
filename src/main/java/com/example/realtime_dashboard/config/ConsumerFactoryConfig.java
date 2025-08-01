package com.example.realtime_dashboard.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;


import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class ConsumerFactoryConfig {
    @Value(value="${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;
    @Value(value="${spring.kafka.bootstrap-groupId}")
    private String groupId;


    @Bean
    public ConsumerFactory<String,String> consumerFactory(){
        Map<String,Object> configC=new HashMap<>();
        configC.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        configC.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configC.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,StringDeserializer.class);
        configC.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);

        return new DefaultKafkaConsumerFactory<>(configC);


    }
    @Bean
   public ConcurrentKafkaListenerContainerFactory <String,String > ListenerCosumerFactory(){
        ConcurrentKafkaListenerContainerFactory <String,String> factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;

    }
}
