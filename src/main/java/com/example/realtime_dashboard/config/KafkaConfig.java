package com.example.realtime_dashboard.config;


import com.example.realtime_dashboard.configProperties.KafkaProperties;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;
@Configuration
@EnableKafka
@Slf4j
public class KafkaConfig {

    private final KafkaProperties kafkaProperties;

    public KafkaConfig(KafkaProperties kafkaProperties) {
        this.kafkaProperties = kafkaProperties;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic gameScoreTopic() {
        return new NewTopic(kafkaProperties.getTopic().getGameScoreTopic(), 1, (short) 1);
    }

    @Bean
    public NewTopic leaderboardTopic() {
        return new NewTopic(kafkaProperties.getTopic().getLeaderboardTopic(), 1, (short) 1);
    }
}


