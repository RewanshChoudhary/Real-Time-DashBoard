package com.example.realtime_dashboard.repository;

import com.example.realtime_dashboard.model.User_Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

;


@Repository

public interface UsersRepository extends JpaRepository<User_Data, Long> {
}
