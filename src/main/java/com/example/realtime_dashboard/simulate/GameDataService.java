package com.example.realtime_dashboard.simulate;

import com.example.realtime_dashboard.configProperties.KafkaProperties;
import com.example.realtime_dashboard.dto.GameScoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor


public class GameDataService {
    private final KafkaProperties kafkaProperties;


    private final KafkaTemplate<String, GameScoreDto> kafkaTemplate;

    @Scheduled(fixedRate = 1000)
    public void spawnRecords() {
        for (int i = 0; i < 2000; i++) {
            publishGameData();

        }
    }


    public void publishGameData() {

        GameScoreDto gameScore = buildGameScore();
        System.out.println("The data was sent");

        kafkaTemplate.send(kafkaProperties.getTopic().getGameScoreTopic(), gameScore);


    }

    private GameScoreDto buildGameScore() {
        Random random = new Random();
        return GameScoreDto.builder()
                .score(random.nextInt(100) + 1)
                .userId(random.nextLong(1000_000) + 1)
                .createdAt(LocalDateTime.now()).build();
    }
}
