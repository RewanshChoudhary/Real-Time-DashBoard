package com.example.realtime_dashboard.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
@Slf4j
@Configuration
public class RedisConfig {
    public RedisTemplate<String, Object> gameScoreRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        log.debug("Got the connection factory "+redisConnectionFactory.toString());


        RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;

    }
}
