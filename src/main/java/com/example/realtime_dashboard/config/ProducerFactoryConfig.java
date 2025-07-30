package com.example.realtime_dashboard.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration

public class ProducerFactoryConfig {
    @Value(value="${spring.bootstrap,server }")

    private String bootstrapServer;


    @Bean
    public ProducerFactory<String ,String > producerConfig(){

        Map<String,Object> configP=new HashMap<>();
        configP.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServer);
        configP.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configP.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configP);



    }
    @Bean
    public KafkaTemplate kafkaTemplate(){
        return new KafkaTemplate(producerConfig());

    }
}
