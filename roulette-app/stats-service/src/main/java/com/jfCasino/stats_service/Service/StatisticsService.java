package com.jfCasino.stats_service.Service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jfCasino.stats_service.Client.WalletClient;
import com.jfCasino.stats_service.Entities.Bet;
import com.jfCasino.stats_service.dto.internal.BetResponse;
import com.jfCasino.stats_service.Entities.TopWallet;
import com.jfCasino.stats_service.dto.internal.WalletResponse;
import com.jfCasino.stats_service.repository.BetRepository;
import com.jfCasino.stats_service.repository.TopWalletRepository;
import java.util.Collections;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.jfCasino.stats_service.dto.kafka.BetCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.List;

@Service
public class StatisticsService {

    private final TopWalletRepository topWalletRepository;
    private final BetRepository betRepository;
    private final WalletClient walletClient;

    public StatisticsService(TopWalletRepository topWalletRepository, BetRepository betRepository, WalletClient walletClient) {
        this.topWalletRepository = topWalletRepository;
        this.betRepository = betRepository;
        this.walletClient = walletClient;
    }

    @KafkaListener(topics = "bets-topic", groupId = "stats-group")
    public void handleBetCreated(BetCreatedEvent event) {

        // Map event to stats entity
        Bet statsBet = new Bet();
        statsBet.setId(event.getId());
        statsBet.setUserId(event.getUserId());
        statsBet.setTotalStake(event.getTotalStake());
        statsBet.setGameId(event.getGameId());
        statsBet.setCreatedAt(event.getCreatedAt());

        betRepository.save(statsBet);
    }

    public List<BetResponse> getBetStatistics(String userId, String order, int limit) {

        Pageable pageable = PageRequest.of(0, limit);

        // Always fetch DESC from DB (most efficient with index)
        List<Bet> bets =
                betRepository.findByUserIdOrderByCreatedAtDesc(userId, pageable);

        // If ASC is requested, reverse in-memory
        if ("asc".equalsIgnoreCase(order)) {
            Collections.reverse(bets);
        }

        // Map to response objects
        return bets.stream()
                .map(BetResponse::fromEntity)
                .toList();
    }
    

    public List<WalletResponse> getLeaderboardTop5() {
        // Call the Feign client
        ResponseEntity<List<WalletResponse>> response = walletClient.getAllWallets("desc", 5);

        // Check response status
        if (!response.getStatusCode().is2xxSuccessful() || response.getBody() == null) {
            throw new RuntimeException("Failed to fetch wallets for leaderboard");
        }

        // Return the list
        return response.getBody();
    }

    //za vsak slucaj ce bomo rabli
    public List<WalletResponse> getLeaderboard(String order, int limit) {
        Pageable pageable = PageRequest.of(0, limit);

        List<TopWallet> wallets;

        if ("asc".equalsIgnoreCase(order)) {
            wallets = topWalletRepository.findAllByOrderByBalanceAsc(pageable);
        } else {
            // default to DESC for safety
            wallets = topWalletRepository.findAllByOrderByBalanceDesc(pageable);
        }

        return wallets.stream()
                .map(wallet -> new WalletResponse(
                        wallet.getWalletId(),
                        wallet.getBalance()
                ))
                .toList();
    }


}
