package com.jfCasino.stats_service.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jfCasino.stats_service.Service.StatisticsService;
import com.jfCasino.stats_service.dto.internal.WalletResponse;

@RestController
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    //JF returns a users statistics about his bets, limit it and order by time
    @GetMapping("/stats/bets")
    public ResponseEntity<List<Object>> getBetStatistics(@RequestParam(name = "order",defaultValue = "asc") String order,
    @RequestParam(name = "limit", defaultValue = "10") int limit) {
        //TODO implement this api with asynchronus comunication via kafka
        //TODO implement method to get bet statistics from rulette-service DB
        return ResponseEntity.ok(List.of("bet statistics"));
    }

    @GetMapping("/stats/leaderboard")
    public ResponseEntity<List<WalletResponse>> getLeaderboard(@RequestParam(name = "order",defaultValue = "desc") String order,
    @RequestParam(name = "limit", defaultValue = "10") int limit) {
        //TODO implement method to get leaderboard statistics, get data from wallet service
        return ResponseEntity.ok(statisticsService.getLeaderboard(order, limit));
    }
}
