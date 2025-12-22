package com.jfCasino.stats_service.repository;


import com.jfCasino.stats_service.Entities.Bet;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BetRepository extends JpaRepository<Bet, UUID> {

    List<Bet> findByUserIdOrderByCreatedAtDesc(String userId, Pageable pageable);

}