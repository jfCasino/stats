package com.jfCasino.stats_service.dto.internal;

import com.jfCasino.stats_service.Entities.Bet;
import java.time.Instant;
import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
    name = "BetResponse",
    description = "Response representing the result of a single bet from any game"
)
public class BetResponse {

    @Schema(
        description = "Unique identifier of the bet",
        example = "3fa85f64-5717-4562-b3fc-2c963f66afa6"
    )
    private final UUID id;

    @Schema(
        description = "Unique identifier of the user who placed the bet",
        example = "user-12345"
    )
    private final String userId;

    @Schema(
        description = "Identifier of the game associated with the bet",
        example = "roulette"
    )
    private final String gameId;

    @Schema(
        description = "Total stake amount placed in the bet",
        example = "150"
    )
    private final int totalStake;

    @Schema(
        description = "Total winnings from the bet",
        example = "300"
    )
    private final int totalWinnings;

    @Schema(
        description = "Timestamp when the bet was created",
        example = "2026-01-03T10:15:30Z"
    )
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

