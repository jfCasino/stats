package com.jfCasino.stats_service.Service;

import org.springframework.stereotype.Service;
import com.jfCasino.stats_service.Client.WalletClient;
import com.jfCasino.stats_service.dto.internal.WalletResponse;
import java.util.List;

@Service
public class StatisticsService {

    private final WalletClient walletClient;

    //TODO implement asyncronus communication with rulette-service to recieve bets (using kafka)
    public StatisticsService(WalletClient walletClient) {
        this.walletClient = walletClient;
    }
    
    public List<WalletResponse> getLeaderboard(String order, int limit) {
        return walletClient.getAllWallets(order, limit).getBody();
    }
}
