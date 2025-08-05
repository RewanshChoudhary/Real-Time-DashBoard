package com.example.realtime_dashboard.config;

import com.example.realtime_dashboard.dto.GameScoreDto;
import com.example.realtime_dashboard.model.User_Score;
import com.example.realtime_dashboard.repository.UserScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor

public class GameScoreConsumerService {


    private final UserScoreRepository userScoreRepository;

    @KafkaListener(topics = {"${spring.kafka.broker.game-score-topic}"},
            groupId = "${spring.kafka.broker.game-score-topic-groupid}")
    public void gameScoreListener(ConsumerRecord<String, GameScoreDto> record) {

        log.debug("The data consumed ", record.key(), record.value());

        User_Score gameScoreDto = User_Score.builder()
                .score(record.value().getScore())
                .userId(record.value().getUserId())
                .createdAt(record.value().getCreatedAt())
                .build();

        userScoreRepository.save(gameScoreDto);



    }


}
