package com.jfCasino.stats_service.Entities;


import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;
import java.math.BigDecimal;

@Entity
@Table(name = "bets",
        indexes = {
        @Index(
            name = "idx_bets_user_id_created_at",
            columnList = "userId, createdAt"
        )
    }
)
public class Bet {

    @Id
    @Column(name = "betId", nullable = false)
    private UUID id;

    @Column(name = "userId", nullable = false)
    private String userId;

    @Column(name = "gameID", nullable = false)
    private String gameId;

    @Column(name = "totalStake", nullable = false)
    private BigDecimal totalStake;

    @Column(name = "totalWinnings", nullable = false)
    private BigDecimal totalWinnings;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    // Constructors
    public Bet() {
    }

    public Bet(UUID id, String userId, String gameId, BigDecimal totalStake, BigDecimal totalWinnings, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.gameId = gameId;
        this.totalStake = totalStake;
        this.totalWinnings = totalWinnings;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public BigDecimal getTotalStake() {
        return totalStake;
    }

    public void setTotalStake(BigDecimal totalStake) {
        this.totalStake = totalStake;
    }

    public BigDecimal getTotalWinnings() {
        return totalWinnings;
    }

    public void setTotalWinnings(BigDecimal totalWinnings) {
        this.totalWinnings = totalWinnings;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}

