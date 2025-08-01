package com.example.realtime_dashboard.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GameScoreDto {

    private int score;
    private long userId;
    private LocalDateTime createdAt;


}
