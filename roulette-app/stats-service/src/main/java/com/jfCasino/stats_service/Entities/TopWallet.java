package com.jfCasino.stats_service.Entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "top_wallets")
public class TopWallet {

    @Id
    @Column(name = "wallet_id")
    private UUID walletId;

    @Column(name = "balance", nullable = false, precision = 19, scale = 4)
    private int balance;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    // Constructors
    public TopWallet() {
    }

    public TopWallet(UUID walletId, int balance, Instant updatedAt) {
        this.walletId = walletId;
        this.balance = balance;
        this.updatedAt = updatedAt;
    }

    // Getters and Setters
    public UUID getWalletId() {
        return walletId;
    }

    public void setWalletId(UUID walletId) {
        this.walletId = walletId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}
