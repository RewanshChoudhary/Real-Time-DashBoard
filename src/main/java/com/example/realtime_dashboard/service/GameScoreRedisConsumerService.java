package com.example.realtime_dashboard.service;

import com.example.realtime_dashboard.configProperties.KafkaProperties;
import com.example.realtime_dashboard.configProperties.RedisProperties;
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

    private final KafkaTemplate<String, LeaderboardChangeDto> kafkaLeaderboardTemplate;

    private final KafkaProperties kafkaProperties;
    private final RedisProperties redisProperties;


    @KafkaListener(
            topics="${spring.kafka.topic.game-score-topic}",
            groupId = "${spring.kafka.groupId.redis-game-score-groupid }"
    )
    public void consumekafkaRedisTopic(ConsumerRecord<String, GameScoreDto> record){

        var gameScoreData=record.value();
        var score=gameScoreData.getScore();
        log.debug("Got the data "+record);

        var leaderboardKey=redisProperties.getLeaderBoardKey();
        LeaderboardChangeDto changeDto=LeaderboardChangeDto.builder()
                        .timestampChange(gameScoreData.getCreatedAt())
                                .build();


        redisTemplate.opsForZSet().incrementScore(leaderboardKey, String.valueOf(gameScoreData.getUserId()),score);
        log.debug("Incremented score ");

        kafkaLeaderboardTemplate.send(kafkaProperties.getTopic().getLeaderboardTopic(),changeDto);
        log.debug("Sended the timestamp to kafka topic",kafkaProperties.getTopic().getLeaderboardTopic());









    }




}
