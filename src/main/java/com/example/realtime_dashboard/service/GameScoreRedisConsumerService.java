package com.example.realtime_dashboard.service;

import com.example.realtime_dashboard.configProperties.KafkaProperties;
import com.example.realtime_dashboard.dto.GameScoreDto;
import com.example.realtime_dashboard.dto.LeaderboardChangeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class GameScoreRedisConsumerService {

    private final RedisTemplate<String ,String> redisTemplate;

    private final KafkaTemplate<String, LeaderboardChangeDto> kafkaTemplate;

    private final KafkaProperties kafkaProperties;


    @KafkaListener(
            topics="${spring.kafka.topic.game-score-topic}",
            groupId = "${spring.kafka.groupId.redis-game-score-groupid }"
    )
    public void consumekafkaRedisTopic(ConsumerRecord<String, GameScoreDto> record){
        log.debug("Got the data "+record.toString());
        var gameScoreData=record.value();
        var score=gameScoreData.getScore();




    }




}
