package com.jfCasino.stats_service.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jfCasino.stats_service.Service.StatisticsService;
import com.jfCasino.stats_service.dto.internal.BetResponse;
import com.jfCasino.stats_service.dto.internal.WalletResponse;

@RestController
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    //JF returns a users statistics about his bets, limit it and order by time
    @GetMapping("/stats/bets/{userId}")

    public ResponseEntity<List<BetResponse>> getBetStatistics(@PathVariable("userID") String userId,@RequestParam(name = "order",defaultValue = "asc") String order,
    @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return ResponseEntity.ok(statisticsService.getBetStatistics(userId, order, limit)); 
    }

    @GetMapping("/stats/leaderboard")
    public ResponseEntity<List<WalletResponse>> getLeaderboard(@RequestParam(name = "order",defaultValue = "desc") String order,
    @RequestParam(name = "limit", defaultValue = "10") int limit) {
        return ResponseEntity.ok(statisticsService.getLeaderboard(order, limit));
    }

    @GetMapping("/stats/leaderboard/top5")
    public ResponseEntity<List<WalletResponse>> getLeaderboard() {
        return ResponseEntity.ok(statisticsService.getLeaderboardTop5());
    }

}
