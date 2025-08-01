package com.example.realtime_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class RealTimeDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(RealTimeDashboardApplication.class, args);
    }

}
