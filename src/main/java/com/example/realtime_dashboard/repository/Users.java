package com.example.realtime_dashboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

;


@Repository

public interface Users extends JpaRepository<Users, Long> {
}
