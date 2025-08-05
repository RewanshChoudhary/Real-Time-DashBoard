package com.example.realtime_dashboard.repository;

import com.example.realtime_dashboard.model.User_Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScoreRepository extends JpaRepository<User_Score, Long> {
}
