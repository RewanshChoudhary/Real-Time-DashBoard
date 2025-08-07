package com.example.realtime_dashboard.configProperties;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@ConfigurationProperties(prefix="spring.kafka")

@Component
@Data
@Validated

public class KafkaProperties {
    private String bootstrapServers;
    private GroupId groupId;

    private Topic topic;
    @Data

    public static class Topic {
        private String gameScoreTopic;
        private String leaderboardTopic;

    }
    @Data
public static class GroupId{
        private String gamesScoreGroupid;
        private String redisGameScoreGroupid;
        private String redisLeaderboardGroupid;
}

}
