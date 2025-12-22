package com.jfCasino.stats_service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//JF skrbi za avtomatsko nastavljanje id in createdAt
@Configuration
@EnableJpaAuditing
public class JpaConfig {
}
