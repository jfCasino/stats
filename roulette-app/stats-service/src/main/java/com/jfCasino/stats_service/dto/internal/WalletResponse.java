package com.jfCasino.stats_service.dto.internal;

import java.util.UUID;

public class WalletResponse {
    private UUID walletID;
    private int balance;

    public WalletResponse() {};

    public WalletResponse(UUID walletID, int balance) {
        this.walletID = walletID;
        this.balance = balance;
    }

    //getters and setters
    public UUID getwalletID() {
        return walletID;
    }

    public void setwalletID(UUID walletID) {
        this.walletID = walletID;
    }

    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
