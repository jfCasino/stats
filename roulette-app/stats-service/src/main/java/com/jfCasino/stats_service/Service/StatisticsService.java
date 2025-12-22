package com.jfCasino.stats_service.Service;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.jfCasino.stats_service.Entities.Bet;
import com.jfCasino.stats_service.dto.internal.BetResponse;
import com.jfCasino.stats_service.Entities.TopWallet;
import com.jfCasino.stats_service.dto.internal.WalletResponse;
import com.jfCasino.stats_service.repository.BetRepository;
import com.jfCasino.stats_service.repository.TopWalletRepository;
import java.util.Collections;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class StatisticsService {

    private final TopWalletRepository topWalletRepository;
    private final BetRepository betRepository;

    //TODO implement asyncronus communication with rulette-service to recieve bets (using kafka)
    public StatisticsService(TopWalletRepository topWalletRepository, BetRepository betRepository) {
        this.topWalletRepository = topWalletRepository;
        this.betRepository = betRepository;
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
        List<TopWallet> wallets;

        wallets = topWalletRepository.findTop5ByOrderByBalanceDesc();

        return wallets.stream()
                .map(wallet -> new WalletResponse(
                        wallet.getWalletId(),
                        wallet.getBalance()
                ))
                .toList();
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
