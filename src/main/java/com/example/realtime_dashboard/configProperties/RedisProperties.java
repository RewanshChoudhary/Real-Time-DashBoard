package com.example.realtime_dashboard.configProperties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@Slf4j
@ConfigurationProperties(prefix="spring.data.redis")
public class RedisProperties {
    private String host;
    private String port;
    private String leaderBoardKey;


}
