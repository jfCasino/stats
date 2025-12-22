package com.jfCasino.stats_service.repository;


import com.jfCasino.stats_service.Entities.Bet;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {

    List<Bet> findByUserIdOrderByCreatedAtDesc(String userId, Pageable pageable);

}