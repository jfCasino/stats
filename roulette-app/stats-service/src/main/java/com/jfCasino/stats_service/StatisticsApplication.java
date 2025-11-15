package com.jfCasino.stats_service;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//TODO remove exclude when db is configured	
@EnableFeignClients	
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class StatisticsApplication {

	public static void main(String[] args) {
		//SpringApplication.run(StatisticsApplication.class, args);
		SpringApplication app = new SpringApplication(StatisticsApplication.class);
        app.setDefaultProperties(Map.of("server.port", "8082"));
        app.run(args);
	}

}
