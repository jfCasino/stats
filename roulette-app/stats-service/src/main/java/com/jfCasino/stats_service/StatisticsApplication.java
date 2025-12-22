package com.jfCasino.stats_service;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//TODO remove exclude when db is configured		
@SpringBootApplication
public class StatisticsApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StatisticsApplication.class);
        app.setDefaultProperties(Map.of("server.port", "8082"));
        app.run(args);
    }
}
