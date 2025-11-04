package com.jfCasino.stats_service.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StatisticsController {
    
    //JF returns a users statistics about his bets, limit it and order by time
    @GetMapping("/stats/bets")
    public ResponseEntity<List<Object>> getBetStatistics(@RequestParam(name = "order",defaultValue = "asc") String order,
    @RequestParam(name = "limit", defaultValue = "10") int limit) {
        //TODO implement method to get bet statistics from rulette-service DB
        return ResponseEntity.ok(List.of("bet statistics"));
    }

    @GetMapping("/stats/leaderboard")
    public ResponseEntity<List<Object>> getLeaderboard(@RequestParam(name = "order",defaultValue = "asc") String order,
    @RequestParam(name = "limit", defaultValue = "10") int limit) {
        //TODO implement method to get leaderboard statistics, get data from wallet service
        return ResponseEntity.ok(List.of("leaderboard statistics"));
    }
}
