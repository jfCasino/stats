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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@Tag(name = "Statistics Service", description = "Endpoints for retrieving user and leaderboard statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/stats/bets/{userId}")
    @Operation(summary = "Retrieve a user's bet statistics",
               description = "Returns a list of BetResponse objects for the specified user, ordered and limited by parameters")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Bet statistics retrieved successfully"),
        @ApiResponse(responseCode = "404", description = "User not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<BetResponse>> getBetStatistics(
            @Parameter(description = "User ID for which to retrieve bet statistics", example = "user-12345")
            @PathVariable("userId") String userId,
            @Parameter(description = "Sorting order of the results, 'asc' or 'desc'", example = "asc")
            @RequestParam(name = "order", defaultValue = "asc") String order,
            @Parameter(description = "Maximum number of bets to return", example = "10")
            @RequestParam(name = "limit", defaultValue = "10") int limit) {

        return ResponseEntity.ok(statisticsService.getBetStatistics(userId, order, limit));
    }

    @GetMapping("/stats/leaderboard")
    @Operation(summary = "Retrieve the leaderboard of wallets",
               description = "Returns a list of WalletResponse objects ordered by balance or other criteria")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Leaderboard retrieved successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid query parameters"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<WalletResponse>> getLeaderboard(
            @Parameter(description = "Sorting order of the leaderboard, 'asc' or 'desc'", example = "desc")
            @RequestParam(name = "order", defaultValue = "desc") String order,
            @Parameter(description = "Maximum number of wallets to return", example = "10")
            @RequestParam(name = "limit", defaultValue = "10") int limit) {

        return ResponseEntity.ok(statisticsService.getLeaderboard(order, limit));
    }

    @GetMapping("/stats/leaderboard/top5")
    @Operation(summary = "Retrieve the top 5 wallets in the leaderboard",
               description = "Returns a list of the top 5 WalletResponse objects by balance")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Top 5 leaderboard retrieved successfully"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<WalletResponse>> getLeaderboardTop5() {
        return ResponseEntity.ok(statisticsService.getLeaderboardTop5());
    }
}
