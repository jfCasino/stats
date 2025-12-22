package com.jfCasino.stats_service.dto.internal;

import com.jfCasino.stats_service.Entities.Bet;
import java.time.Instant;
import java.util.UUID;

public class BetResponse {

    private final UUID id;
    private final String userId;
    private final String gameId;
    private final int totalStake;
    private final int totalWinnings;
    private final Instant createdAt;

    public BetResponse(
            UUID id,
            String userId,
            String gameId,
            int totalStake,
            int totalWinnings,
            Instant createdAt
    ) {
        this.id = id;
        this.userId = userId;
        this.gameId = gameId;
        this.totalStake = totalStake;
        this.totalWinnings = totalWinnings;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getGameId() {
        return gameId;
    }

    public int getTotalStake() {
        return totalStake;
    }

    public int getTotalWinnings() {
        return totalWinnings;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    /**
     * Convenience factory method
     */
    public static BetResponse fromEntity(Bet bet) {
        return new BetResponse(
                bet.getId(),
                bet.getUserId(),
                bet.getGameId(),
                bet.getTotalStake(),
                bet.getTotalWinnings(),
                bet.getCreatedAt()
        );
    }
}

