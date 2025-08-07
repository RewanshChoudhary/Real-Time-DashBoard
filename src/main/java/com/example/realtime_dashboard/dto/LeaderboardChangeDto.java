package com.example.realtime_dashboard.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class LeaderboardChangeDto {
    private LocalDateTime timestampChange;

}
