package com.example.realtime_dashboard.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;
@Slf4j
@Service
@RequiredArgsConstructor
public class LeaderboardService{
    private final RedisTemplate<String,Object> redisTemplate;
    private ZSetOperations<String,String> zSetOperations;

    public void updateScore(String leaderboardId,String score,double scoreDelta){
        log.debug("Method used update ");

        zSetOperations.incrementScore(leaderboardId,score,scoreDelta);


    }
    public Set<String> getTopScorers(String  leaderboardId,int topN){
        log.debug("Method used get top scorers");
        return zSetOperations.reverseRange(leaderboardId,0,topN-1);

    }



}
