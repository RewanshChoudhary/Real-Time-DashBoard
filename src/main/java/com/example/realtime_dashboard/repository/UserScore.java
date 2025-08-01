package com.example.realtime_dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScore extends JpaRepository<UserScore, Long> {
}
