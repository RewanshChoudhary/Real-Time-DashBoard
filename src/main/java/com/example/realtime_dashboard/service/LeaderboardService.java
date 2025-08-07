package com.example.realtime_dashboard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class LeaderboardService{
    private final RedisTemplate<String,Object> redisTemplate;
    private ZSetOperations<String,String> zSetOperations;

    public void updateScore(String leaderboardId,String score,double scoreDelta){
        zSetOperations.incrementScore(leaderboardId,score,scoreDelta);


    }
    public Set<String> getTopScorers(String  leaderboardId,int topN){
        return zSetOperations.reverseRange(leaderboardId,0,topN-1);

    }



}
